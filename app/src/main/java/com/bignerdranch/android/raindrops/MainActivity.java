package com.bignerdranch.android.raindrops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Raindrops cv;
    private AnimationHelper animationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cv = findViewById(R.id.raindrop);
        animationHelper = new AnimationHelper(cv, 50);
    }

    public void start(View view) {
        animationHelper.start();
    }

    public void stop(View view) {
        animationHelper.stop();
    }

//    public void startMoving() {
//        final Raindrop cv = findViewById(R.id.raindrop);
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // run code on a different thread.
//                while (true) {
//                    try {
//                        // 1000 msec : 1 sec
//                        // 50 msec : 0.02 sec (50 fps)
//                        Thread.sleep(50);
//                        cv.postInvalidate(); // redraw the view (call onDraw)
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        thread.start();
//
//    }

}
