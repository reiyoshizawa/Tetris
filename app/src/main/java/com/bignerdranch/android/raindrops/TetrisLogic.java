package com.bignerdranch.android.raindrops;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

import static android.content.Context.WINDOW_SERVICE;

public class TetrisLogic extends View{
    private ArrayList<TetrisBlock> tetrisArray = new ArrayList<>();
    private TetrisBlock setTetrisBlock;
    private Paint paint;
    private int tick = 0;

    public TetrisLogic(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // get screen width, screen height
        DisplayMetrics dm = new DisplayMetrics();
        dm = getContext().getResources().getDisplayMetrics();
        int heightPixels = dm.heightPixels;
//        System.out.println(dm.widthPixels);
//        System.out.println(dm.heightPixels);


        tick++;
        if (tick % 108 == 0) {
            tetrisArray = new ArrayList<>();

            // tetris block, set size and color
            paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(8);
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.FILL);
//            Random random = new Random();
//            paint.setARGB(100, random.nextInt(), random.nextInt(), random.nextInt());
            TetrisBlock tetrisBlock;
            tetrisBlock = new TetrisBlock(0,0,108,108, paint);
            tetrisArray.add(tetrisBlock);
            System.out.println(tetrisArray.size());
        }

        int tetrisSize = 0;
        for (TetrisBlock tetrisBlock : tetrisArray) {
            tetrisBlock.setTop(tetrisBlock.getTop()+ 20);
            tetrisBlock.setBottom(tetrisBlock.getBottom()+ 20);
            int tetrisBottom = tetrisBlock.getBottom();
            tetrisSize += tetrisBottom;
            Rect rect = new Rect(tetrisBlock.getLeft(), tetrisBlock.getTop(), tetrisBlock.getRight(), tetrisBlock.getBottom());
            canvas.drawRect(rect, tetrisBlock.getPaint());
        }

        // tetris is set in the bottom
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        setTetrisBlock = new TetrisBlock(0,1592,108,1700, paint);
        Rect r = new Rect(setTetrisBlock.getLeft(), setTetrisBlock.getTop(), setTetrisBlock.getRight(), setTetrisBlock.getBottom());
        canvas.drawRect(r, setTetrisBlock.getPaint());

    }

    public boolean onTouchEvent(MotionEvent event) {

        Log.d("TouchEvent", "X:" + event.getX() + ",Y:" + event.getY());

        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                Log.d("TouchEvent", "getAction()" + "ACTION_DOWN");
//                break;
//            case MotionEvent.ACTION_UP:
//                Log.d("TouchEvent", "getAction()" + "ACTION_UP");
//                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("TouchEvent", "getAction()" + "ACTION_MOVE");
                break;
//            case MotionEvent.ACTION_CANCEL:
//                Log.d("TouchEvent", "getAction()" + "ACTION_CANCEL");
//                break;
        }
        return true;
    }


}
