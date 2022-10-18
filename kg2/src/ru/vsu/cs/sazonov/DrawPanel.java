package ru.vsu.cs.sazonov;

import ru.vsu.cs.sazonov.drawers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel {
    private ScreenConverter sc;
    private Point lastPoint = null;
    public DrawPanel(){
        sc = new ScreenConverter(-2,2,4,4,800,600);
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(lastPoint!=null){
                    Point currentPoint = e.getPoint();

                    ScreenPoint delta = new ScreenPoint(-currentPoint.x + lastPoint.x, -currentPoint.y + lastPoint.y);
                    RealPoint rDelta = sc.screenToReal(delta);
                    sc.setX(rDelta.getX());
                    sc.setY( rDelta.getY());
                    lastPoint = currentPoint;
                    repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
                if (x1 < getWidth() && y1<getHeight())
                repaint();
            }
        });
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               /* x1 = e.getX();
                y1 = e.getY();
                if (x1 < getWidth() && y1<getHeight())
                    repaint();*/
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)){
                    lastPoint = e.getPoint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)){
                    lastPoint = e.getPoint();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        ox = new Line(new RealPoint(-1,0), new RealPoint(1,0));
        oy = new Line(new RealPoint(0,-1), new RealPoint(0,1));
        currentLine = new Line(new RealPoint(0,0), new RealPoint(0,0));
    }
    private Line currentLine , ox, oy;
    private int x1, y1;

    @Override
    protected void paintComponent(Graphics g) {
        sc.setScreenWidth(getWidth());
        sc.setScreenHeight(getHeight());
        Graphics2D g2d = (Graphics2D) g;

        BufferedImage bi = new BufferedImage(getWidth(), getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D biG = bi.createGraphics();
        biG.setColor(Color.WHITE);
        biG.fillRect(0,0,getWidth(), getHeight());
        PixelDrawer pd = new BufferedImagePixelDrawer(bi);
        LineDrawer currentLD = new WuLineDrawer(pd);

        drawAll(currentLD);
        g2d.drawImage(bi,0,0,null);
        biG.dispose();

    }

    private void drawAll(LineDrawer ld){

        ld.drawLine(getWidth()/2, getHeight()/2, x1, y1, Color.BLACK);
     //   drawOneLine(ld,ox);
     //   drawOneLine(ld,oy);
     //   drawOneLine(ld,currentLine);
    }

    private void drawOneLine(LineDrawer ld, Line l){
        ScreenPoint p1 = sc.realToScreen(l.getP1());
        ScreenPoint p2 = sc.realToScreen(l.getP2());
        ld.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY(), Color.BLACK);
    }
}
