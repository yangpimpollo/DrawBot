package com.example.drawbot;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.drawbot.utilTools.Constants;
import com.example.drawbot.utilTools.Sprites;

public class Map {
    private double positionX;
    private double positionY;
    private Paint paint;
    private double velocityX;
    private double velocityY;
    private static final double SPEED_PIXELS_PER_SECOND = 200;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND/60;

    public Map(double positionX, double positionY){
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void update(Joystick joystick) {
        velocityX = joystick.getActuatorX()*MAX_SPEED;
        velocityY = joystick.getActuatorY()*MAX_SPEED;
        positionX -= velocityX;
        positionY -= velocityY;
    }

    public void draw(Canvas canvas) {
        for (int y=0; y<(Constants.screen_Height/Constants.unit32)+1; y++){
            for (int x=0; x<(Constants.screen_Width/Constants.unit32)+3; x++){
                canvas.drawBitmap(Sprites.bmpR, (float) positionX+x*Constants.unit32, (float) positionY+y*Constants.unit32, null);
            }
        }
    }

    public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
