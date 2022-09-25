package ru.vsu.cs.sazonov.Fruit;

import java.awt.*;

public class Apple extends Fruit{
    
    public Apple(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public void draw(Graphics2D g2d){
        g2d.setColor(Color.BLACK);
        g2d.drawArc(super.getX()+ 1, super.getY()- 4,4, 4,0,50);
        g2d.setColor(super.getColor());
        g2d.fillOval(super.getX(), super.getY(), (int) (super.getScale() * 10),(int) (super.getScale() * 10));
    }

}
