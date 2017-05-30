package com.example.mike.michaelstrueorfalsemachine;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView = null;
    Button button = null;
    MediaPlayer player = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        textView = (TextView)findViewById(R.id.textView2);
        button = (Button)findViewById(R.id.button);
        player = MediaPlayer.create(this, R.raw.themesong);
        player.start();

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int num = (int) (Math.random()*100+1);
                if(num>50){
                    textView.setText("True");
                    textView.setTextColor(Color.GREEN);
                }else{
                    textView.setText("False");
                    textView.setTextColor(Color.RED);
                }
            }
        });

    }

    @Override
    public void onPause(){
        super.onPause();
        player.pause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
