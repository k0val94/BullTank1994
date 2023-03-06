package com.koval.bulltank1994;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int CANVAS_WIDTH = 500;
    private static final int CANVAS_HEIGHT = 500;
    private static final int TANK_START_X = CANVAS_WIDTH / 2;
    private static final int TANK_START_Y = CANVAS_HEIGHT / 2;

    private Canvas canvas;
    private Tank tank;
    private List<Bullet> bullets;

    public Game() {
        canvas = new Canvas("BullTank 1994", CANVAS_WIDTH, CANVAS_HEIGHT);
        List<Bullet> bullets = new ArrayList<>();

        canvas.addMouseListener(new EventHandler(tank));
        canvas.addKeyListener(new EventHandler(tank));
    }

    public void start() {
        while (true) {
            tank.update();
            canvas.repaint();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}