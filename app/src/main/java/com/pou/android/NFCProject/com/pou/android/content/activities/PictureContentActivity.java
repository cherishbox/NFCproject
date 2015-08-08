package com.pou.android.NFCProject.com.pou.android.content.activities;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.pou.android.NFCProject.TabContentActivity;

import java.io.IOException;
import java.io.InputStream;

import util.NfcLog;

/**
 * Created by lydia on 2015/7/19.
 */
public class PictureContentActivity extends Activity {

    private static final String TAG = "PictureContentActivity";

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NfcLog.v(TAG, "onCreate()");

        imageView = new ImageView(this);
        imageView.setImageBitmap(getBitmapFromAssets(TabContentActivity.Code + ".jpg"));
        NfcLog.v(TAG, TabContentActivity.Code + ".jpg");
        setContentView(imageView);
    }

    private Bitmap getBitmapFromAssets(String file)
    {
        try
        {
            NfcLog.v(TAG, "get pic");
            AssetManager am = getAssets();
            InputStream is = am.open(file);
            Bitmap bmp = BitmapFactory.decodeStream(is);
            NfcLog.v(TAG, "return pic");
            return bmp;
        }
        catch (IOException e)
        {
            NfcLog.v(TAG, "return pic error");
            e.printStackTrace();
            return null;
        }
    }
}
