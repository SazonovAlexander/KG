package ru.vsu.cs.sazonov;

import ru.vsu.cs.sazonov.Fruit.Apple;
import ru.vsu.cs.sazonov.Fruit.Cherry;
import ru.vsu.cs.sazonov.Fruit.Fruit;
import ru.vsu.cs.sazonov.Fruit.Pear;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tree {
    private int x, y, countOfFruit, height;
    private Color color;
    private String fruit;
    private List<Fruit> fruitList;


    public Tree(int x, int y, int countOfFruit, int height, Color color, String fruit) {
        this.x = x;
        this.y = y;
        this.countOfFruit = countOfFruit;
        this.height = height;
        this.color = color;
        this.fruit = fruit;
        this.fruitList = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < countOfFruit; i++) {
            int x1 = x - height / 3 * 2 / 3 + rnd.nextInt(5 * height / 3 / 6);
            int y1 = y - height / 2 + rnd.nextInt(2 * height / 3);
            switch (fruit) {
                case ("apple"):
                    Fruit apple = new Apple(x1, y1, new Color(250, 0, rnd.nextInt(100)));
                    fruitList.add(apple);
                    break;
                case ("pear"):
                    Fruit pear = new Pear(x1, y1, new Color(200 + rnd.nextInt(50), 200, 0));
                    fruitList.add(pear);
                    break;
                case ("cherry"):
                    Fruit cherry = new Cherry(x1, y1, new Color(250, 0, rnd.nextInt(100)));
                    fruitList.add(cherry);
                    break;
            }
        }
    }


    public void draw(Graphics2D g2d){
        Random rnd = new Random();
        int width = height/3;
        g2d.setColor(new Color(80,50,50));
        g2d.fillRect(x-width/2/3,y,width/3,height);
        g2d.setColor(color);
        g2d.fillOval(x,y,width,width);
        g2d.fillOval(x-width,y,width,width);
        g2d.fillOval(x-width/2,y -width/2,width,width);
        g2d.fillOval(x-height/2,y -height/2,height,width);
        g2d.fillOval(x-height/2,y - height/4,height,width);
        g2d.fillOval(x,y - height * 3/4,width,width);
        g2d.fillOval(x-width,y - height *3/4,width,width);
        g2d.fillOval(x-width/2 ,y -height *3 /4 + width/2,width,width);
        for (Fruit f:
                fruitList) {
            f.draw(g2d);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCountOfFruit() {
        return countOfFruit;
    }

    public void setCountOfFruit(int countOfFruit) {
        this.countOfFruit = countOfFruit;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public List<Fruit> getFruitList() {
        return fruitList;
    }

    public void setFruitList(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }
}
