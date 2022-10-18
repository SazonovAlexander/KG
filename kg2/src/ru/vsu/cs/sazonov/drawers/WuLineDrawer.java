package ru.vsu.cs.sazonov.drawers;

import java.awt.*;

public class WuLineDrawer implements LineDrawer{

    private PixelDrawer pd;

    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, Color c) {
        int x = x1;
        int y = y1;
        int Dx = Math.abs(x2 - x1);
        int Dy = Math.abs(y2 - y1);
        int dX = 1 ,dY = 1;
        if (x1 > x2){
            dX = -1;
        }
        if (y1> y2){
            dY = -1;
        }
        float d;

        Color c1, c2;
        if (Dy < Dx) {
            int e = 2 * Dy - Dx;
            for (int i = 1; i <= Dx; i++) {
                d = -1f * e / (y2-y1 + x2 - x1) / 1.15f;
                if (e >= 0) {
                    c1 = setColor(1F / 2 - d);
                    c2 = setColor(1F / 2 + d);
                    pd.setPixel(x, y, c1);
                    pd.setPixel(x, y + dY, c2);
                    y += dY;
                    e += -2 * Dx + 2 * Dy;
                } else {
                    c1 = setColor(1F / 2 + d);
                    c2 = setColor(1F / 2 - d);
                    pd.setPixel(x, y, c1);
                    pd.setPixel(x, y - dY, c2);
                    e += 2 * Dy;
                }
                x += dX;
            }
        }
        else {
            int e = 2 * Dy - Dx;
            for (int i = 1; i <= Dy; i++) {
                d = -1F * e / (y2-y1 + x2 - x1) / 1.15F;
                if (e >= 0) {
                    c1 = setColor(1F / 2 - d);
                    c2 = setColor(1F / 2 + d);
                    pd.setPixel(x, y, c1);
                    pd.setPixel(x+1, y , c2);
                    x += dX;
                    e += -2 * Dy + 2 * Dx;
                } else {
                    c1 = setColor(1F / 2 + d);
                    c2 = setColor(1F / 2 - d);
                    pd.setPixel(x, y, c1);
                    pd.setPixel(x-1, y, c2);
                    e += 2 * Dx;
                }
                y += dY;
            }
        }
    }

    private Color setColor(float d){
        int c = (int) (255 * d);
        System.out.println(c);
        return new Color(c,c,c);
    }
}
