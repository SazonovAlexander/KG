package ru.vsu.cs.sazonov.Fruit;

import java.awt.*;

public class Cherry extends Fruit{

    public Cherry(int x, int y, Color color){
        super(x, y, color);
    }

    @Override
    public void draw(Graphics2D g2d){
        g2d.setColor(Color.BLACK);
        g2d.drawArc(super.getX(), super.getY(),15,15,0,110);
        g2d.drawArc(super.getX(), super.getY(),5,15,0,50);
        g2d.setColor(super.getColor());
        g2d.fillOval(super.getX()+12, super.getY()+9, (int) (super.getScale() * 6),(int) (super.getScale() * 6));
        g2d.fillOval(super.getX()+2, super.getY()+9, (int) (super.getScale() * 6),(int) (super.getScale() * 6));
    }
}

