package ru.vsu.cs.sazonov.drawers;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrawer{
    private PixelDrawer pd;

    public BresenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, Color c) {
        int x = x1, y = y1;
        int dX = 1 ,dY = 1;
        if (x1 > x2){
            dX = -1;
        }
        if (y1 > y2){
            dY = -1;
        }
        int Dx = Math.abs(x2 - x1);
        int Dy = Math.abs(y2 - y1);
        if (Dy < Dx) {
            int e = 2 * Dy - Dx;
            for (int i = 1; i <= Dx; i++) {
                pd.setPixel(x, y, c);
                if (e >= 0) {
                    y += dY;
                    e += -2 * Dx + 2 * Dy;
                } else
                    e += 2 * Dy;
                x += dX;
            }
        }
        else {
            int e = 2 * Dx - Dy;
            for (int i = 1; i <= Dy; i++) {
                pd.setPixel(x, y, c);
                if (e >= 0) {
                    x += dX;
                    e += -2 * Dy + 2 * Dx;
                } else
                    e += 2 * Dx;
                y+= dY;
            }
        }

    }
}
