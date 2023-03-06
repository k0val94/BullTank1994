package com.koval.bulltank1994;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int TANK_START_X = 200;
    private static final int TANK_START_Y = 200;
    private static final int CANVAS_WIDTH = 500;
    private static final int CANVAS_HEIGHT = 500;

    private Canvas canvas;
    private Tank tank;
    private List<Bullet> bullets;

    public Game() {
        canvas = new Canvas("BullTank 1994", CANVAS_WIDTH, CANVAS_HEIGHT);
        bullets = new ArrayList<>();
        tank = new Tank(TANK_START_X, TANK_START_Y, bullets);
        canvas.addMouseListener(new EventHandler(tank, canvas));
        canvas.addKeyListener(new EventHandler(tank, canvas));
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

