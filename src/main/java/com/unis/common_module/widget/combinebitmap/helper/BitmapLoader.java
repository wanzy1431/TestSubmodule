package com.unis.common_module.widget.combinebitmap.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;

import java.io.File;
import java.util.concurrent.ExecutionException;

public class BitmapLoader {
    private Context context;

    private volatile static BitmapLoader manager;

    public static BitmapLoader getInstance(Context context) {
        if (manager == null) {
            synchronized (BitmapLoader.class) {
                if (manager == null) {
                    manager = new BitmapLoader(context);
                }
            }
        }
        return manager;
    }


    private BitmapLoader(Context context) {
        this.context = context;
    }


    public void asyncLoad(final int index, final String url, final int reqWidth, final int reqHeight, final Handler handler) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = loadBitmap(url, reqWidth, reqHeight);
                if (bitmap != null) {
                    handler.obtainMessage(1, index, -1, bitmap).sendToTarget();
                } else {
                    handler.obtainMessage(2, index, -1, null).sendToTarget();
                }
            }
        };

        ThreadPool.getInstance().execute(task);
    }

    private Bitmap loadBitmap(String url, int reqWidth, int reqHeight) {
        FutureTarget<File> target = Glide.with(context)
                .asFile()
                .load(url)
                .submit(reqWidth, reqHeight);
        File imageFile = null;
        try {
            imageFile = target.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getPath(), getBitmapOption(2));
        return bitmap;
    }

    private BitmapFactory.Options getBitmapOption(int inSampleSize) {
        System.gc();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inSampleSize = inSampleSize;
        return options;
    }

}
