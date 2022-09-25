package ru.vsu.cs.sazonov.Fruit;

import java.awt.*;

public class Pear extends Fruit {

    public Pear(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public void draw(Graphics2D g2d){
        g2d.setColor(Color.BLACK);
        g2d.drawArc( super.getX() - 5, super.getY()- 8, 4, 4,0,50);
        g2d.setColor(super.getColor());
        g2d.fillOval(super.getX()- 5, super.getY(), (int) (super.getScale() * 10),(int) (super.getScale() * 10));
        g2d.fillOval(super.getX()- 3, super.getY()- 5, (int) (super.getScale() * 6),(int) (super.getScale() * 10));

    }
}
