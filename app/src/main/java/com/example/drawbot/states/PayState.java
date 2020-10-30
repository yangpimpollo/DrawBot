package com.example.drawbot.states;

import android.graphics.Canvas;

import com.example.drawbot.ABLayer;
import com.example.drawbot.Joystick;
import com.example.drawbot.Map;
import com.example.drawbot.PlayerC;
import com.example.drawbot.utilTools.Constants;

public class PayState extends State {

    private Map map;
    private ABLayer ablayer;
    private PlayerC playerC;

    public PayState(){
        map = new Map(Constants.Center_X, Constants.Center_Y);
        ablayer = new ABLayer();
        playerC = new PlayerC(map);
    }

    @Override
    public void update(Joystick joystick) {
        map.update(joystick);
        ablayer.update(map);
        playerC.update(joystick);
    }

    @Override
    public void draw(Canvas canvas) {
        map.draw(canvas);
        ablayer.draw(canvas);
        playerC.draw(canvas);
    }
}
