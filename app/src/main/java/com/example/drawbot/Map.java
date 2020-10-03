package com.example.drawbot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Map {
    private double positionX;
    private double positionY;
    private Paint paint;
    private Bitmap bmp;
    private double velocityX;
    private double velocityY;
    private static final double SPEED_PIXELS_PER_SECOND = 400;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND/60;


    public Map(Context context, double positionX, double positionY){
        this.positionX = positionX;
        this.positionY = positionY;

        bmp= BitmapFactory.decodeResource(context.getResources(), R.drawable.im);
    }

    public void update(Joystick joystick) {
        velocityX = joystick.getActuatorX()*MAX_SPEED;
        velocityY = joystick.getActuatorY()*MAX_SPEED;
        positionX -= velocityX;
        positionY -= velocityY;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bmp, (float) positionX, (float) positionY, null);
    }

    public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
