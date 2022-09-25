package ru.vsu.cs.sazonov;

import java.awt.*;

public class Grass {
    private int x, y;

    public Grass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g){
        g.setColor(new Color(0,150,100));
        g.drawLine(x-10, y, x-10, y-10);
        g.drawLine(x,y, x, y-20);
        g.drawLine(x+10, y, x +10, y-15);
    }
}
