package com.koval.bulltank1994;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame{

    private static final long serialVersionUID = 1L;

    private int gridSize;
    private int height;
    private int width;
    private String mapFile;
    private List<Tank> tanks;
    private MapObject[][] gameMap;

    public Game(int gridSize, int height, int width, String mapFile) {
        this.gridSize = gridSize;
        this.height = height;
        this.width = width;
        this.mapFile = mapFile;

        loadMap();
        createTanks();

        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setTitle("BullTank1994");
        setResizable(false);
        setVisible(true);
    }

    private void loadMap() {
        String mapData = "#################\n" +
                "#               #\n" +
                "#               #\n" +
                "#   A           #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#               #\n" +
                "#        S      #\n" +
                "#               #\n" +
                "#               #\n" +
                "#################";

        MapGenerator mapGenerator = new MapGenerator(mapData);
        gameMap = mapGenerator.getMap();
    }

    private void createTanks() {
        tanks = new ArrayList<>();

        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                MapObject obj = gameMap[i][j];
                if (obj instanceof Tank) {
                    tanks.add((Tank) obj);
                }
            }
        }
    }

    public void start() {
        while (true) {
            for (Tank tank : tanks) {
                tank.update();
            }
            repaint();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                MapObject obj = gameMap[i][j];
                if (obj != null) {
                    obj.draw(g2d);
                }
            }
        }
    }
}
