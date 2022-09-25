package ru.vsu.cs.sazonov;

import ru.vsu.cs.sazonov.Fruit.Fruit;

import java.awt.*;

public class DrawUtils {
    public static void drawSun(Graphics2D gr, int x, int y, int r, int l, int n, Color color){
        gr.setColor(color);
        gr.fillOval(x-r, y-r, 2*r, 2*r);
        double da = 2*Math.PI / n;
        for (int i = 0; i < n; i++) {
            double a = da * i;
            double x1 = x + r * Math.cos(a);
            double y1 = y+ r * Math.sin(a);
            double x2 = x + (r + l) * Math.cos(a);
            double y2 = y + (r + l) * Math.sin(a);
            gr.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        }
    }

}
