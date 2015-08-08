package com.pou.android.NFCProject;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.nfc.Tag;
import android.os.Bundle;
import android.widget.TabHost;

import com.pou.android.NFCProject.com.pou.android.content.activities.MovieContentActivity;
import com.pou.android.NFCProject.com.pou.android.content.activities.PictureContentActivity;
import com.pou.android.NFCProject.com.pou.android.content.activities.TextContentActivity;

import util.NfcLog;

/**
 * Created by lydia on 2015/7/19.
 */
public class TabContentActivity extends TabActivity {
    private static final String TAG = "TAB_CONTENT_ACTIVITY";

    public static String Code = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NfcLog.v(TAG, "TAb content onCreate");
        Bundle bundle = this.getIntent().getExtras();

        String code = bundle.getString("code");
        NfcLog.v(TAG, code);

        Code = code;

        Resources ressources = getResources();
        TabHost tabHost = getTabHost();

        // Android tab
        Intent intentAndroid = new Intent().setClass(this, PictureContentActivity.class);
        TabHost.TabSpec tabSpecAndroid = tabHost
                .newTabSpec("PicContent")
                .setIndicator("", ressources.getDrawable(R.drawable.icon_android_config))
                .setContent(intentAndroid);

        // Apple tab
        Intent intentApple = new Intent().setClass(this, TextContentActivity.class);
        TabHost.TabSpec tabSpecApple = tabHost
                .newTabSpec("TextContent")
                .setIndicator("", ressources.getDrawable(R.drawable.icon_apple_config))
                .setContent(intentApple);

        // Windows tab
        Intent intentWindows = new Intent().setClass(this, MovieContentActivity.class);
        TabHost.TabSpec tabSpecWindows = tabHost
                .newTabSpec("MovieContent")
                .setIndicator("", ressources.getDrawable(R.drawable.icon_windows_config))
                .setContent(intentWindows);


        // add all tabs
        tabHost.addTab(tabSpecAndroid);
        tabHost.addTab(tabSpecApple);
        tabHost.addTab(tabSpecWindows);

        //set Windows tab as default (zero based)
        tabHost.setCurrentTab(0);
    }

}
