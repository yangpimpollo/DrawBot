package com.example.drawbot;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.drawbot.utilTools.Constants;

public class Joystick {
    private Paint outerCirclePaint;
    private Paint innerCirclePaint;
    private int outerCircleRadius;
    private int innerCircleRadius;
    private  int outerCircleCenterPositionX;
    private  int outerCircleCenterPositionY;
    private  int innerCircleCenterPositionX;
    private  int innerCircleCenterPositionY;
    private double joystickCenterToTouchDistance;
    private boolean isPressed;
    private boolean joystickOn=true;
    private double actuatorX;
    private double actuatorY;
    private double actuatorValueX;
    private double actuatorValueY;
    private char direction;
    private double angleRad, angleSex;

    public  Joystick(int centerPositionX, int centerPositionY, int outerCircleRadius, int innerCircleRadius){
        outerCircleCenterPositionX = centerPositionX;
        outerCircleCenterPositionY = centerPositionY;
        innerCircleCenterPositionX = centerPositionX;
        innerCircleCenterPositionY = centerPositionY;

        this.outerCircleRadius = outerCircleRadius;
        this.innerCircleRadius = innerCircleRadius;

        outerCirclePaint = new Paint();
        outerCirclePaint.setColor(Color.GRAY);
        outerCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        innerCirclePaint = new Paint();
        innerCirclePaint.setColor(Color.BLUE);
        innerCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }
    public void update() {
        updateInnerCirclePosition();
    }

    public void updateInnerCirclePosition(){
        innerCircleCenterPositionX = (int) (outerCircleCenterPositionX + actuatorX*outerCircleRadius);
        innerCircleCenterPositionY = (int) (outerCircleCenterPositionY + actuatorY*outerCircleRadius);
    }
    public void draw(Canvas canvas) {
        canvas.drawCircle(outerCircleCenterPositionX, outerCircleCenterPositionY, outerCircleRadius, outerCirclePaint);
        canvas.drawCircle(innerCircleCenterPositionX, innerCircleCenterPositionY, innerCircleRadius, innerCirclePaint);
    }

    public boolean isPressed(double touchPositionX, double touchPositionY) {
        joystickCenterToTouchDistance = Math.sqrt(Math.pow(outerCircleCenterPositionX-touchPositionX, 2)+Math.pow(outerCircleCenterPositionY-touchPositionY, 2));
        return joystickCenterToTouchDistance < outerCircleRadius;
    }

    public void setIsPressed(boolean isPressed) {
        this.isPressed = isPressed;
    }

    public boolean getIsPressed() {
        return isPressed;
    }

    public void setActuator(double touchPositionX, double touchPositionY) {
        double deltaX = touchPositionX-outerCircleCenterPositionX;
        double deltaY = touchPositionY-outerCircleCenterPositionY;
        double deltaDistance = Math.sqrt(Math.pow(deltaX,2)+Math.pow(deltaY,2));

        if (deltaDistance < outerCircleRadius) {
            actuatorX = deltaX / outerCircleRadius;
            actuatorY = deltaY / outerCircleRadius;
        } else {
            actuatorX = deltaX / deltaDistance;
            actuatorY = deltaY / deltaDistance;
        }

        if (joystickOn){
            actuatorValueX = actuatorX;
            actuatorValueY = actuatorY;
        }else {
            if (direction=='n'){
                actuatorValueX = actuatorX;
                actuatorValueY = (actuatorY<0) ? 0 : actuatorY;
            }else if (direction=='s'){
                actuatorValueX = actuatorX;
                actuatorValueY = (actuatorY>0) ? 0 : actuatorY;
            }else if (direction=='e'){
                actuatorValueX = (actuatorX<0) ? 0 : actuatorX;
                actuatorValueY = actuatorY;
            }else if (direction=='o'){
                actuatorValueX = (actuatorX>0) ? 0 : actuatorX;
                actuatorValueY = actuatorY;
            }
            //actuatorValueX = 0;
            //actuatorValueY = 0;
        }
        angleRad = Math.acos((actuatorX)/(Math.sqrt((actuatorX*actuatorX)+(actuatorY*actuatorY))));
        angleSex = (actuatorY<0) ? (int)((angleRad*180.0)/ Constants.PI) : (int)(360.0-((angleRad*180.0)/Constants.PI));
    }

    public void resetActuator() {
        actuatorX = 0;
        actuatorY = 0;
        angleRad = 0;
        angleSex = 0;
        actuatorValueX = 0;
        actuatorValueY = 0;
    }

    public double getAngle() { return angleRad; }
    public double getSexAngle() { return angleSex; }
    public double getActuatorX() { return actuatorValueX; }
    public double getActuatorY() { return actuatorValueY; }
    public void setOff(char direction){
        this.direction = direction;
        joystickOn=false;
    }
    public void setOn() { joystickOn=true; }
}
