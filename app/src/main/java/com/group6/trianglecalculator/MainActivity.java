package com.group6.trianglecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView drawingArea = findViewById(R.id.drawing_area);
        MyDrawingPractice drawable = new MyDrawingPractice();
        drawingArea.setImageDrawable(drawable);

    }
}
