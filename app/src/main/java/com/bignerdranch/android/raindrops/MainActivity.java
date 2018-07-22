package com.bignerdranch.android.raindrops;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    private TetrisLogic tetrisLogic;
    private AnimationHelper animationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tetrisLogic = findViewById(R.id.tetris);
        animationHelper = new AnimationHelper(tetrisLogic, 50);
        start(tetrisLogic);
    }

    public void start(View view) {
        animationHelper.start();
    }

    public void stop(View view) {
        animationHelper.stop();
    }

    public void startMoving() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // run code on a different thread.
                while (true) {
                    try {
                        // 1000 msec : 1 sec
                        // 50 msec : 0.02 sec (50 fps)
                        Thread.sleep(50);
                        tetrisLogic.postInvalidate(); // redraw the view (call onDraw)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();

    }

}
