package com.example.drawbot;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.example.drawbot.utilTools.Constants;
import com.example.drawbot.utilTools.Sprites;

public class Map {
    private double worldPositionX;    //  世界與焦點差異 origin  | point relative to screen
    private double worldPositionY;    //  世界與焦點差異 origin  | point relative to screen
    private double positionX;         //  我在世界上的位置 myPosition relative to origin
    private double positionY;         //  我在世界上的位置 myPosition relative to origin
    private double drawPositionX;     //  畫位置 myPosition relative to screen
    private double drawPositionY;     //  畫位置 myPosition relative to screen
    private double velocityX;         //
    private double velocityY;         //  origin: W; myPosition: P; drawPosition: Dp
    private String K, L, M;              //       (  W = Dp-P  )
    private double JpositionX = 100;
    private double JpositionY = 100;

    private double x1, y1, x2, y2;

    public Map(double drawPositionX, double drawPositionY){
        this.drawPositionX = drawPositionX;
        this.drawPositionY = drawPositionY;
        positionX = 100;
        positionY = 100;
        //worldPositionX = positionX+drawPositionX;
        //worldPositionY = positionY+drawPositionY;
    }

    public void update(Joystick joystick) {

        velocityX = joystick.getActuatorX()*Constants.MAX_SPEED;
        velocityY = joystick.getActuatorY()*Constants.MAX_SPEED;
        drawPositionX -= velocityX;
        drawPositionY -= velocityY;
        //drawPositionX = positionX-worldPositionX;
        //drawPositionY = positionY-worldPositionY;
        //positionX -= velocityX;
        //positionY -= velocityY;
        worldPositionX = drawPositionX-positionX;
        worldPositionY = drawPositionY-positionY;
        //worldPositionX += velocityX;
        //worldPositionY += velocityY;
        JpositionX += velocityX;
        JpositionY += velocityY;
        /*if ((int)JpositionX+(int)velocityX>300){
            joystick.setOff(joystick.getKon());
        }else{
            joystick.setOn();
        }*/
        //-------------------------collider----------------------------------------------
        /*if((int)JpositionX+(int)velocityX<0) {
            if((int)JpositionY+(int)velocityY<0) {
                joystick.setOff('a');
            }else if((int)JpositionY+(int)velocityY>300) {
                joystick.setOff('c');
            }else {
                joystick.setOff('e');
            }
        }else if((int)JpositionX+(int)velocityX>500) {
            if((int)JpositionY+(int)velocityY>300) {
                joystick.setOff('d');
            }else if((int)JpositionY+(int)velocityY<0) {
                joystick.setOff('b');
            }else {
                joystick.setOff('o');
            }
        }else if((int)JpositionY+(int)velocityY<0) {
            joystick.setOff('n');
        }else if((int)JpositionY+(int)velocityY>300) {
            joystick.setOff('s');
        }else{
            if(collision()){
                joystick.setOff(joystick.getKon2());
            }else {
                joystick.setOn();
            }
        }*/
        joystick.setOn();
        //-------------------------collider----------------------------------------------
        K="direction: "+joystick.getK()+"| : "+joystick.getJoystickOn()+"| : "+joystick.getKon();
        L="x: "+(int)drawPositionX+"| y: "+(int)drawPositionY+"Map Dp";
        M="x: "+(int)velocityX+"| y: "+(int)velocityY;

        x1 = 0+worldPositionX;
        y1 = 300+worldPositionY;
        x2 = x1+100;
        y2 = y1+100;
    }

    public void draw(Canvas canvas) {
        //.drawBitmap(Sprites.bmp, (float) positionX, (float) positionY, null); //farol Test
        for (int y=0; y<(Constants.screen_Height/Constants.unit32)+1; y++){
            for (int x=0; x<(Constants.screen_Width/Constants.unit32)+3; x++){
                canvas.drawBitmap(Sprites.bmpR, (float) drawPositionX+x*Constants.unit32, (float) drawPositionY+y*Constants.unit32, null);
            }
        }
        Paint pincel1 = new Paint();
        pincel1.setARGB(255, 255, 0, 255);
        pincel1.setTextSize(30);
        pincel1.setTypeface(Typeface.SERIF);
        canvas.drawText(K, 50, 300, pincel1);
        canvas.drawText(L, 50, 350, pincel1);
        canvas.drawText(M, 50, 400, pincel1);
        canvas.drawCircle((float)worldPositionX,(float)worldPositionY,20,pincel1);
        canvas.drawRect((float) x1, (float) y1, (float) x2, (float) y2, pincel1);
    }

    public double getWorldPositionX(){ return worldPositionX; }
    public double getWorldPositionY(){ return worldPositionY; }

    public boolean collision(){
        if(JpositionX-Constants.unit32_05<400&& JpositionX+Constants.unit32_05>300&&
           JpositionY-Constants.unit32_05<200&& JpositionY+Constants.unit32_05>100){
            return true;
        }else {
            return false;
        }
    }

    /*public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }*/

}
