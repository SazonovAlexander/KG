package ru.vsu.cs.sazonov;

import ru.vsu.cs.sazonov.Fruit.Apple;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.nio.file.Path;
import java.sql.Time;

public class DrawPanel extends JPanel {

    private Sun s;
    private Tree treeApple1;
    private Tree treePear;
    private Tree treeCherry1;
    private Tree treeCherry2;
    private Tree treeApple2;


    public DrawPanel() {
        s = new Sun(70,100,40,50,25, Color.ORANGE);
        treeApple1 = new Tree(200,175,1,50,new Color(100, 175, 100), "apple");
        treePear = new Tree(100,300, 5, 150, new Color(100,180,70), "pear");
        treeCherry1 = new Tree(550,400,8,225,new Color(100, 150, 100), "cherry");
        treeCherry2 = new Tree(700,225,3,125,new Color(100, 150, 100), "cherry");
        treeApple2 = new Tree(500,200,3,75,new Color(100, 175, 100), "apple");
    }

    @Override
    protected void paintComponent(Graphics g) {
            Graphics2D gr = (Graphics2D) g;
            gr.setColor(new Color(200, 250, 250));
            gr.fillRect(0, 0, getWidth(), getHeight() / 2);
            gr.setColor(Color.GREEN);
            gr.fillRect(0, getHeight() / 3, getWidth(), getHeight());
            gr.setColor(Color.WHITE);
            gr.fillOval(400,37,50,50);
            gr.fillOval(425,25,75,75);
            gr.fillOval(450,25,100,100);
        gr.fillOval(520,37,75,75);
        gr.fillOval(560,37,50,50);
        gr.fillOval(220,45,75,75);
        gr.fillOval(260,45,50,50);
        gr.fillOval(195,65,50,50);
            gr.setColor(Color.CYAN);
            Path2D path = new Path2D.Double();
            path.moveTo(250, getHeight() / 3);
           path.curveTo(250, getHeight() / 3, 450, 275, 200, 400);
        path.curveTo(200, 400, 100, 500, 200, getHeight());
        path.lineTo(500, getHeight());
        path.curveTo(500, 600, 300, 500, 450, 350);
        path.curveTo(450, 350, 500, 300, 350, getHeight() / 3);
        path.lineTo(250, getHeight() / 3);
        path.closePath();
            gr.fill(path);
            s.draw(gr);
           treeApple1.draw(gr);
           treePear.draw(gr);
            treeCherry2.draw(gr);
            treeApple2.draw(gr);
        treeCherry1.draw(gr);
    }
}
