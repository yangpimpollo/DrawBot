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
    private char direction, Kon, Kon2;
    private double angleRad, angleSex;private String K;

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

    public void setOn() {
        joystickOn=true;
        actuatorValueX = actuatorX;
        actuatorValueY = actuatorY;
        K = "on";
        if (angleSex>=67.5&&angleSex<112.5){
            Kon='n';
        }else if(angleSex>=112.5&&angleSex<157.5){
            Kon='a';
        }else if(angleSex>=157.5&&angleSex<202.5){
            Kon='e';
        }else if(angleSex>=202.5&&angleSex<247.5){
            Kon='c';
        }else if(angleSex>=247.5&&angleSex<292.5){
            Kon='s';
        }else if(angleSex>=292.5&&angleSex<337.5){
            Kon='d';
        }else if(angleSex>=337.5&&angleSex<360||angleSex>0&&angleSex<22.5){
            Kon='o';
        }else if(angleSex>=22.5&&angleSex<67.5){
            Kon='b';
        }else{
            Kon='x';
        }
        //-----------------------------------
        if (angleSex>=45&&angleSex<135){
            Kon2='n';
        }else if (angleSex>=135&&angleSex<225){
            Kon2='e';
        }else if (angleSex>=225&&angleSex<315){
            Kon2='s';
        }else if (angleSex>=315&&angleSex<360||angleSex>=0&&angleSex<45){
            Kon2='o';
        }else{
            Kon2='x';
        }
    }
    public void setOff(char direction){
        this.direction = direction;
        joystickOn=false;
        setOffCases(direction);
    }
    public void setOffCases(char m){
        if (m=='n'){
            actuatorValueX = actuatorX;
            actuatorValueY = (actuatorY<0) ? 0 : actuatorY;K="n";
        }else if (m=='s'){
            actuatorValueX = actuatorX;
            actuatorValueY = (actuatorY>0) ? 0 : actuatorY;K="s";
        }else if (m=='e'){
            actuatorValueX = (actuatorX<0) ? 0 : actuatorX;K="e";
            actuatorValueY = actuatorY;
        }else if (m=='o'){
            actuatorValueX = (actuatorX>0) ? 0 : actuatorX;K="o";
            actuatorValueY = actuatorY;
        }else if (m=='a'){  //norte-este
            actuatorValueX = (actuatorX<0) ? 0 : actuatorX;K="a-ne";
            actuatorValueY = (actuatorY<0) ? 0 : actuatorY;
        }else if (m=='b'){  //norte-oeste
            actuatorValueX = (actuatorX>0) ? 0 : actuatorX;K="b-no";
            actuatorValueY = (actuatorY<0) ? 0 : actuatorY;
        }else if (m=='c'){  //sur-este
            actuatorValueX = (actuatorX<0) ? 0 : actuatorX;K="c-se";
            actuatorValueY = (actuatorY>0) ? 0 : actuatorY;
        }else if (m=='d'){  //sur-oeste
            actuatorValueX = (actuatorX>0) ? 0 : actuatorX;K="d-so";
            actuatorValueY = (actuatorY>0) ? 0 : actuatorY;
        }
    }

    public double getAngle() { return angleRad; }
    public double getSexAngle() { return angleSex; }
    public double getActuatorX() { return actuatorValueX; }
    public double getActuatorY() { return actuatorValueY; }
    public boolean getJoystickOn(){ return joystickOn; }
    public String getK(){ return K; }
    public char getKon(){ return Kon; }
    public char getKon2(){ return Kon2; }
}
