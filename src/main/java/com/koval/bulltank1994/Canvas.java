package com.koval.bulltank1994;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JFrame {
    private final int width;
    private final int height;

    public Canvas(String title, int width, int height) {
        super(title);
        this.width = width;
        this.height = height;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(width, height);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Color.BLACK);

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.drawString("Tank position: (" + Tank.getX() + ", " + Tank.getY() + ")", 10, 20);
        g.fillOval(Tank.getX() - 10, Tank.getY() - 10, 20, 20);
        g.setColor(Color.RED);
        for (Bullet bullet : Tank.getBullets()) {
            g.fillOval(bullet.getX() - 5, bullet.getY() - 5, 10, 10);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}