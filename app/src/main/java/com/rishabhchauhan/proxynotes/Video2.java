package com.rishabhchauhan.proxynotes;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video2 extends AppCompatActivity {

    ProgressDialog pDialog;
    VideoView videoview;

    String VideoURL = "http://proxynotes.com/assignmnet/test.mp4?videoid=0001";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.videoview_main);

        videoview = (VideoView) findViewById(R.id.VideoView);

        pDialog = new ProgressDialog(Video2.this);

        pDialog.setTitle("Video 1");

        pDialog.setMessage("Buffering...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);

        pDialog.show();

        try {

            MediaController mediacontroller = new MediaController(
                    Video2.this);
            mediacontroller.setAnchorView(videoview);

            Uri video = Uri.parse(VideoURL);
            videoview.setMediaController(mediacontroller);
            videoview.setVideoURI(video);

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        videoview.requestFocus();



        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mp) {
                pDialog.dismiss();
                videoview.start();
            }
        });

    }
}
