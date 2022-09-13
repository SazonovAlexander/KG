package ru.vsu.cs.sazonov.Fruit;

import java.awt.*;

public class Pear {
    private Fruit fruit;

    public Pear(int x, int y, Color color) {
        fruit = new Fruit(x, y, color);
    }

    public void draw(Graphics2D g2d){
        g2d.setColor(Color.BLACK);
        g2d.drawArc(fruit.getX()-5, fruit.getY()-8,4,4,0,50);
        g2d.setColor(fruit.getColor());
        g2d.fillOval(fruit.getX()-5, fruit.getY(), 10,10);
        g2d.fillOval(fruit.getX()-3, fruit.getY()-5, 6,10);
    }
}
