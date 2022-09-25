package ru.vsu.cs.sazonov.Fruit;

import java.awt.*;

public class Fruit {
    private int x, y;
    private Color color;
    private double scale;
    private boolean state;

    public Fruit(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        scale = 1.0;
        state = true;
    }

    public void draw(Graphics2D g2d){};

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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
