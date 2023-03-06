package com.koval.bulltank1994;

import com.koval.bulltank1994.Tank;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

class EventHandler implements KeyListener, MouseListener {

    private static final boolean[] keys = new boolean[256];
    private Tank tank;

    public EventHandler(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
        if (e.getKeyCode() == tank.getUpKey() || e.getKeyCode() == tank.getDownKey()) {
            tank.setVy(0);
        } else if (e.getKeyCode() == tank.getLeftKey() || e.getKeyCode() == tank.getRightKey()) {
            tank.setVx(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        if (keys[tank.getUpKey()]) {
            tank.setVy(-5);
            tank.setDirection(Tank.UP);
        }
        if (keys[tank.getDownKey()]) {
            tank.setVy(5);
            tank.setDirection(Tank.DOWN);
        }
        if (keys[tank.getLeftKey()]) {
            tank.setVx(-5);
            tank.setDirection(Tank.LEFT);
        }
        if (keys[tank.getRightKey()]) {
            tank.setVx(5);
            tank.setDirection(Tank.RIGHT);
        }
        /*if (keys[tank.getSpaceKey()]) {
            System.out.println("Tank " + tank.getId() + " fired a shot.");
        }*/
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    // Implement the rest of the MouseListener methods here
}