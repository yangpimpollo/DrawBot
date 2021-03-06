package com.example.drawbot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.example.drawbot.utilTools.Constants;
import com.example.drawbot.utilTools.Sprites;

public class PlayerB {
    private double positionX;
    private double positionY;
    //private Paint paint;
    private Bitmap bmBR;
    private int xP, yP, xV, yV, aRadI;
    private double aRad;
    private double a2Rad, aSex;
    private double velocityX;
    private double velocityY;
    private static final double SPEED_PIXELS_PER_SECOND = 200;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND/60;
    private String L, M, N;
    private char direction='s';
    private boolean moving=false;
    private int animacion;

    public PlayerB(double positionX, double positionY){
        this.positionX = positionX;
        this.positionY = positionY;

    }

    public void update(Joystick joystick) {

        velocityX = joystick.getActuatorX()*MAX_SPEED;
        velocityY = joystick.getActuatorY()*MAX_SPEED;
        positionX += velocityX;
        positionY += velocityY;
        aRad = Math.atan(velocityY/velocityX);
        aSex=joystick.getSexAngle();
        aRadI=(int)aRad;
        xP=(int)positionX;
        yP=(int)positionY;
        xV=(int)velocityX;
        yV=(int)velocityY;
        L="x: "+xP+"| y: "+yP;
        //M="x: "+xV+"| y: "+yV;
        M="x: "+xV+"| y: "+yV;
        N="vector: "+aSex;
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
        if(xV<=0&&yV<0&&aRad<Constants.PI/2&&aRad>Constants.PI/4||xV>=0&&yV<0&&aRad>-(Constants.PI/2)&&aRad<-(Constants.PI/4)){
            direction='n';

            if (!moving) {
                bmBR= Sprites.up0;
            }else {
                if (resto > 20 && resto <= 40) {
                    bmBR = Sprites.up1;
                } else if (resto > 40 && resto <= 60) {
                    bmBR = Sprites.up0;
                } else if (resto > 60) {
                    bmBR = Sprites.up2;
                } else {
                    bmBR = Sprites.up0;
                }
            }
        }else if(xV>=0&&aRad<Constants.PI/2&&aRad>Constants.PI/4||xV<=0&&aRad>-(Constants.PI/2)&&aRad<-(Constants.PI/4)){
            direction='s';

            if (!moving) {
                bmBR=Sprites.down0;
            }else {
                if (resto > 20 && resto <= 40) {
                    bmBR = Sprites.down1;
                } else if (resto > 40 && resto <= 60) {
                    bmBR = Sprites.down0;
                } else if (resto > 60) {
                    bmBR = Sprites.down2;
                } else {
                    bmBR = Sprites.down0;
                }
            }
        }else if(xV<=0&&aRad>-(Constants.PI/4)/2&&aRad<Constants.PI/4){
            direction='o';

            if (!moving) {
                bmBR = Sprites.left0;
            }else {
                if (resto > 20 && resto <= 40) {
                    bmBR = Sprites.left1;
                } else if (resto > 40 && resto <= 60) {
                    bmBR = Sprites.left0;
                } else if (resto > 60) {
                    bmBR = Sprites.left2;
                } else {
                    bmBR = Sprites.left0;
                }
            }
        }else if(xV>=0&&aRad>-(Constants.PI/4)/2&&aRad<Constants.PI/4){
            direction='e';
            if (!moving) {
                bmBR=Sprites.right0;
            }else {
                if (resto > 20 && resto <= 40) {
                    bmBR = Sprites.right1;
                } else if (resto > 40 && resto <= 60) {
                    bmBR = Sprites.right0;
                } else if (resto > 60) {
                    bmBR = Sprites.right2;
                } else {
                    bmBR = Sprites.right0;
                }
            }
        }

    }

    public void draw(Canvas canvas) {

        Paint pincel1 = new Paint();
        pincel1.setARGB(255, 0, 0, 255);
        pincel1.setTextSize(30);
        pincel1.setTypeface(Typeface.SERIF);
        //canvas.drawText(L, 50, 350, pincel1);
        //canvas.drawText(M, 50, 400, pincel1);
        canvas.drawText(N, 50, 450, pincel1);
        canvas.drawBitmap(bmBR, (float) Constants.Center_X-(Constants.unit32/2), (float) Constants.Center_Y-(Constants.unit32/2), null);

        Paint pincel2 = new Paint();
        pincel2.setARGB(255, 0, 0, 0);
        pincel2.setStrokeWidth(1);
        pincel2.setStyle(Paint.Style.STROKE);
        //canvas.drawRect((float) centerX-(Constants.unit32/2),(float) centerY-(Constants.unit32/2),(float) centerX+(Constants.unit32/2),(float) centerY+(Constants.unit32/2),pincel2);
        canvas.drawLine(0,0, (float)Constants.screen_Width, (float)Constants.screen_Height, pincel2);
        canvas.drawLine((float)Constants.screen_Width, 0, 0,(float)Constants.screen_Height, pincel2);
        //canvas.drawRect((float)(positionX+140)/2,(float)(positionY+140)/2, (float)(positionX+1500)/2, (float)(positionY+800)/2, pincel2);
    }

    /*
    public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }*/
}
