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
    private double dpiK =MainActivity.dpi/160.0;
    private double unitD =32*dpiK;
    private int unit32 =(int)unitD;


    public Map(Context context, double positionX, double positionY){
        this.positionX = positionX;
        this.positionY = positionY;

        bmp= BitmapFactory.decodeResource(context.getResources(), R.drawable.im);
        bmq= BitmapFactory.decodeResource(context.getResources(), R.drawable.imdes);
        bmpR = Bitmap.createBitmap(bmq, 0,  unit32, unit32, unit32);
    }

    public void update(Joystick joystick) {
        velocityX = joystick.getActuatorX()*MAX_SPEED;
        velocityY = joystick.getActuatorY()*MAX_SPEED;
        positionX -= velocityX;
        positionY -= velocityY;
    }

    public void draw(Canvas canvas) {
        //canvas.drawBitmap(bmp, (float) positionX, (float) positionY, null);
        for (int y=0; y<(this.he/unit32)+1; y++){
            for (int x=0; x<(this.wi/unit32)+3; x++){
                canvas.drawBitmap(bmpR, (float) positionX+x*unit32, (float) positionY+y*unit32, null);
            }
        }
    }

    public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
