package com.example.drawbot.utilTools;

import com.example.drawbot.MainActivity;
import com.example.drawbot.R;

public class Constants {
    public static final String screen_Name = MainActivity.displayName;
    public static final int screen_Width = MainActivity.wi;
    public static final int screen_Height = MainActivity.he;
    public static final int screen_DPI = MainActivity.dpi;

    public static final double Center_X = screen_Width/2;
    public static final double Center_Y = screen_Height/2;

    public static final double dpi_Multiple = screen_DPI/160.0;
    public static final int unit32 = (int) (32*dpi_Multiple);   // unit_32Pixel
    public static final int unit32_05 = (int) (unit32/2);

    public static final double PI = Math.PI;


    public static final double SPEED_PIXELS_PER_SECOND = 150;
    public static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND/60;

    public static final String TileMap1 = "30" +
            "#" +
            "18" +
            "#" +
            "01-01-01-01-01-01-01-01-01-01-01-01-01-01-01-01-01-01-01-01-01-01-01-01-01-01-01-01-01-01-" +
            "01-01-01-10-05-05-05-05-05-05-05-05-05-19-01-01-01-01-01-01-01-01-01-01-01-01-01-01-01-01-" +
            "01-01-01-10-07-07-07-07-07-07-07-07-07-20-02-02-02-02-01-01-01-01-01-01-01-01-01-01-01-01-" +
            "02-02-02-11-04-04-04-04-04-04-04-04-04-05-05-05-05-20-02-02-02-02-01-01-01-01-01-01-01-01-" +
            "05-05-05-05-04-04-04-04-04-04-04-04-04-07-07-07-07-05-05-02-02-02-02-02-02-01-01-01-01-01-" +
            "07-07-07-07-04-04-04-04-04-04-04-04-04-04-04-04-04-07-07-02-02-02-02-02-02-02-01-01-01-01-" +
            "04-04-04-04-04-04-04-04-04-04-04-04-04-04-04-04-04-04-04-02-02-02-02-02-02-02-01-01-01-01-" +
            "05-05-05-13-04-04-04-04-04-04-04-04-04-04-04-04-04-18-05-02-02-02-02-02-02-02-02-02-01-01-" +
            "08-08-08-15-04-04-04-04-04-04-04-04-04-04-04-04-04-14-09-02-02-02-02-02-02-02-02-02-02-02-" +
            "03-03-03-12-04-04-04-04-04-04-04-04-04-04-04-04-04-20-02-02-02-02-02-02-02-02-02-02-02-02-" +
            "03-03-03-16-05-05-05-05-05-05-05-05-05-05-04-04-05-05-05-05-05-05-05-05-05-05-20-02-02-02-" +
            "03-03-03-17-08-08-08-08-08-08-08-08-07-07-04-04-07-07-07-07-07-07-07-07-07-07-20-02-02-02-" +
            "03-03-03-03-03-03-03-03-03-03-03-03-04-04-04-04-04-04-04-04-04-04-04-04-04-04-20-02-02-02-" +
            "03-03-03-03-03-03-03-03-03-03-03-03-04-04-04-04-04-04-04-04-04-04-04-04-04-04-20-02-02-02-" +
            "03-03-03-03-03-03-03-03-03-03-03-03-04-04-04-04-04-04-04-04-04-04-04-04-04-04-05-05-05-05-" +
            "03-03-03-03-03-03-03-03-03-03-03-03-04-04-04-04-04-04-04-04-04-04-04-04-04-04-07-07-07-07-" +
            "03-03-03-03-03-03-03-03-03-03-03-03-04-04-04-04-04-04-04-04-04-04-04-04-04-04-04-04-04-04-" +
            "03-03-03-03-03-03-03-03-03-03-03-03-04-04-04-04-04-04-04-04-04-04-04-04-04-04-04-04-04-04";

    public static final String ABMap1 = "0-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-" +
            "1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-" +
            "1-1-1-1-1-1-1-1-1-1-1-1-1-1-0-0-0-0-1-1-1-1-1-1-1-1-1-1-1-1-" +
            "0-0-0-1-0-0-0-0-0-0-0-0-0-1-1-1-1-1-0-0-0-0-1-1-1-1-1-1-1-1-" +
            "1-1-1-1-0-0-0-0-0-0-0-0-0-1-1-1-1-1-1-0-0-0-0-0-0-1-1-1-1-1-" +
            "1-1-1-1-0-0-0-0-0-0-0-0-0-0-0-0-0-1-1-0-0-0-0-0-0-0-1-1-1-1-" +
            "0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-1-1-1-1-" +
            "1-1-1-1-0-0-0-0-0-0-0-0-0-0-0-0-0-1-1-0-0-0-0-0-0-0-0-0-1-1-" +
            "1-1-1-1-0-0-0-0-0-0-0-0-0-0-0-0-0-1-1-0-0-0-0-0-0-0-0-0-0-0-" +
            "0-0-0-1-0-0-0-0-0-0-0-0-0-0-0-0-0-1-0-0-0-0-0-0-0-0-0-0-0-0-" +
            "0-0-0-1-1-1-1-1-1-1-1-1-1-1-0-0-1-1-1-1-1-1-1-1-1-1-1-0-0-0-" +
            "0-0-0-1-1-1-1-1-1-1-1-1-1-1-0-0-1-1-1-1-1-1-1-1-1-1-1-0-0-0-" +
            "0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-1-0-0-0-" +
            "0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-1-0-0-0-" +
            "0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-1-1-1-1-" +
            "0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-1-1-1-1-" +
            "0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-" +
            "0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0";

}
