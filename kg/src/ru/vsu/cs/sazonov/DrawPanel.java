package ru.vsu.cs.sazonov;

import ru.vsu.cs.sazonov.Fruit.Apple;
import ru.vsu.cs.sazonov.Fruit.Fruit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.util.*;
import java.util.List;
import java.util.Timer;

public class DrawPanel extends JPanel {

    private Sun s;
    private List<Tree> tree;
    private int xO;
    private Timer timer;
    private List<Grass> grass;
    private  Random random;



    public DrawPanel() {
        random = new Random();
        s = new Sun(70,100,40,50,25, Color.ORANGE);
        tree = new ArrayList<>();
        timer = new Timer();
        xO = 0;
        grass = new ArrayList<>();
        tree.add(new Tree(200,175,1,50,new Color(100, 175, 100), "apple"));
        tree.add(new Tree(100,300, 5, 150, new Color(100,180,70), "pear"));
        tree.add( new Tree(500,200,3,75,new Color(100, 175, 100), "apple"));
        tree.add( new Tree(550,400,8,225,new Color(100, 150, 100), "cherry"));
        tree.add(new Tree(700,225,3,125,new Color(100, 150, 100), "cherry"));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                start();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        gr.setColor(new Color(200, 250, 250));
        gr.fillRect(0, 0, getWidth(), getHeight() / 2);
        gr.setColor(Color.GREEN);
        gr.fillRect(0, getHeight() / 3, getWidth(), getHeight());
        s.draw(gr);
        gr.setColor(Color.WHITE);
        gr.fillOval(xO + 400,37,50,50);
        gr.fillOval(xO + 425,25,75,75);
        gr.fillOval(xO + 450,25,100,100);
        gr.fillOval(xO + 520,37,75,75);
        gr.fillOval(xO + 560,37,50,50);
        gr.fillOval(xO + 220,45,75,75);
        gr.fillOval(xO + 260,45,50,50);
        gr.fillOval(xO + 195,65,50,50);
        for (Grass grass1: grass) grass1.draw(gr);
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

        for (Tree t:
             tree) {
            t.draw(gr);
        }
    }

    private void start(){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (xO != 650){
                    xO ++;
                    repaint();
                }
                else xO = -650;
            }
        },0,100);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                drop();
            }
        },0,5000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                grass.clear();
                for (int i = 0; i < 40; i++) {
                    grass.add(new Grass(random.nextInt(800), 200 + random.nextInt(400)));
                    repaint();
                }
            }
        },0,1000);
    }

    private void drop(){
        Tree tr = tree.get(random.nextInt(tree.size()));
        Fruit fr = tr.getFruitList().get(random.nextInt(tr.getCountOfFruit()));
        if (!fr.isState()) return;
        int i = tr.getHeight() + fr.getY() + 30;
        fr.setState(false);
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                if(fr.getScale() < 1){
                    fr.setScale(fr.getScale() + 0.05);
                    repaint();
                }
                else {
                    fr.setState(true);
                    fr.setScale(1.0);
                    repaint();
                    this.cancel();
                    return;
                }
            }
        };

        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {

                if (fr.getScale() > Math.pow(10, -5)){
                    fr.setScale(fr.getScale()-0.01);
                    repaint();}
                else {

                    fr.setX(tr.getX() - tr.getHeight() / 3 * 2 / 3 + random.nextInt(5 * tr.getHeight() / 3 / 6));
                    fr.setY(tr.getY() - tr.getHeight() / 2 + random.nextInt(2 * tr.getHeight() / 3));
                    this.cancel();
                    timer.schedule(task2,0,50);
                }
            }
        };
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (fr.getY() < i){
                    repaint();
                    fr.setY(fr.getY()+2);}
                else {
                    this.cancel();
                    timer.schedule(task1, 0, 50);
                }
            }
        };
        timer.schedule(task,0,10);

    }


}
