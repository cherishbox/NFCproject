package com.pou.android.NFCProject.com.pou.android.content.activities;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

import com.pou.android.NFCProject.TabContentActivity;

import org.apache.http.util.EncodingUtils;

import java.io.InputStream;

import util.NfcLog;

/**
 * Created by lydia on 2015/7/19.
 */
public class TextContentActivity extends Activity{
    private static final String TAG = "TextContentActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);

        NfcLog.v(TAG, "Code : " + TabContentActivity.Code + ".txt");
        try
        {
            NfcLog.v(TAG, "00001. Code : " + TabContentActivity.Code + ".txt");
            AssetManager am = this.getAssets();
            InputStream is = am.open(TabContentActivity.Code+".txt");
            NfcLog.v(TAG, "00002. Code : " + TabContentActivity.Code + ".txt");
            int size = is.available();

            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String content= EncodingUtils.getString(buffer, "ISO-8859-1");
            // Convert the buffer into a string.
            String text = content;
            textView.setText(text);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        setContentView(textView);
    }
}
