package com.unis.common_module.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.os.Vibrator;

import java.io.IOException;

public class BeepVibrateUtils {
    private Context context;
    private MediaPlayer mMediaPlayer;
    private boolean mPlayBeep = false;
    private float BEEP_VOLUME = 0.1F;
    private long VIBRATE_DURATION = 200L;
//    private boolean isShowSound=false;
//    private boolean isShowVibrator=false;

    public BeepVibrateUtils(Context context) {
        this.context = context;
        initBeep();
    }

    private void initBeep() {
        mPlayBeep = shouldBeep(context);
        //设置声音基本设置
        if (mPlayBeep) {
            mMediaPlayer = buildMediaPlayer(context);
        }
    }

    public void playBeepSoundAndVibrate(Boolean isBeepSound, Boolean isVibrate) {
        if (context == null) {
            return;
        }
        if (isBeepSound) {
            if (shouldBeep(context)) {
                if (mMediaPlayer == null) {
                    mMediaPlayer = buildMediaPlayer(context);
                }
                mMediaPlayer.start();
            }
        }
        if (isVibrate) {
            if (shouldBeep(context)) {
                Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                //震动一次
                vibrator.vibrate(VIBRATE_DURATION);
                //第一个参数，指代一个震动的频率数组。每两个为一组，每组的第一个为等待时间，第二个为震动时间。
                //        比如  [2000,500,100,400],会先等待2000毫秒，震动500，再等待100，震动400
                //第二个参数，repest指代从 第几个索引（第一个数组参数） 的位置开始循环震动。
                //会一直保持循环，我们需要用 vibrator.cancel()主动终止
                //vibrator.vibrate(new long[]{300,500},0);
            }
        }

    }

//    public void setVibrator(boolean isShowVibrator){
//        this.isShowVibrator=isShowVibrator;
//    }
//
//    public void setSound(boolean isShowSound){
//        this.isShowSound=isShowSound;
//    }

    private boolean shouldBeep(Context context) {
        AudioManager audioService = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        if (audioService.getRingerMode() != AudioManager.RINGER_MODE_NORMAL) {
            return false;
        } else {
            return true;
        }
    }

    private MediaPlayer buildMediaPlayer(Context context) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        //Z Xing 声音文件是放在raw下的
        //val file = context.resources.openRawResource(R.raw.beep)
        //我这里直接用系统默认声音提示
        try {
            mediaPlayer.setDataSource(context, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    if (what == MediaPlayer.MEDIA_ERROR_SERVER_DIED) {
                        // we are finished, so put up an appropriate error toast if required and finish
                        //context.finish()
                    } else {
                        // possibly media player error, so release and recreate
                        if (mMediaPlayer != null) {
                            mMediaPlayer.stop();
                            mMediaPlayer.release();
                            mMediaPlayer = null;
                        }
                        initBeep();
                    }
                    return true;
                }
            });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer player) {
                    player.seekTo(0);
                }
            });
            //设置该Activity中音量控制键控制的音频流
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);//媒体音量
            mediaPlayer.setLooping(false);
            //左右声道声音大小
            mediaPlayer.setVolume(BEEP_VOLUME, BEEP_VOLUME);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mediaPlayer;
    }
}
