package com.example.drawbot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.drawbot.states.GameStateManager;
import com.example.drawbot.utilTools.Constants;
import com.example.drawbot.utilTools.Sprites;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private boolean noPause = true;

    private static final String B = Constants.screen_Name+"|wi "+Constants.screen_Width+" | he "+Constants.screen_Height;
    private static final String C ="dpi: "+Constants.screen_DPI+"|kdpi: "+Constants.dpi_Multiple+"|unit32: "+Constants.unit32;

    private Sprites sprites;
       //private Map map;
    private final Joystick joystick;
       //private PlayerB playerB;private PlayerC playerC;
    private GameStateManager gsm;

    public GamePanel(Context context) {
        super(context);

        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);

        sprites = new Sprites(getContext());
           //map = new Map(Constants.Center_X, Constants.Center_Y);
        joystick = new Joystick(Constants.screen_Width-128, Constants.screen_Height-120, 70, 40);
        //playerB = new PlayerB(Constants.Center_X, Constants.Center_Y);
           //playerC = new PlayerC(map);
        gsm = new GameStateManager();
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (noPause) {
            thread = new MainThread(getHolder(), this);
            thread.setRunning(true);
            thread.start();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        //boolean retry = true;
        noPause=false;
        /*while(true){
            try{
                thread.setRunning(false);
                //thread.join();
            }catch(Exception e){ e.printStackTrace(); }
            retry = false;
        }*/
    }

    public void Destroy(){
        boolean retry = true;
        while(true){
            try{
                thread.setRunning(false);
                //thread.join();
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

        joystick.update();
           //map.update(joystick);
        //playerB.update(joystick);
           //playerC.update(joystick);
        gsm.update(joystick);
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        canvas.drawColor(Color.WHITE);
        String A = thread.getA();

           //map.draw(canvas);

        Paint pincel1 = new Paint();
        pincel1.setARGB(255, 255, 0, 0);
        pincel1.setTextSize(30);
        pincel1.setTypeface(Typeface.SERIF);
        canvas.drawText(A, 50, 50, pincel1);
        canvas.drawText(B, 50, 100, pincel1);
        canvas.drawText(C, 50, 150, pincel1);

        gsm.draw(canvas);
        joystick.draw(canvas);
        //playerB.draw(canvas);
           //playerC.draw(canvas);
    }
}
