package ru.vsu.cs.sazonov.Fruit;

import java.awt.*;

public class Apple {

    private Fruit fruit;

    public Apple(int x, int y, Color color) {
        fruit = new Fruit(x, y, color);
    }

    public void draw(Graphics2D g2d){
        g2d.setColor(Color.BLACK);
        g2d.drawArc(fruit.getX()+1, fruit.getY()-4,4,4,0,50);
        g2d.setColor(fruit.getColor());
        g2d.fillOval(fruit.getX(), fruit.getY(), 10,10);
    }

}
