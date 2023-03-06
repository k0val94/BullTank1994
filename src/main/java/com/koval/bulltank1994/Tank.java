package com.koval.bulltank1994;

import java.awt.*;
import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tank extends MapObject {

    public static final int UP = 0;
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int SIZE = 50;
    private int vx, vy, direction, upKey, downKey, leftKey, rightKey, shootKey;

    public Tank(int x, int y, List<Bullet> bullets, int upKey, int downKey, int leftKey, int rightKey, int shootKey, String skin) {
        super(x, y, "/images/playerOne_50.png");
        this.upKey = upKey;
        this.downKey = downKey;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
        this.shootKey = shootKey;
        this.direction = UP;
        this.boundingBox = new Rectangle(x, y, SIZE, SIZE);
        setImage("/images/" + skin);
    }


    public void update() {
        x += vx;
        y += vy;
        super.update();
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setVelocity(int vx, int vy) {
        this.vx = vx;
        this.vy = vy;
    }

    public void stop() {
        vx = 0;
        vy = 0;
    }

    public void fire() {
        // Implement your firing logic here
    }

    public void takeDamage() {
        // Implement your damage logic here
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(getImage(), x, y, null);
    }



}