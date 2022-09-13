package ru.vsu.cs.sazonov;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private DrawPanel dp;

    public MainWindow() throws HeadlessException {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        dp = new DrawPanel();
        add(dp);
    }

}
