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

    public Sprites(Context context){
        //------Map
        bmp= BitmapFactory.decodeResource(context.getResources(), R.drawable.im);     // farol
        bmq= BitmapFactory.decodeResource(context.getResources(), R.drawable.imdes);  // arena+
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

    }
}
