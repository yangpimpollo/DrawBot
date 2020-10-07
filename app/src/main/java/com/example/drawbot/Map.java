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
    private Bitmap bmp, bmq, bmpR;
    private double velocityX;
    private double velocityY;
    private static final double SPEED_PIXELS_PER_SECOND = 200;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND/60;

    private int he =MainActivity.he;
    private int wi =MainActivity.wi;


    public Map(Context context, double positionX, double positionY){
        this.positionX = positionX;
        this.positionY = positionY;

        bmp= BitmapFactory.decodeResource(context.getResources(), R.drawable.im);
        bmq= BitmapFactory.decodeResource(context.getResources(), R.drawable.imdes);
        bmpR = Bitmap.createBitmap(bmq, 0, 56, 56, 56);
    }

    public void update(Joystick joystick) {
        velocityX = joystick.getActuatorX()*MAX_SPEED;
        velocityY = joystick.getActuatorY()*MAX_SPEED;
        positionX -= velocityX;
        positionY -= velocityY;
    }

    public void draw(Canvas canvas) {
        //canvas.drawBitmap(bmp, (float) positionX, (float) positionY, null);
        for (int y=0; y<(this.he/56)+1; y++){
            for (int x=0; x<(this.wi/56)+3; x++){
                canvas.drawBitmap(bmpR, (float) positionX+x*56, (float) positionY+y*56, null);
            }
        }
    }

    public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
