package com.example.drawbot.utilTools;

import com.example.drawbot.MainActivity;

public class Constants {
    public static final String screen_Name = MainActivity.displayName;
    public static final int screen_Width = MainActivity.wi;
    public static final int screen_Height = MainActivity.he;
    public static final int screen_DPI = MainActivity.dpi;

    public static final double dpi_Multiple = screen_DPI/160.0;
    public static final int unit32 = (int) (32*dpi_Multiple);   // unit_32Pixel

    public static final double PI = Math.PI;

}
