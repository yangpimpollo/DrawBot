package com.example.drawbot.states;

import android.graphics.Canvas;

public class GameStateManager {

    private static State currentState = null;

    public GameStateManager(){

    }

    public void changeState(State newState) {
        currentState = newState;
    }

    public void update(){
        currentState.update();
    }
    public void draw(Canvas canvas){
        currentState.draw(canvas);
    }
}
