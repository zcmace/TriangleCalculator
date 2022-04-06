package com.group6.trianglecalculator;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

import androidx.annotation.Nullable;

public class MyDrawingPractice extends Drawable {

    @Override
    public void draw(Canvas canvas){

            int height = getBounds().height();
            int width = getBounds().width();



            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(10f);

            canvas.drawLine(0, 0, width,0,paint);
            canvas.drawLine(0, height, width, height, paint );
            canvas.drawLine(0, 0, 0, height, paint);
            canvas.drawLine(width, 0, width, height, paint);


    }

    @Override
    public void setAlpha(int i) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }


}
