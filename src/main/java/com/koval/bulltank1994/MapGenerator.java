package com.koval.bulltank1994;



import java.awt.*;
import java.awt.event.KeyEvent;

public class MapGenerator {

    private final int mapWidth;
    private final int mapHeight;
    private final MapObject[][] map;

    public MapGenerator(String mapData) {
        String[] rows = mapData.split("\n");
        int numRows = rows.length;
        int numCols = rows[0].length();

        mapWidth = numCols * Brick.SIZE;
        mapHeight = numRows * Brick.SIZE;

        map = new MapObject[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                char c = rows[i].charAt(j);
                MapObject obj = null;
                if (c == '#') {
                    obj = new Brick(j * Brick.SIZE, i * Brick.SIZE);
                } else if (c == 'A') {
                    obj = new Tank(j * Brick.SIZE, i * Brick.SIZE, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D);
                } else if (c == 'S') {
                    obj = new Tank(j * Brick.SIZE, i * Brick.SIZE, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
                }

                map[i][j] = obj;
            }
        }
    }

    public MapObject[][] getMap() {
        return map;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                MapObject obj = map[i][j];
                if (obj != null) {
                    obj.draw(g);
                }
            }
        }
    }
}