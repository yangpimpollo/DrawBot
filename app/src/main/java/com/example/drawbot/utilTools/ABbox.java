package com.example.drawbot.utilTools;

public class ABbox {

    private int x, y , width, height;

    public ABbox(){

    }
    public ABbox(int x, int y, int width, int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }

    public void setValue(int x, int y, int width, int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }

    public boolean contains(ABbox box){
        if(x>box.getX() && x+width<box.getX2() && y>box.getY() && y+height<box.getY2()){
            return true;
        }else {
            return false;
        }
    }

    public boolean intersect(ABbox box){
        if(x<box.getX2() && x+width>box.getX() && y<box.getY2() && y+height>box.getY()){
            return true;
        }else {
            return false;
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getX2() { return x+width; }
    public int getY2() { return y+height; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
