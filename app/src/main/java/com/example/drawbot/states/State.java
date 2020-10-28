package com.example.drawbot.states;

import android.graphics.Canvas;

public interface State {


    public void update();

    public void draw(Canvas canvas);
}
