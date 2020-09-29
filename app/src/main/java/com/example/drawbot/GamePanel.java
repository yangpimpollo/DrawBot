package com.example.drawbot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;

    private RectPlayer player;
    private Point playerPoint;

    private PlayerB playerB;

    public GamePanel(Context context) {
        super(context);

        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        player = new RectPlayer(new Rect(100, 100, 400, 400), Color.rgb(0, 0, 255));
        playerPoint = new Point(150, 150);

        playerB = new PlayerB(getContext(), 500, 500, 80);
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
            case MotionEvent.ACTION_MOVE:
                playerPoint.set((int)event.getX(), (int)event.getY());
                playerB.setPosition((double)event.getX(), (double)event.getY());
        }
        return true;
        //return super.onTouchEvent(event);
    }

    public void update(){
        //player.update(playerPoint);
        playerB.update();
        //Toast.makeText(this, A, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        canvas.drawColor(Color.WHITE);
        String A = thread.getA();
        int ancho = canvas.getWidth();
        int alto = canvas.getHeight();
        Bitmap bmp= BitmapFactory.decodeResource(getResources(), R.drawable.ima);
        canvas.drawBitmap(bmp, 0,0, null);
        //player.draw(canvas);
        Paint pincel1 = new Paint();
        pincel1.setARGB(255, 255, 0, 0);
        pincel1.setTextSize(30);
        pincel1.setTypeface(Typeface.SERIF);
        canvas.drawText(A, 50, 50, pincel1);
        //canvas.drawRect(200,400,100,100,pincel1);

        playerB.draw(canvas);
    }
}
