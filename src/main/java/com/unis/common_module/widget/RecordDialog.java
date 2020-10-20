package com.unis.common_module.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blankj.utilcode.util.FileUtils;
import com.carlos.voiceline.mylibrary.VoiceLineView;
import com.unis.common_module.R;
import com.unis.common_module.utils.LogUtil;
import com.unis.common_module.utils.RxManager;
import com.unis.common_module.widget.record.AudioRecordHelper;
import com.unis.common_module.widget.record.PcmToWav;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Copyright (C), 2020-2020, by UNIS company
 * FileName: RecordDialog
 * Author: zhangyibin
 * Date: 2020/9/23 17:28
 * Description:
 */
public class RecordDialog extends Dialog {
    public static final int CHOSE_FILE = 0x01;
    private static final String STATUS_NOMAL = "nomal";//未录音
    private static final String STATUS_RECORDING = "recording"; //录音中
    private static final String STATUS_RECORDED = "recorded";//录音完毕
    private static final String STATUS_RERECORD = "rerecord";//重录
    private static final String STATUS_PLAYING = "playing";//播放中
    private ImageView mRecord_img;//录音按钮
    private Context mContext;
    private TextView mDuration_tv, mStatus_tv, mStartDuration, mEndduration;//时长
    private VoiceLineView mVocieline;//声波控件
    private AudioRecordHelper mAudioHelper;
    private RelativeLayout mProgress_layout;
    private LinearLayout mAdd_layout, mRerecord_layout, mDelete_layout;
    private String pcmfilePath;//pcm文件路径
    private String wavfilePaht;//wav文件路径
    private MediaPlayer player;//音频播放器
    private SeekBar mSeekBar;//进度条
    private Timer timer;//定时器
    private RxManager mRxManager;

    public RecordDialog(@NonNull Context context) {
        super(context, R.style.ios_style_dialog);
        this.mContext = context;
        mRxManager = new RxManager();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_dialog_record);
        Window dialogwindow = getWindow();
        WindowManager.LayoutParams params = dialogwindow.getAttributes();
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        params.width = displayMetrics.widthPixels;
        dialogwindow.setAttributes(params);
        dialogwindow.setGravity(Gravity.BOTTOM);
        dialogwindow.setWindowAnimations(R.style.menu_anim_style);
        initView();
        setOnDismissListener(dialog -> {
            if (player != null && player.isPlaying()) {
                //播放中-暂停操作
                stopPlay();
            }
        });
    }

    private void initView() {
        mAudioHelper = AudioRecordHelper.getAudioHelper();
        //添加音频按钮
        findViewById(R.id.dialog_record_add_layout).setOnClickListener(v -> {
            //跳转系统文件选择库
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            ((Activity) mContext).startActivityForResult(intent, CHOSE_FILE);
        });
        //录音按钮
        mRecord_img = findViewById(R.id.dialog_record_img);
        mRecord_img.setTag(STATUS_NOMAL);
        mRecord_img.setOnClickListener(v -> {
            switch (mRecord_img.getTag().toString()) {
                case STATUS_NOMAL:
                case STATUS_RERECORD:
                    //去录音
                    startRecord();
                    break;
                case STATUS_RECORDING:
                    //结束录音
                    stopRecord();
                    break;
                case STATUS_RECORDED:
                case STATUS_PLAYING:
                    //播放录音
                    playerRecord();
                    break;
            }
        });
        //时长
        mDuration_tv = findViewById(R.id.dialog_record_duration_tv);
        //声波控件
        mVocieline = findViewById(R.id.dialog_record_vl);
        //进度
        mProgress_layout = findViewById(R.id.dialog_record_progreess_layout);
        //添加音频layout
        mAdd_layout = findViewById(R.id.dialog_record_add_layout);
        //重录layout
        mRerecord_layout = findViewById(R.id.dialog_record_re_layout);
        mRerecord_layout.setOnClickListener(v -> {
            dialoginvalite();//页面初始化
        });
        //保存layout
        mDelete_layout = findViewById(R.id.dialog_record_delete_layout);
        mDelete_layout.setOnClickListener(v -> {
            deleteRecord();
        });
        //状态tv
        mStatus_tv = findViewById(R.id.dialog_record_status_tv);
        //进度条
        mSeekBar = findViewById(R.id.dialog_record_progress);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                    mStartDuration.setText(formatRecordTime(player.getCurrentPosition() / 1000));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                player.seekTo(seekBar.getProgress());
                mStartDuration.setText(formatRecordTime(player.getCurrentPosition() / 1000));
            }
        });
        //开始时长
        mStartDuration = findViewById(R.id.dialog_record_startduration);
        //总时长
        mEndduration = findViewById(R.id.dialog_record_endduration);
    }

    //播放录音
    private void playerRecord() {
        switch (mRecord_img.getTag().toString()) {
            case STATUS_RECORDED:
                //录制完毕未播放
                player.start();
                mRecord_img.setImageResource(R.drawable.icon_playing);
                mRecord_img.setTag(STATUS_PLAYING);
                mSeekBar.setMax(player.getDuration());
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        ((Activity) mContext).runOnUiThread(() -> mSeekBar.setProgress(player.getCurrentPosition()));
                        ((Activity) mContext).runOnUiThread(() -> mStartDuration.setText(formatRecordTime(player.getCurrentPosition() / 1000)));
                    }
                }, 0, 1000);
                break;
            case STATUS_PLAYING:
                //播放中
                if (player.isPlaying()) {
                    //播放中-暂停操作
                    stopPlay();
                } else {
                    //暂停中-播放
                    player.start();
                    mRecord_img.setImageResource(R.drawable.icon_playing);
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            ((Activity) mContext).runOnUiThread(() -> mSeekBar.setProgress(player.getCurrentPosition()));
                            ((Activity) mContext).runOnUiThread(() -> mStartDuration.setText(formatRecordTime(player.getCurrentPosition() / 1000)));
                        }
                    }, 0, 1000);
                }
                break;
        }
    }

    //停止录音
    private void stopRecord() {
        setCanceledOnTouchOutside(true);
        mAdd_layout.setEnabled(true);
        //状态改变
        mAudioHelper.releaseRecord();
        mRecord_img.setTag(STATUS_RECORDED);
        mRecord_img.setImageResource(R.drawable.icon_player);
        mVocieline.setVisibility(View.GONE);
        mProgress_layout.setVisibility(View.VISIBLE);
        mDuration_tv.setVisibility(View.GONE);
        mAdd_layout.setVisibility(View.GONE);
        mRerecord_layout.setVisibility(View.VISIBLE);
        mDelete_layout.setVisibility(View.VISIBLE);
        mStatus_tv.setText("点击预览");
        //录音转变
        pcmfilePath = mAudioHelper.getPcmFilePath();//pcm文件路径
        wavfilePaht = mAudioHelper.getWavfilePath();//wav文件路径
        PcmToWav.makePCMFileToWAVFile(pcmfilePath, wavfilePaht, true);//文件转换合成
        //音频准备
        player = new MediaPlayer();
        player.setOnCompletionListener(mp -> {
            mRecord_img.setImageResource(R.drawable.icon_player);
            mSeekBar.setProgress(0);
            mStartDuration.setText("00:00");
            if (timer != null)
                timer.cancel();
        });
        try {
            player.setDataSource(wavfilePaht);
            player.prepare();
        } catch (IOException e) {
            LogUtil.e(e.getMessage());
            e.printStackTrace();
        }
        mStartDuration.setText(formatRecordTime(player.getCurrentPosition() / 1000));
        mEndduration.setText(formatRecordTime(player.getDuration() / 1000));
        LogUtil.e(player.getDuration() + "");
        mRxManager.post("audio_filepath", wavfilePaht + "," + player.getDuration() / 1000);//发送地址到activity

    }

    //开始录音
    private void startRecord() {
        //设置录制状态
        mRecord_img.setTag(STATUS_RECORDING);
        //录音按钮切换
        mRecord_img.setImageResource(R.drawable.icon_recording);
        //时长设置为00:00
        mDuration_tv.setText("00:00");
        //声波控件显示
        mVocieline.setVisibility(View.VISIBLE);
        //开始录音
        mAudioHelper.startRecord(new AudioRecordHelper.OnAudioRecordlListener() {
            @Override
            public void recordStart() {
                setCanceledOnTouchOutside(false);
                mAdd_layout.setEnabled(false);
            }

            @Override
            public void dbResult(int db) {
                ((Activity) mContext).runOnUiThread(() -> mVocieline.setVolume(db));
            }

            @Override
            public void recordTime(int recordTime) {
                if (recordTime != 600)
                    ((Activity) mContext).runOnUiThread(() -> mDuration_tv.setText(formatRecordTime(recordTime)));
                else {
                    stopRecord();
                }
            }

            @Override
            public void recordFailed(Exception e) {

            }
        });
    }

    //删除录音
    public void deleteRecord() {
        dialoginvalite();//页面初始化
        FileUtils.delete(wavfilePaht);//文件删除
        mRxManager.post("dialog_delete", wavfilePaht);//通知H5文件删除
    }

    //停止播放
    private void stopPlay() {
        player.pause();
        mRecord_img.setImageResource(R.drawable.icon_player);
        if (timer != null)
            timer.cancel();
    }

    //dialog页面初始化
    private void dialoginvalite() {
        mRecord_img.setTag(STATUS_RERECORD);
        mRecord_img.setImageResource(R.drawable.icon_startrecord);
        mRerecord_layout.setVisibility(View.INVISIBLE);
        mDelete_layout.setVisibility(View.GONE);
        mAdd_layout.setVisibility(View.VISIBLE);
        mDuration_tv.setVisibility(View.VISIBLE);
        mVocieline.setVisibility(View.INVISIBLE);
        mProgress_layout.setVisibility(View.GONE);
        mDuration_tv.setText(mContext.getString(R.string.web_maxtime_record));
        mStatus_tv.setText("点击开始录音");
        player.reset();
        player.release();
        player = null;
        if (timer != null)
            timer.cancel();
        mSeekBar.setProgress(0);
        mSeekBar.setMax(0);
    }

    //时间格式转换
    private String formatRecordTime(int recordTime) {
        if (recordTime < 10) {
            return "00:0" + recordTime;
        } else if (recordTime < 60) {
            return "00:" + recordTime;
        } else {
            int minute = recordTime / 60;
            int second = recordTime % 60;
            if (minute < 10) {
                if (second < 10) {
                    return "0" + minute + ":" + "0" + second;
                } else {
                    return "0" + minute + ":" + second;
                }
            } else {
                if (second < 10) {
                    return minute + ":" + "0" + second;
                } else {
                    return minute + ":" + second;
                }
            }
        }
    }
}
