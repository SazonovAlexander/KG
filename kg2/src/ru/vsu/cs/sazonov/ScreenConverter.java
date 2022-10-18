package ru.vsu.cs.sazonov;

public class ScreenConverter {
    private double x, y, w, h;
    private int screenWidth, screenHeight;

    public ScreenConverter(double x, double y, double w, double h, int screenWidth, int screenHeight) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }


    public RealPoint screenToReal(ScreenPoint sp){
        double xx =x + sp.getX() * w / screenWidth;
        double yy =y - sp.getY() * h / screenHeight;
        return new RealPoint(xx,yy);
    }

    public ScreenPoint realToScreen(RealPoint rp){
        double xx = ((rp.getX()-x)/w) * screenWidth;
        double yy = ((y - rp.getY())/h) * screenHeight;
        return new ScreenPoint((int) xx, (int) yy);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }
}
