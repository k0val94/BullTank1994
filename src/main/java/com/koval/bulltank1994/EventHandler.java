package com.koval.bulltank1994;

import com.koval.bulltank1994.Canvas;
import com.koval.bulltank1994.Tank;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class EventHandler implements KeyListener, MouseListener {
    private Tank tank;
    private Canvas canvas;

    public EventHandler(Tank tank, Canvas canvas) {
        this.tank = tank;
        this.canvas = canvas;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                tank.update();
                break;
            case KeyEvent.VK_A:
                tank.turnLeft();
                break;
            case KeyEvent.VK_D:
                tank.turnRight();
                break;
            case KeyEvent.VK_SPACE:
                tank.shoot();
                break;
        }

        canvas.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}