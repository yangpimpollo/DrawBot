package com.example.drawbot;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.drawbot.utilTools.ABbox;
import com.example.drawbot.utilTools.Constants;

import java.util.ArrayList;

public class ABLayer {

    public static ArrayList<ABbox> allBoxes = new ArrayList<ABbox>();

    public static ABbox a1=new ABbox(300, 100, 100, 100);
    public static ABbox a2=new ABbox(430, 100, 200, 300);
    public static ABbox a3=new ABbox(500, 500, 100, 100);
    public static ABbox a4=new ABbox(500, 700, 100, 100);

    private double worldPositionX;
    private double worldPositionY;

    public ABLayer(){
        allBoxes.add(a1);
        allBoxes.add(a2);
        allBoxes.add(a3);
        allBoxes.add(a4);
    }

    public void update(Map map){
        worldPositionX=map.getWorldPositionX();
        worldPositionY=map.getWorldPositionY();
    }

    public void draw(Canvas canvas){
        Paint pincel2 = new Paint();
        pincel2.setARGB(255, 0, 0, 0);
        pincel2.setStrokeWidth(1);
        pincel2.setStyle(Paint.Style.STROKE);
        canvas.drawRect((float)worldPositionX,(float)worldPositionY, (float)worldPositionX+1500, (float)worldPositionY+900, pincel2);
        for (int i=0; i<allBoxes.size(); i++){
            ABbox m = allBoxes.get(i);
            canvas.drawRect((float)worldPositionX+m.getX(),(float)worldPositionY+m.getY(), (float)worldPositionX+m.getX2(), (float)worldPositionY+m.getY2(), pincel2);
        }

    }
}
