package com.bignerdranch.android.raindrops;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class Raindrops extends View{
    private ArrayList<RainDrop> drops = new ArrayList<>();
    private int tick = 0;

    public Raindrops(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint rainColor = new Paint();
        rainColor.setARGB(180,0,0,180);
        rainColor.setStyle(Paint.Style.FILL_AND_STROKE);

        tick++;
        // add drop to the ArrayList
        if (tick % 25 ==0) {
            float rand = (float) Math.random() * canvas.getWidth();
            RainDrop rainDrop = new RainDrop(rand, 0, 10, rainColor);
            drops.add(rainDrop);
            System.out.println((drops.size()));
        }

        // draw everything in the drops
        for (RainDrop rainDrop : drops) {
            rainDrop.setY(rainDrop.getY()+ 10);
            canvas.drawCircle(rainDrop.getX(),rainDrop.getY(),rainDrop.getRadius(), rainDrop.getPaint());
        }

    }
}
