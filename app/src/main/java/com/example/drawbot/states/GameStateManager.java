package com.example.drawbot.states;

import android.graphics.Canvas;

import com.example.drawbot.Joystick;

public class GameStateManager {

    private static State currentState = new PayState();

    public GameStateManager(){

    }

    public void changeState(State newState) {
        currentState = newState;
    }

    public void update(Joystick joystick){
        currentState.update(joystick);
    }
    public void draw(Canvas canvas){
        currentState.draw(canvas);
    }
}
