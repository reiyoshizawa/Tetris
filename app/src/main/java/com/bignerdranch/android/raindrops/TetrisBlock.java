package com.bignerdranch.android.raindrops;

import android.graphics.Paint;

import java.util.Random;

public class TetrisBlock  {
    // size and color
    private int left;
    private int top;
    private int right;
    private int bottom;
    Paint paint = new Paint();

    public TetrisBlock(int left, int top, int right, int bottom, Paint paint) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.paint = paint;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}
