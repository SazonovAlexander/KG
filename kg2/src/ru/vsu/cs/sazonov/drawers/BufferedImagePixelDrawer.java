package ru.vsu.cs.sazonov.drawers;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BufferedImagePixelDrawer implements PixelDrawer{
    private BufferedImage bi;

    public BufferedImagePixelDrawer(BufferedImage bi) {
        this.bi = bi;
    }

    @Override
    public void setPixel(int x, int y, Color c) {
        bi.setRGB(x,y,c.getRGB());
    }
}
