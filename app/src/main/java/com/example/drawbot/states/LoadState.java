package com.example.drawbot.states;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.example.drawbot.Joystick;
import com.example.drawbot.utilTools.Constants;

public class LoadState extends State implements Runnable{

    private String T="Loading...";
    private int x = 0;
    public LoadState(){

    }

    @Override
    public void update(Joystick joystick) {
        if(x<=(Constants.screen_Height*Constants.dpi_Multiple)) {
            x += 5;
        } else {
            //x=0;
            GameStateManager.changeState(new PayState());
        }
    }

    @Override
    public void draw(Canvas canvas) {
        Paint pincel1 = new Paint();
        pincel1.setARGB(255, 0, 0, 0);
        pincel1.setTextSize(60);
        pincel1.setTypeface(Typeface.SERIF);
        canvas.drawText(T, (float) Constants.Center_X, (float) Constants.Center_Y, pincel1);
        canvas.drawRect((float) 60, (float) Constants.screen_Height-60, (float) 60+x, (float) Constants.screen_Height-40, pincel1);
    }

    @Override
    public void run() {

    }
}
