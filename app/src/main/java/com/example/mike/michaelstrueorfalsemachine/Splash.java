package com.example.mike.michaelstrueorfalsemachine;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by mike on 8/10/2015.
 */
public class Splash extends Activity {

    MediaPlayer player = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        player = MediaPlayer.create(this, R.raw.drumroll);
        player.start();

        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent("android.intent.action.mainActivity");
                    startActivity(intent);
                    player.release();
                }
            }
        };
        timer.start();
    }

    @Override
    public void onPause(){
        super.onPause();
        player.pause();
    }
}
