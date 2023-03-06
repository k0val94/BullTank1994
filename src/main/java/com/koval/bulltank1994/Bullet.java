package com.koval.bulltank1994;

public class Bullet {
    private int x;
    private int y;
    private int speed;
    private int angle;

    public Bullet(int x, int y, int angle, int speed) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void update() {
        double radians = Math.toRadians(angle);
        int dx = (int) (Math.cos(radians) * speed);
        int dy = (int) (Math.sin(radians) * speed);
        x += dx;
        y += dy;
    }
}