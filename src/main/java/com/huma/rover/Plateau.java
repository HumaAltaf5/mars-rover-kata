package com.huma.rover;

import java.util.ArrayList;

public class Plateau {
    private int maxX;
    private int maxY;
    private int obstacleX;
    private int obstacleY;
    private String cardinal;
    private ArrayList obstacles;

    public Plateau(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setObstacle(ArrayList<String> obstacles) {
        this.obstacles = obstacles;
    }

    public ArrayList getObstacles() {
        return obstacles;
    }
}
