package com.koval.bulltank1994;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class Tank {
    private static final int SPEED = 5;
    private static int x;
    private static int y;
    private static int angle = 0;

    private static final int BULLET_SPEED = 10;
    private static final int BULLET_COOLDOWN = 5;
    private static int bulletCooldown = 0;

    private static List<Bullet> bullets;

    public Tank(int x, int y, List<Bullet> bullets) {
        Tank.x = x;
        Tank.y = y;
        Tank.bullets = bullets;
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static List<Bullet> getBullets() {
        return bullets;
    }

    public void update() {
        if (bulletCooldown > 0) {
            bulletCooldown--;
        }

        for (Bullet bullet : bullets) {
            bullet.update();
        }

        int dx = 0;
        int dy = 0;

        switch (angle) {
            case 0:
                dy = -SPEED;
                break;
            case 90:
                dx = SPEED;
                break;
            case 180:
                dy = SPEED;
                break;
            case 270:
                dx = -SPEED;
                break;
        }

        x += dx;
        y += dy;
    }

    public void shoot() {
        if (bulletCooldown == 0) {
            bullets.add(new Bullet(x, y, angle, BULLET_SPEED));
            bulletCooldown = BULLET_COOLDOWN;
        }
    }

    public void turnLeft() {
        angle = (angle + 270) % 360;
    }

    public void turnRight() {
        angle = (angle + 90) % 360;
    }
}

