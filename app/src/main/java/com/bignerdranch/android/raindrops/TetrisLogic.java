package com.bignerdranch.android.raindrops;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

import static android.content.Context.WINDOW_SERVICE;

public class TetrisLogic extends View{
    private ArrayList<TetrisBlock> tetrisArray = new ArrayList<>();
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
        System.out.println(dm.widthPixels);


        tick++;
        if (tick % 25 == 0) {
            tetrisArray = new ArrayList<>();

            // tetris block, set size and color
            paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(8);
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.FILL);
            Random random = new Random();
            paint.setARGB(100, random.nextInt(), random.nextInt(), random.nextInt());
            TetrisBlock tetrisBlock;
            tetrisBlock = new TetrisBlock(0,0,108,108, paint);
            Rect rect = new Rect(tetrisBlock.getLeft(), tetrisBlock.getTop(), tetrisBlock.getRight(), tetrisBlock.getBottom());
            canvas.drawRect(rect, tetrisBlock.getPaint());

            tetrisArray.add(tetrisBlock);
            System.out.println(tetrisArray.size());
        }

        for (TetrisBlock tetrisBlock : tetrisArray) {
            tetrisBlock.setTop(tetrisBlock.getTop()+ 108);
            tetrisBlock.setBottom(tetrisBlock.getBottom()+ 108);
            Rect rect = new Rect(tetrisBlock.getLeft(), tetrisBlock.getTop(), tetrisBlock.getRight(), tetrisBlock.getBottom());
            canvas.drawRect(rect, tetrisBlock.getPaint());
        }

    }

}
