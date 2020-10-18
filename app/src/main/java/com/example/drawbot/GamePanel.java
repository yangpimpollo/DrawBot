package com.example.drawbot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.drawbot.utilTools.Constants;
import com.example.drawbot.utilTools.Sprites;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;

    private static final String B = Constants.screen_Name+"|wi "+Constants.screen_Width+" | he "+Constants.screen_Height;
    private static final String C ="dpi: "+Constants.screen_DPI+"|kdpi: "+Constants.dpi_Multiple+"|unit32: "+Constants.unit32;

    private Sprites sprites;
    private Map map;
    private final Joystick joystick;
    private PlayerB playerB;

    public GamePanel(Context context) {
        super(context);

        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);

        sprites = new Sprites(getContext());
        map = new Map(0, 0);
        joystick = new Joystick(Constants.screen_Width-128, Constants.screen_Height-120, 70, 40);
        playerB = new PlayerB(0,0, Constants.screen_Width/2, Constants.screen_Height/2);
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new MainThread(getHolder(), this);
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(true){
            try{
                thread.setRunning(false);
                thread.join();
            }catch(Exception e){ e.printStackTrace(); }
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(joystick.isPressed((double)event.getX(), (double)event.getY())){
                    joystick.setIsPressed(true);
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                if(joystick.getIsPressed()){
                    joystick.setActuator((double)event.getX(), (double)event.getY());
                }
                //playerPoint.set((int)event.getX(), (int)event.getY());
                //playerB.setPosition((double)event.getX(), (double)event.getY());
                return true;
            case  MotionEvent.ACTION_UP:
                joystick.setIsPressed(false);
                joystick.resetActuator();
                return true;
        }

        return super.onTouchEvent(event);
    }

    public void update(){
        map.update(joystick);
        joystick.update();
        playerB.update(joystick);
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        canvas.drawColor(Color.WHITE);
        String A = thread.getA();

        map.draw(canvas);

        Paint pincel1 = new Paint();
        pincel1.setARGB(255, 255, 0, 0);
        pincel1.setTextSize(30);
        pincel1.setTypeface(Typeface.SERIF);
        canvas.drawText(A, 50, 50, pincel1);
        canvas.drawText(B, 50, 100, pincel1);
        canvas.drawText(C, 50, 150, pincel1);

        joystick.draw(canvas);
        playerB.draw(canvas);
    }
}
