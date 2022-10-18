package ru.vsu.cs.sazonov.drawers;

import java.awt.*;

public class DDALineDrawer implements LineDrawer{
    private PixelDrawer pd;

    public DDALineDrawer(PixelDrawer pd){
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, Color c) {
        int countSteps= Math.max(Math.abs(x2-x1),Math.abs(y2-y1));
        double dx=(x2-x1)/(double)countSteps;
        double dy = (y2 - y1) /(double) countSteps;
        double x = x1;
        double y = y1;
        for (int i=0; i<=countSteps; i++)
        {
            x+=dx;
            y+=dy;
            pd.setPixel((int)x,(int)y,c);
        }
    }
}
