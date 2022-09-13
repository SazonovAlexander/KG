package ru.vsu.cs.sazonov;

import ru.vsu.cs.sazonov.Fruit.Apple;
import ru.vsu.cs.sazonov.Fruit.Cherry;
import ru.vsu.cs.sazonov.Fruit.Fruit;
import ru.vsu.cs.sazonov.Fruit.Pear;

import java.awt.*;
import java.util.Random;

public class Tree {
    private int x, y, countOfFruit, height;
    private Color color;
    private String fruit;

    public Tree(int x, int y, int countOfFruit, int height, Color color, String fruit) {
        this.x = x;
        this.y = y;
        this.countOfFruit = countOfFruit;
        this.height = height;
        this.color = color;
        this.fruit = fruit;
    }

    public void draw(Graphics2D g2d){
        Random rnd = new Random();
        int width = height/3;
        g2d.setColor(new Color(80,50,50));
        g2d.fillRect(x-width/2,y,width,height);
        g2d.setColor(color);
        g2d.fillOval(x,y,width,width);
        g2d.fillOval(x-width,y,width,width);
        g2d.fillOval(x-width/2,y -width/2,width,width);
        g2d.fillOval(x-height/2,y -height/2,height,width);
        g2d.fillOval(x-height/2,y - height/4,height,width);
        g2d.fillOval(x,y - height * 3/4,width,width);
        g2d.fillOval(x-width,y - height *3/4,width,width);
        g2d.fillOval(x-width/2 ,y -height *3 /4 + width/2,width,width);
        switch (fruit){
            case ("apple"):
                for (int i = 0; i < countOfFruit; i++) {
                    int x1 =x - width * 2/3 + rnd.nextInt(5 * width / 6);
                    int y1 =y - height /2 + rnd.nextInt( 2 * height / 3);
                    Apple apple = new Apple(x1,y1,new Color(250, 0,rnd.nextInt(100)));
                    apple.draw(g2d);
                }
                break;
            case ("pear"):
                for (int i = 0; i < countOfFruit; i++) {
                    int x1 =x - width * 2/3 + rnd.nextInt(5 * width / 6);
                    int y1 =y - height /2 + rnd.nextInt( 2 * height / 3);
                    Pear pear = new Pear(x1,y1,new Color(200 + rnd.nextInt(50), 200, 0));
                    pear.draw(g2d);
                }
                break;
            case ("cherry"):
                for (int i = 0; i < countOfFruit; i++) {
                    int x1 =x - width * 2/3 + rnd.nextInt(5 * width / 6);
                    int y1 =y - height /2 + rnd.nextInt( 2 * height / 3);
                    Cherry cherry= new Cherry(x1,y1,new Color(250, 0,rnd.nextInt(100)));
                    cherry.draw(g2d);
                }
                break;
        }
    }
}
