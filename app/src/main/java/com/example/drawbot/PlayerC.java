package com.example.drawbot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.example.drawbot.utilTools.Constants;
import com.example.drawbot.utilTools.Sprites;

public class PlayerC {
    private double positionX=100;
    private double positionY=100;
    private double initPositionX=Constants.Center_X;
    private double initPositionY=Constants.Center_Y;
    private double worldPositionX;    //  世界與焦點差異 origin  | point relative to screen
    private double worldPositionY;
    private double velocityX;
    private double velocityY;
    private Bitmap bmBR;
    private double aSex;
    private String N, O;
    private char direction='s';
    private boolean moving=false;
    private int animacion;
    private Map map;

    public PlayerC(Map map){
        this.map = map;
        /*this.positionX = positionX;
        this.positionY = positionY;*/

    }

    public void update(Joystick joystick) {

        worldPositionX = map.getWorldPositionX();
        worldPositionY = map.getWorldPositionY();
        velocityX = joystick.getActuatorX()*Constants.MAX_SPEED;
        velocityY = joystick.getActuatorY()*Constants.MAX_SPEED;
        positionX += velocityX;
        positionY += velocityY;/*
        if((int)positionX+(int)velocityX<0) {
            if((int)positionY+(int)velocityY<0) {
                joystick.setOff('a');
            }else if((int)positionY+(int)velocityY>300) {
                joystick.setOff('c');
            }else {
                joystick.setOff('e');
            }
        }else if((int)positionX+(int)velocityX>500) {
            if((int)positionY+(int)velocityY>300) {
                joystick.setOff('d');
            }else if((int)positionY+(int)velocityY<0) {
                joystick.setOff('b');
            }else {
                joystick.setOff('o');
            }
        }else if((int)positionY+(int)velocityY<0) {
            joystick.setOff('n');
        }else if((int)positionY+(int)velocityY>300) {
            joystick.setOff('s');
        }else{
            joystick.setOn();
        }*/
        N="x: "+(int)positionX+"| y: "+(int)positionY+"PayerC P";
        aSex=joystick.getSexAngle();
        O="vector: "+aSex;
        if(velocityX!= 0 || velocityY!= 0){
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
        if (aSex>=45&&aSex<135){
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
        }else if(aSex>=225&&aSex<315){
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
        }else if(aSex>=135&&aSex<225){
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
        }else if(aSex>=0&&aSex<45||aSex>=315&&aSex<360){
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
        canvas.drawText(O, 50, 500, pincel1);
        canvas.drawCircle((float)worldPositionX,(float)worldPositionY,10,pincel1);
        canvas.drawBitmap(bmBR, (float) Constants.Center_X-(Constants.unit32/2), (float) Constants.Center_Y-(Constants.unit32/2), null);

        Paint pincel2 = new Paint();
        pincel2.setARGB(255, 0, 0, 0);
        pincel2.setStrokeWidth(1);
        pincel2.setStyle(Paint.Style.STROKE);
        canvas.drawRect((float) Constants.Center_X-(Constants.unit32/2),(float) Constants.Center_Y-(Constants.unit32/2),(float) Constants.Center_X+(Constants.unit32/2),(float) Constants.Center_Y+(Constants.unit32/2),pincel2);
        canvas.drawLine(0,0, (float)Constants.screen_Width, (float)Constants.screen_Height, pincel2);
        canvas.drawLine((float)Constants.screen_Width, 0, 0,(float)Constants.screen_Height, pincel2);
        canvas.drawRect((float)worldPositionX,(float)worldPositionY, (float)worldPositionX+1500, (float)worldPositionY+900, pincel2);
        canvas.drawRect((float)worldPositionX+300,(float)worldPositionY+100, (float)worldPositionX+400, (float)worldPositionY+200, pincel2);
    }

    /*
    public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }*/
}
