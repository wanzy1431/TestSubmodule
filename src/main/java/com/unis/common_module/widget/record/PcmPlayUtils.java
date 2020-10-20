package com.unis.common_module.widget.record;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;

import com.unis.common_module.utils.LogUtil;
import com.unis.common_module.utils.ThreadPoolManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class PcmPlayUtils {
    private static final String TAG = "PcmPlayUtils";
    private static boolean isPlaying;
    private static boolean isStop = false;

    public static void playPcmById(String id) {
        isStop = false;
        isPlaying = true;
        ThreadPoolManager.newInstance().addExecuteTask(() -> {
            int bufferSize = AudioTrack.getMinBufferSize(16000, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
            AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 16000, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT, bufferSize, AudioTrack.MODE_STREAM);
            FileInputStream fis = null;
            try {
                audioTrack.play();
                List<String> pcmFilePaths = VoiceFileUtils.getPcmFilePaths();
                for (String pcmFilePath : pcmFilePaths) {
                    LogUtil.e(TAG + "：" + "playPcmById: " + pcmFilePath);
                    fis = new FileInputStream(pcmFilePath);
                    byte[] buffer = new byte[bufferSize];
                    int len = 0;
                    while ((len = fis.read(buffer)) != -1 && !isStop) {
                        audioTrack.write(buffer, 0, len);
                        LogUtil.e(TAG + "：" + "playPcmById: " + len);
                    }
                    if (isStop)
                        break;
                }
            } catch (Exception e) {
                LogUtil.e(TAG + "：" + "playPCMRecord: e : " + e);
            } finally {
                LogUtil.e(TAG + "：" + "playPcmById:finally ");
                isPlaying = false;
                isStop = false;
                if (audioTrack != null) {
                    audioTrack.stop();
                    audioTrack = null;
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static boolean isPlaying() {
        return isPlaying;
    }

    public static void stopPcmPlay() {
        isStop = true;
        isPlaying = false;
    }
}
