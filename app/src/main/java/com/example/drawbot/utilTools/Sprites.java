package com.example.drawbot.utilTools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.drawbot.R;

public class Sprites {
    public static Bitmap bmp, bmq, bmpR;

    public static Bitmap bmB;
    public static Bitmap down0, down1, down2, up0, up1, up2;
    public static Bitmap left0, left1, left2, right0, right1, right2;
    private static Bitmap tm01, tm02, tm03, tm04, tm05, tm06, tm07, tm08, tm09, tm10;
    private static Bitmap tm11, tm12, tm13, tm14, tm15, tm16, tm17, tm18, tm19, tm20, tmdf;

    private static Bitmap bmTM;
    public static String TileMap1;

    public Sprites(Context context){
        //------Map
        bmp= BitmapFactory.decodeResource(context.getResources(), R.drawable.im);     // farol
        bmq= BitmapFactory.decodeResource(context.getResources(), R.drawable.desierto);  // arena+
        bmpR = Bitmap.createBitmap(bmq, 0,  Constants.unit32*1, Constants.unit32, Constants.unit32);
        //------PlayerB
        bmB = BitmapFactory.decodeResource(context.getResources(), R.drawable.imu);
        down0 = Bitmap.createBitmap(bmB, Constants.unit32, 0, Constants.unit32, Constants.unit32);
        down1 = Bitmap.createBitmap(bmB, 0, 0, Constants.unit32, Constants.unit32);
        down2 = Bitmap.createBitmap(bmB, Constants.unit32*2, 0, Constants.unit32, Constants.unit32);
        left0 = Bitmap.createBitmap(bmB, Constants.unit32, Constants.unit32, Constants.unit32, Constants.unit32);
        left1 = Bitmap.createBitmap(bmB, 0, Constants.unit32, Constants.unit32, Constants.unit32);
        left2 = Bitmap.createBitmap(bmB, Constants.unit32*2, Constants.unit32, Constants.unit32, Constants.unit32);
        right0 = Bitmap.createBitmap(bmB, Constants.unit32, Constants.unit32*2, Constants.unit32, Constants.unit32);
        right1 = Bitmap.createBitmap(bmB, 0, Constants.unit32*2, Constants.unit32, Constants.unit32);
        right2 = Bitmap.createBitmap(bmB, Constants.unit32*2, Constants.unit32*2, Constants.unit32, Constants.unit32);
        up0 = Bitmap.createBitmap(bmB, Constants.unit32, Constants.unit32*3, Constants.unit32, Constants.unit32);
        up1 = Bitmap.createBitmap(bmB, 0, Constants.unit32*3, Constants.unit32, Constants.unit32);
        up2 = Bitmap.createBitmap(bmB, Constants.unit32*2, Constants.unit32*3, Constants.unit32, Constants.unit32);
        //------Build tileMap
        //TileMap1 = context.getResources().getString(R.string.map);

        tm01 = Bitmap.createBitmap(bmq, 0,  0, Constants.unit32, Constants.unit32);
        tm02 = Bitmap.createBitmap(bmq, 0,  Constants.unit32*1, Constants.unit32, Constants.unit32);
        tm03 = Bitmap.createBitmap(bmq, 0,  Constants.unit32*2, Constants.unit32, Constants.unit32);
        tm04 = Bitmap.createBitmap(bmq, 0,  Constants.unit32*3, Constants.unit32, Constants.unit32);
        tm05 = Bitmap.createBitmap(bmq, 0,  Constants.unit32*4, Constants.unit32, Constants.unit32);
        tm06 = Bitmap.createBitmap(bmq, 0,  Constants.unit32*5, Constants.unit32, Constants.unit32);

        tm07 = Bitmap.createBitmap(bmq, Constants.unit32,  0, Constants.unit32, Constants.unit32);
        tm08 = Bitmap.createBitmap(bmq, Constants.unit32,  Constants.unit32*1, Constants.unit32, Constants.unit32);
        tm09 = Bitmap.createBitmap(bmq, Constants.unit32,  Constants.unit32*2, Constants.unit32, Constants.unit32);
        tm10 = Bitmap.createBitmap(bmq, Constants.unit32,  Constants.unit32*3, Constants.unit32, Constants.unit32);
        tm11 = Bitmap.createBitmap(bmq, Constants.unit32,  Constants.unit32*4, Constants.unit32, Constants.unit32);
        tm12 = Bitmap.createBitmap(bmq, Constants.unit32,  Constants.unit32*5, Constants.unit32, Constants.unit32);

        tm13 = Bitmap.createBitmap(bmq, Constants.unit32*2,  0, Constants.unit32, Constants.unit32);
        tm14 = Bitmap.createBitmap(bmq, Constants.unit32*2,  Constants.unit32*1, Constants.unit32, Constants.unit32);
        tm15 = Bitmap.createBitmap(bmq, Constants.unit32*2,  Constants.unit32*2, Constants.unit32, Constants.unit32);
        tm16 = Bitmap.createBitmap(bmq, Constants.unit32*2,  Constants.unit32*3, Constants.unit32, Constants.unit32);
        tm17 = Bitmap.createBitmap(bmq, Constants.unit32*2,  Constants.unit32*4, Constants.unit32, Constants.unit32);

        tm18 = Bitmap.createBitmap(bmq, Constants.unit32*4,  0, Constants.unit32, Constants.unit32);
        tm19 = Bitmap.createBitmap(bmq, Constants.unit32*4,  Constants.unit32*1, Constants.unit32, Constants.unit32);
        tm20 = Bitmap.createBitmap(bmq, Constants.unit32*4,  Constants.unit32*2, Constants.unit32, Constants.unit32);

        tmdf = Bitmap.createBitmap(bmq, 0,  Constants.unit32*7, Constants.unit32, Constants.unit32);

    }
    public static Bitmap getBitmap(int p) {
        switch (p){
            case 1: bmTM = tm01; break;
            case 2: bmTM = tm02; break;
            case 3: bmTM = tm03; break;
            case 4: bmTM = tm04; break;
            case 5: bmTM = tm05; break;
            case 6: bmTM = tm06; break;
            case 7: bmTM = tm07; break;
            case 8: bmTM = tm08; break;
            case 9: bmTM = tm09; break;
            case 10: bmTM = tm10; break;
            case 11: bmTM = tm11; break;
            case 12: bmTM = tm12; break;
            case 13: bmTM = tm13; break;
            case 14: bmTM = tm14; break;
            case 15: bmTM = tm15; break;
            case 16: bmTM = tm16; break;
            case 17: bmTM = tm17; break;
            case 18: bmTM = tm18; break;
            case 19: bmTM = tm19; break;
            case 20: bmTM = tm20; break;
            default: bmTM = tmdf;
        }
        return bmTM;
    }
}
