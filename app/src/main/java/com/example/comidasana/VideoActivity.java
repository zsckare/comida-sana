package com.example.comidasana;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Button btn = (Button)findViewById(R.id.button5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String path = "android.resource://"+getPackageName()+"/raw/myvideo";
        VideoView videoView = (VideoView)findViewById(R.id.videoView);
        Uri uri= Uri.parse(path);
        videoView.setVideoURI(uri);
        videoView.start();




    }
}