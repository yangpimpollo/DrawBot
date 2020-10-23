package com.example.drawbot;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.example.drawbot.utilTools.Constants;
import com.example.drawbot.utilTools.Sprites;

public class Map {
    private double worldPositionX;    //  世界與焦點差異
    private double worldPositionY;    //  世界與焦點差異
    private double positionX;         //  我在世界上的位置
    private double positionY;         //  我在世界上的位置
    private double drawPositionX;     //  畫位置
    private double drawPositionY;     //  畫位置
    private double velocityX;
    private double velocityY;
    private String L, M;

    private double x1, y1, x2, y2;

    public Map(double drawPositionX, double drawPositionY){
        this.drawPositionX = drawPositionX;
        this.drawPositionY = drawPositionY;
        positionX = 0;
        positionY = 0;
        worldPositionX = positionX-drawPositionX;
        worldPositionY = positionY-drawPositionY;
    }

    public void update(Joystick joystick) {
        drawPositionX = positionX-worldPositionX;
        drawPositionY = positionY-worldPositionY;
        velocityX = joystick.getActuatorX()*Constants.MAX_SPEED;
        velocityY = joystick.getActuatorY()*Constants.MAX_SPEED;
        drawPositionX -= velocityX;
        drawPositionY -= velocityY;
        //positionX -= velocityX;
        //positionY -= velocityY;
        worldPositionX += velocityX;
        worldPositionY += velocityY;

        L="x: "+(int)worldPositionX+"| y: "+(int)worldPositionY;

        x1 = 0-worldPositionX;
        y1 = 300-worldPositionY;
        x2 = x1+100-worldPositionX;
        y2 = y2+100-worldPositionY;
    }

    public void draw(Canvas canvas) {
        //.drawBitmap(Sprites.bmp, (float) positionX, (float) positionY, null); //farol Test
        for (int y=0; y<(Constants.screen_Height/Constants.unit32)+1; y++){
            for (int x=0; x<(Constants.screen_Width/Constants.unit32)+3; x++){
                canvas.drawBitmap(Sprites.bmpR, (float) drawPositionX+x*Constants.unit32, (float) drawPositionY+y*Constants.unit32, null);
            }
        }
        /*Paint pincel1 = new Paint();
        pincel1.setARGB(255, 255, 0, 255);
        pincel1.setTextSize(30);
        pincel1.setTypeface(Typeface.SERIF);
        canvas.drawText(L, 50, 350, pincel1);
        canvas.drawText(M, 50, 400, pincel1);
        canvas.drawRect((float) x1, (float) y1, (float) x2, (float) y2, pincel1);*/
    }

    /*public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }*/

}
