package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class socned extends AppCompatActivity {
    Button liston, eat, sleep;
    MediaPlayer mp;
    int totalTime;
    TextView elopsedTimeLobel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.socned);
        liston = (Button) findViewById(R.id.dont_liston);
        eat = (Button) findViewById(R.id.eat);

        sleep = (Button) findViewById(R.id.dont_sleep);

        elopsedTimeLobel = (TextView) findViewById(R.id.elopsedTimeLobel);

        mp = MediaPlayer.create(this, R.raw.dontlstion);


        mp = MediaPlayer.create(this, R.raw.dontlstion);
        mp.setLooping(true);
        mp.seekTo(0);
        totalTime = mp.getDuration();


        liston.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent liston = new Intent(socned.this, call1.class);
                startActivity(liston);

                //media Player
                mp.setLooping(true);
                mp.seekTo(0);
                mp.setVolume(0.5f, 0.5f);
                totalTime = mp.getDuration();


                if (!mp.isPlaying()) {
                    mp.setLooping(false);// for not Repet the mp3
                } else {
                    mp.stop();
                }
            }
        });


        eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent eat = new Intent(socned.this, call1.class);
                startActivity(eat);

                //media Player
                mp.setLooping(true);
                mp.seekTo(0);
                mp.setVolume(0.5f, 0.5f);
                totalTime = mp.getDuration();


                if (!mp.isPlaying()) {
                    mp.setLooping(false);// for not Repet the mp3


                } else {
                    mp.stop();

                }

            }
        });

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sleep = new Intent(socned.this, call1.class);
                startActivity(sleep);
                //media Player
                mp.setLooping(true);
                mp.seekTo(0);
                mp.setVolume(0.5f, 0.5f);
                totalTime = mp.getDuration();


                if (!mp.isPlaying()) {
                    mp.setLooping(false);// for not repeat the mp3
                } else {
                    mp.stop();
                }
            }
        });
    }

    private String createTimeLable(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }
}