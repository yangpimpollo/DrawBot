package com.example.drawbot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import 	android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;

    //private RectPlayer player;
    //private Point playerPoint;
    private int he3=MainActivity.screenHeight;
    private int wi3=MainActivity.screenWidth;
    private String F=MainActivity.displayName+"|wi "+wi3+" | he "+he3;

    private int he2=MainActivity.screenHeight;
    private int wi2=MainActivity.screenWidth;
    private String E=MainActivity.displayName+"|wi "+wi2+" | he "+he2;

    private int dpi =MainActivity.dpi;
    private float xdpi =MainActivity.xdpi;
    private float ydpi =MainActivity.ydpi;
    private String D="dpi: "+dpi+"|x "+xdpi+"|y "+ydpi;

    private int he =MainActivity.he;
    private int wi =MainActivity.wi;
    private String C="wi "+wi+" | he "+he+"metrics-db";

    private Map map;
    private final Joystick joystick;
    private PlayerB playerB;

    public GamePanel(Context context) {
        super(context);

        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        //player = new RectPlayer(new Rect(100, 100, 400, 400), Color.rgb(0, 0, 255));
        //playerPoint = new Point(150, 150);

        map = new Map(getContext(), 0, 0);
        joystick = new Joystick(wi-128, he-120, 70, 40);
        playerB = new PlayerB(getContext(), 0,0,wi/2, he/2, 80);
        //System.out.println(wi+"|"+he);
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
        //player.update(playerPoint);
        map.update(joystick);
        joystick.update();
        playerB.update(joystick);
        //Toast.makeText(this, A, Toast.LENGTH_SHORT).show();
    }
    //--------------------------------

    //int ancho = canvas.getWidth();
    //int alto = canvas.getHeight();
    Bitmap bmp= BitmapFactory.decodeResource(getResources(), R.drawable.im);
    Bitmap bmq= BitmapFactory.decodeResource(getResources(), R.drawable.ima);
    //Bitmap bmpR = new BitmapRegionDecoder(new Rect(0, 0, 32, 32),  new BitmapFactory.Options());
    Bitmap bmpR = Bitmap.createBitmap(bmq, 112, 56, 56, 56);
    //--------------------------------

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        canvas.drawColor(Color.WHITE);
        String A = thread.getA();

        int wi = canvas.getWidth();
        int he = canvas.getHeight();
        String B = "wi "+wi+" | he "+he+"canvas-db";

        map.draw(canvas);
        canvas.drawBitmap(bmq, 0, 0, null);
        canvas.drawBitmap(bmpR, 336, 0, null);
        //player.draw(canvas);
        Paint pincel1 = new Paint();
        pincel1.setARGB(255, 255, 0, 0);
        pincel1.setTextSize(30);
        pincel1.setTypeface(Typeface.SERIF);
        canvas.drawText(A, 50, 200, pincel1);
        canvas.drawText(B, 50, 250, pincel1);
        canvas.drawText(C, 50, 300, pincel1);
        //canvas.drawRect(0,500,1380,550,pincel1); // *1.75
        canvas.drawText(D, 600, 50, pincel1);
        canvas.drawText(E, 600, 100, pincel1);
        canvas.drawText(F, 600, 150, pincel1);

        joystick.draw(canvas);
        playerB.draw(canvas);
    }
}
