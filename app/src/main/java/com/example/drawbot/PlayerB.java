package com.example.drawbot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

public class PlayerB {
    private double positionX;
    private double positionY;
    private double radius;
    private Paint paint;

    public PlayerB(Context context, double positionX, double positionY, double radius){
        this.positionX = positionX;
        this.positionY = positionY;
        this.radius = radius;

        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.playerB);
        paint.setColor(color);
    }

    public void update() {
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle((float) positionX, (float) positionY, (float) radius, paint);
    }

    public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
