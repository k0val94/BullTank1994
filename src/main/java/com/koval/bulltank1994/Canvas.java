package com.koval.bulltank1994;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JFrame {
    private Tank tank;
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

        // Initialize the Tank instance
        List<Bullet> bullets = new ArrayList<Bullet>();
        tank = new Tank(100, 100, bullets, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_SPACE, "playerOne_50.png");

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw the tank
        tank.draw(g2d);

        // Draw other objects here...

        // Repaint the canvas
        repaint();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}