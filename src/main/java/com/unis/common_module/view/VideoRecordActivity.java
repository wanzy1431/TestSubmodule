package com.unis.common_module.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.SDCardUtils;
import com.unis.common_module.R;
import com.unis.common_module.R2;
import com.unis.common_module.base.BaseActivity;
import com.unis.common_module.utils.FileUtil;
import com.unis.common_module.utils.RxManager;
import com.unis.common_module.widget.RecordDialog;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

import static android.hardware.Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE;

/**
 * Copyright (C), 2020-2020, by UNIS company
 * FileName: VideoRecordActivity
 * Author: zhangyibin
 * Date: 2020/9/27 17:41
 * Description:
 * 录像
 */
public class VideoRecordActivity extends BaseActivity {
    private static final int CHOSE_FILE = 0x01;
    public static final int VIDEO_RESULT_CODE = 0X27;
    private static final String STATUS_NOMAL = "nomal";//无状态
    private static final String STATUS_RECORDING = "recording";//录制中
    private static final String STATUS_RECORDED = "recorded";//录制完毕
    private final static String VIDEO_BASE_PATH = "/com.unis.teacher/video/";
    @BindView(R2.id.videorecord_add_layout)
    LinearLayout mAdd_layout;
    @BindView(R2.id.videorecord_record_img)
    ImageView mRecord_img;
    @BindView(R2.id.videorecord_cancle_tv)
    TextView mCancle_tv;
    @BindView(R2.id.videorecord_time_layout)
    RelativeLayout mTime_layout;
    @BindView(R2.id.videorecord_time_tv)
    TextView mTime_tv;
    @BindView(R2.id.videorecord_cancle_img)
    ImageView mCancle_img;
    @BindView(R2.id.videorecord_record_tv)
    TextView mRerecord_tv;
    @BindView(R2.id.videorecord_commfirm_tv)
    TextView mCommfirm_tv;
    @BindView(R2.id.videorecord_sufaceview)
    SurfaceView mSf_view;
    private RxManager mRxManager;
    private int time;//录制时间
    private Timer mTimer;
    private SurfaceHolder mHolder;
    private MediaRecorder mediarecorder;//录制对象
    private Camera camera;//相机
    private String video_path;
    private MediaPlayer player;

    @Override
    protected void setLayout() {
        setView(R.layout.activity_videorecord, TYPE_NORMAL);
    }

    @Override
    protected void processData() {
        if (mRxManager == null)
            mRxManager = new RxManager();
        mRecord_img.setTag(STATUS_NOMAL);
        //重录功能点击事件
        mRerecord_tv.setOnClickListener(view -> {
            /*
             * 重录:
             * 录制按钮设置状态为nomal
             * 重录和确定按钮 隐藏
             * 录制、取消、添加按钮显示
             * */
            mRecord_img.setTag(STATUS_NOMAL);
            mRerecord_tv.setVisibility(View.GONE);
            mCommfirm_tv.setVisibility(View.GONE);
            mCancle_img.setVisibility(View.GONE);
            mCancle_tv.setVisibility(View.VISIBLE);
            mRecord_img.setVisibility(View.VISIBLE);
            mRecord_img.setImageResource(R.drawable.icon_startrecord);
            mAdd_layout.setVisibility(View.VISIBLE);
            stopPreView();//停止摄像预览
            stopPlay();//停止播放
            FileUtils.delete(video_path);//删除指定文件
            video_path = "";
            prepareMediaRecorder();
        });
        //确定功能点击事件
        mCommfirm_tv.setOnClickListener(view -> {
            //发送文件地址给webviewactivity
            mRxManager.post("video_filepath", video_path);
            finish();
        });
        prepareCamera();
    }

    @Override
    protected void back() {

    }

    //camera准备
    private void prepareCamera() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//屏幕常亮
        mHolder = mSf_view.getHolder();
        mHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (player == null)
                    prepareMediaRecorder();
                else
                    play();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                //录制中销毁改变状态，其他保持原状
                if (mRecord_img.getTag().toString().equals(STATUS_RECORDING))
                    stopRecord();

            }
        });
        // setType必须设置，要不出错.设置缓冲类型
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }


    @OnClick({R2.id.videorecord_add_layout, R2.id.videorecord_cancle_tv, R2.id.videorecord_record_img})
    public void onViewClicked(View view) {
        if (view.getId() == R.id.videorecord_add_layout) {
            //添加视频
            //跳转系统文件选择库
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            ((Activity) mContext).startActivityForResult(intent, CHOSE_FILE);
        } else if (view.getId() == R.id.videorecord_cancle_tv) {
            //取消
            finish();
        } else if (view.getId() == R.id.videorecord_record_img) {
            switch (mRecord_img.getTag().toString()) {
                case STATUS_NOMAL:
                    /**
                     *无状态、默认状态 点击开始录像
                     * 1.改变imgtag为录制中、改变按钮图片
                     * 2.隐藏相关控件(取消、添加)
                     * 3.倒计时弹弹窗 时间设置为00
                     * 4.开始录制
                     */
                    mRecord_img.setTag(STATUS_RECORDING);
                    mRecord_img.setImageResource(R.drawable.icon_recording);
                    mCancle_tv.setVisibility(View.GONE);
                    mAdd_layout.setVisibility(View.GONE);
                    mTime_layout.setVisibility(View.VISIBLE);
                    mTime_tv.setText("00:00");
                    /*
                     * 开始倒计时
                     * 初始化变量
                     * */
                    time = 0;
                    mTimer = new Timer();
                    mTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            time++;
                            ((Activity) mContext).runOnUiThread(() -> mTime_tv.setText(formatRecordTime(time)));
                        }
                    }, 1000, 1000);
                    try {
                        mediarecorder.prepare();
                        mediarecorder.start();
                    } catch (Exception e) {
                    }
                    break;
                case STATUS_RECORDING:
                    stopRecord();
                    break;
            }
        }
    }

    /*
     * 录制准备
     * */
    private void prepareMediaRecorder() {
        //surfaceview准备完毕
        mediarecorder = new MediaRecorder();
        mediarecorder.setOnErrorListener(null);
        mediarecorder.setOnInfoListener(null);
        mediarecorder.setPreviewDisplay(null);
        camera = Camera.open();
        Camera.Size previewSize = null;
        try {
            camera.setDisplayOrientation(90);   //设置camera预览的角度，因为默认图片是倾斜90度的
            camera.setPreviewDisplay(mSf_view.getHolder());   //设置holder主要是用于surfaceView的图片的实时预览，以及获取图片等功能
            Camera.Parameters parameters = camera.getParameters();
            previewSize = parameters.getPreviewSize();
            parameters.setFocusMode(FOCUS_MODE_CONTINUOUS_PICTURE);
            camera.setParameters(parameters);
            camera.startPreview();                  //开始预览
            camera.unlock();
        } catch (IOException e) {
            camera.release();                   //释放
        }
        mediarecorder.setCamera(camera);
        mediarecorder.reset();
        mediarecorder.setPreviewDisplay(mSf_view.getHolder().getSurface());
        // 设置录制视频源为Camera(相机)
        mediarecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediarecorder.setVideoSource(MediaRecorder.VideoSource.DEFAULT);
        // 设置录制完成后视频的封装格式THREE_GPP为3gp.MPEG_4为mp4
        mediarecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        // 设置录制的视频编码
        mediarecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264);
        mediarecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        // 设置视频录制的分辨率。必须放在设置编码和格式的后面，否则报错,而且这个值要适配
        //手机，不然也会在后面stop方法报错！
        mediarecorder.setVideoSize(previewSize.width, previewSize.height);
        // 设置录制的视频帧率。必须放在设置编码和格式的后面，否则报错，这样设置变清晰
        mediarecorder.setVideoEncodingBitRate(5 * 1024 * 1024);
        //设置摄像角度
        mediarecorder.setOrientationHint(90);
        // 设置帧率
        mediarecorder.setVideoFrameRate(30);
        video_path = getVideoBasePath();
        mediarecorder.setOutputFile(video_path);
    }

    /*
     * 停止录制
     * */
    private void stopRecord() {
        /*
         * 录制中:
         * 录制按钮tag设置为录制完毕
         * 计时器控件隐藏、倒计时取消
         * 录制按钮隐藏、qu
         * 显示重录、返回、确定按钮
         * 录制结束
         * mediaplayer 准备
         * */
        mRecord_img.setTag(STATUS_RECORDED);
        if (mTimer != null)
            mTimer.cancel();
        mTime_layout.setVisibility(View.GONE);
        mRecord_img.setVisibility(View.GONE);
        mRerecord_tv.setVisibility(View.VISIBLE);
        mCancle_img.setVisibility(View.VISIBLE);
        mCommfirm_tv.setVisibility(View.VISIBLE);
        mediarecorder.stop();
        mediarecorder.release();
        play();//播放视屏
    }

    /*
     * 播放视频
     * */
    private void play() {
        //camera相关暂停
        stopPreView();
        //设置播放视频
        try {
            player = new MediaPlayer();
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource(video_path);
            player.setDisplay(mHolder);
            player.prepare();
            player.start();
            //循环播放
            player.setOnCompletionListener(mp -> {
                mp.seekTo(0);
                mp.start();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //停止播放-资源释放
    private void stopPlay() {
        if (player != null) {
            if (player.isPlaying())
                player.stop();
            player.release();
            player = null;
        }
    }

    //相机停止预览并释放相关资源
    private void stopPreView() {
        //退出释放资源
        if (camera != null) {
            camera.lock();
            //释放资源
            camera.stopPreview();   // stop preview
            camera.release();       // Release camera resources
            camera = null;
        }
        if (mediarecorder != null) {
            mediarecorder.release();
            mediarecorder = null;
        }
        /*if (mHolder != null) {
            mHolder.addCallback(null);
        }*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RecordDialog.CHOSE_FILE && resultCode == RESULT_OK) {
            //选择文件返回数据
            String path = FileUtil.getPathFromUri(mContext, data.getData());
            //发送文件地址给webviewactivity
            mRxManager.post("video_filepath", path);
            finish();
        }
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopPreView();//释放相机资源
        stopPlay();//释放播放资源
        if (camera != null)
            camera = null;
        if (mHolder != null) {
            mHolder.addCallback(null);
        }
    }

    private String getFileName() {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("_yyyyMMddHHmmss");
        TimeZone gmt = TimeZone.getTimeZone("GMT+8");//关键所在
        sdf.setTimeZone(gmt);
        sdf.setLenient(true);
        return sdf.format(new Date());
    }

    private String getVideoBasePath() {
        String fileName = getFileName();
        if (fileName == null) {
            throw new NullPointerException("fileName can't be null");
        }
        if (!SDCardUtils.isSDCardEnableByEnvironment()) {
            throw new IllegalStateException("sd card no found");
        }

        String mAudioWavPath = "";
        if (SDCardUtils.isSDCardEnableByEnvironment()) {
            if (!fileName.endsWith(".mp4")) {
                fileName = fileName + ".mp4";
            }
            String fileBasePath = Environment.getExternalStorageDirectory().getAbsolutePath() + VIDEO_BASE_PATH;
            File file = new File(fileBasePath);
            //创建目录
            if (!file.exists()) {
                file.mkdirs();
            }
            mAudioWavPath = fileBasePath + fileName;
        }
        return mAudioWavPath;
    }
}
