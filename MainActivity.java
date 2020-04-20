package com.example.stopwatch;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
    }


    private int seconds = 0;
    private boolean running;



    public void onClickStart(View view)
    {
        running = true;
    }

    public void onClickStop(View view)
    {
        running = false;
    }

    public void onClickReset(View view)
    {
        running = false;
        seconds = 0;
    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    private void runTimer()
    {
        final TextView displayText = (TextView)findViewById(R.id.time_view);

        // This is the syntax for making a delayed method
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                //Do something after 1000ms
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                @SuppressLint("DefaultLocale") String text_time = String.format("%d:%02d:%02d", hours, minutes, secs);
                displayText.setText(text_time);

                if (running)
                    seconds++;
                handler.postDelayed(this, 1000);
            }
        });
        // End of the delayed method

    }

}
