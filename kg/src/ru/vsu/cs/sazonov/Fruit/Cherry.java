package ru.vsu.cs.sazonov.Fruit;

import java.awt.*;

public class Cherry {
    private Fruit fruit;

    public Cherry(int x, int y, Color color) {
        fruit = new Fruit(x, y, color);
    }

    public void draw(Graphics2D g2d){
        g2d.setColor(Color.BLACK);
        g2d.drawArc(fruit.getX(), fruit.getY(),15,15,0,110);
        g2d.drawArc(fruit.getX(), fruit.getY(),5,15,0,50);
        g2d.setColor(fruit.getColor());
        g2d.fillOval(fruit.getX()+12, fruit.getY()+9, 6,6);
        g2d.fillOval(fruit.getX()+2, fruit.getY()+9, 6,6);
    }
}
