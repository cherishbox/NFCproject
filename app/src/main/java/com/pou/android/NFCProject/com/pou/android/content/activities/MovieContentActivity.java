package com.pou.android.NFCProject.com.pou.android.content.activities;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.pou.android.NFCProject.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lydia on 2015/7/19.
 */
public class MovieContentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        VideoView videoView = new VideoView(this);
        AssetManager am = getAssets();
        InputStream stream;
        String src = null;
        String tempPath = "";
        try {
            stream = am.open("b0001_m.mp4");
            if (stream == null)
                throw new RuntimeException("stream is null");

            File temp = File.createTempFile("mediaplayertmp", "dat");
            temp.deleteOnExit();
            tempPath = temp.getAbsolutePath();
            FileOutputStream out = new FileOutputStream(temp);
            byte buf[] = new byte[128];
            do {
                int numread = stream.read(buf);
                if (numread <= 0)
                    break;
                out.write(buf, 0, numread);
            } while (true);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        videoView.setVideoURI(Uri.parse(tempPath));
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();
        videoView.start();
        setContentView(videoView);
    }
}
