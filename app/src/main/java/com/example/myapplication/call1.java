package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class call1 extends AppCompatActivity {
    Button bawer;
    TextView elopsedTimeLobel;
    MediaPlayer mp;
    int totalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call1);

        bawer = (Button) findViewById(R.id.bawer);
        elopsedTimeLobel = (TextView) findViewById(R.id.elopsedTimeLobel);



        isPlaying();
        createTimeLable(totalTime);
        setIntent(new Intent(call1.this, socned.class));


        bawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bawer = new Intent(call1.this, socned.class);
                startActivity(bawer);
                bawerClick();


            }
        });


        //thread (update postion bar & time line)
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mp != null) {
                    try {
                        Message msg = new Message();
                        msg.what = mp.getCurrentPosition();
                        handler.sendMessage(msg);

                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                    }


                }
            }
        }).start();

    }

    void isPlaying() {
        //media Player
        mp = MediaPlayer.create(this, R.raw.dontlstion);
        mp.setLooping(true);
        mp.seekTo(0);
        mp.setVolume(0.5f, 0.5f);
        totalTime = mp.getDuration();
        if (!mp.isPlaying()) {
            //Stopping
            mp.start();
            mp.setLooping(false);// for not Repet the mp3

        }

    }

    public void bawerClick() {
        mp.stop();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            int currentPosition = msg.what;


            //update labels
            String elapsedTime = createTimeLable(currentPosition);
            elopsedTimeLobel.setText(elapsedTime);


        }
    };

    public String createTimeLable(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp.stop();
    }


}
