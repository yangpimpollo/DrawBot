package com.example.drawbot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import androidx.core.content.ContextCompat;

public class PlayerB {
    private double centerX;
    private double centerY;
    private double positionX;
    private double positionY;
    private double radius;
    private Paint paint;
    private Bitmap bmB, bmBR;
    private Bitmap down0, down1, down2, up0, up1, up2;
    private Bitmap left0, left1, left2, right0, right1, right2;
    private int xP, yP, xV, yV, aRadI;
    private double aRad;
    private double velocityX;
    private double velocityY;
    private static final double SPEED_PIXELS_PER_SECOND = 400;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND/60;
    private String L, M, N;
    private final double PI=Math.PI;
    private char direction='s';
    private boolean moving=false;
    private int animacion;

    public PlayerB(Context context, double positionX, double positionY, double centerX, double centerY, double radius){
        this.positionX = positionX;
        this.positionY = positionY;
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;

        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.playerB);
        paint.setColor(color);

        bmB = BitmapFactory.decodeResource(context.getResources(), R.drawable.imu);
        down0 = Bitmap.createBitmap(bmB, 56, 0, 56, 56);
        down1 = Bitmap.createBitmap(bmB, 0, 0, 56, 56);
        down2 = Bitmap.createBitmap(bmB, 112, 0, 56, 56);
        left0 = Bitmap.createBitmap(bmB, 56, 56, 56, 56);
        left1 = Bitmap.createBitmap(bmB, 0, 56, 56, 56);
        left2 = Bitmap.createBitmap(bmB, 112, 56, 56, 56);
        right0 = Bitmap.createBitmap(bmB, 56, 112, 56, 56);
        right1 = Bitmap.createBitmap(bmB, 0, 112, 56, 56);
        right2 = Bitmap.createBitmap(bmB, 112, 112, 56, 56);
        up0 = Bitmap.createBitmap(bmB, 56, 168, 56, 56);
        up1 = Bitmap.createBitmap(bmB, 0, 168, 56, 56);
        up2 = Bitmap.createBitmap(bmB, 112, 168, 56, 56);

        //bmBR = Bitmap.createBitmap(bmB, 56, 0, 56, 56);
        //bmBR=down0;
    }

    public void update(Joystick joystick) {
        velocityX = joystick.getActuatorX()*MAX_SPEED;
        velocityY = joystick.getActuatorY()*MAX_SPEED;
        positionX += velocityX;
        positionY += velocityY;
        aRad = Math.atan(velocityY/velocityX);
        aRadI=(int)aRad;
        xP=(int)positionX;
        yP=(int)positionY;
        xV=(int)velocityX;
        yV=(int)velocityY;
        L="x: "+xP+"| y: "+yP;
        M="x: "+xV+"| y: "+yV;
        N="vector: "+aRad;
        if(xV!= 0 || yV!= 0){
            moving=true;
        }else {
            moving=false;
        }
        if (animacion < Integer.MAX_VALUE/* 32767 */) {
            animacion++;
        } else {
            animacion = 0;
        }
        int resto = animacion % 80;
        if(xV<=0&&yV<0&&aRad<PI/2&&aRad>PI/4||xV>=0&&yV<0&&aRad>-(PI/2)&&aRad<-(PI/4)){
            direction='n';
            bmBR=up0;
            if (moving) {
                if (resto > 20 && resto <= 40) {
                    bmBR = up1;
                } else if (resto > 40 && resto <= 60) {
                    bmBR = up0;
                } else if (resto > 60) {
                    bmBR = up2;
                } else {
                    bmBR = up0;
                }
            }
        }else if(xV>=0&&aRad<PI/2&&aRad>PI/4||xV<=0&&aRad>-(PI/2)&&aRad<-(PI/4)){
            direction='s';
            bmBR=down0;
            if (moving) {
                if (resto > 20 && resto <= 40) {
                    bmBR = down1;
                } else if (resto > 40 && resto <= 60) {
                    bmBR = down0;
                } else if (resto > 60) {
                    bmBR = down2;
                } else {
                    bmBR = down0;
                }
            }
        }else if(xV<=0&&aRad>-(PI/4)/2&&aRad<PI/4){
            direction='o';
            bmBR=left0;
            if (moving) {
                if (resto > 20 && resto <= 40) {
                    bmBR = left1;
                } else if (resto > 40 && resto <= 60) {
                    bmBR = left0;
                } else if (resto > 60) {
                    bmBR = left2;
                } else {
                    bmBR = left0;
                }
            }
        }else if(xV>=0&&aRad>-(PI/4)/2&&aRad<PI/4){
            direction='e';
            bmBR=right0;
            if (moving) {
                if (resto > 20 && resto <= 40) {
                    bmBR = right1;
                } else if (resto > 40 && resto <= 60) {
                    bmBR = right0;
                } else if (resto > 60) {
                    bmBR = right2;
                } else {
                    bmBR = right0;
                }
            }
        }

    }

    public void draw(Canvas canvas) {
        //canvas.drawCircle((float) positionX, (float) positionY, (float) radius, paint);
        Paint pincel1 = new Paint();
        pincel1.setARGB(255, 0, 0, 255);
        pincel1.setTextSize(30);
        pincel1.setTypeface(Typeface.SERIF);
        canvas.drawText(L, 50, 350, pincel1);
        canvas.drawText(M, 50, 400, pincel1);
        canvas.drawText(N, 50, 450, pincel1);
        canvas.drawBitmap(bmBR, (float) centerX-28, (float) centerY-28, null);
    }

    /*
    public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }*/
}
