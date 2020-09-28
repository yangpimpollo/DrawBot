package com.example.drawbot;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.widget.Toast;

public class MainThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private  GamePanel gamePanel;
    private boolean running;
    public  static Canvas canvas;
    private static int aps = 0;
    private static int fps = 0;
    private String A;

    public void setRunning(boolean running){
        this.running = running;
    }

    public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
    }
    @Override
    public void run(){
        final int NS_POR_SEGUNDO = 1000000000; // nanosegundos por segundo
        final byte APS_OBJETIVO = 60; // actualizaciones por segundo
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

        long referenciaActualizacion = System.nanoTime();
        long refernciaContador = System.nanoTime();
        double tiempoTranscurrido;
        double delta = 0;

        while (running) {
            canvas = null;
            final long inicioBucle = System.nanoTime();
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;

            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;


            try{
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder){
                    this.gamePanel.draw(canvas);
                    fps++;
                }
            }catch (Exception e){
                System.out.println("Error Canvas...............");
                e.printStackTrace();
            }finally {
                if(canvas != null){
                    try{
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }catch (Exception e){ e.printStackTrace(); }
                }
            }
            while (delta >= 1) {
                this.gamePanel.update();
                aps++;
                delta--;
            }

            if (System.nanoTime() - refernciaContador > NS_POR_SEGUNDO) {
                /*CONTADOR_APS = "APS : " + aps;
                CONTADOR_FPS = "FPS : " + fps;
                // ventana.setTitle(NOMBRE + " || APS : " + aps + " || FPS : " + fps);*/
                //System.out.println("APS : " + aps + "  || FPS : " + fps);
                A = "APS : " + aps + "  || FPS : " + fps;
                //Toast.makeText(gamePanel, A, Toast.LENGTH_SHORT).show();
                aps = 0;
                fps = 0;
                refernciaContador = System.nanoTime();
            }
        }

    }
    public String getA(){
        return A;
    }
}
