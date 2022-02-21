package com.huma.rover;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Plateau {
    private int maxX;
    private int maxY;
    private int obstacleX;
    private int obstacleY;
    private String cardinal;
    private ArrayList obstacles;

    public Plateau(int maxX, int maxY) {
        try {
            if (maxX < 0 || maxY < 0) {
                throw new Exception("Plateau size cannot be negative");
            } else {
                this.maxX = maxX;
                this.maxY = maxY;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Plateau(int maxX, int maxY, ArrayList<String> obstacles) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.obstacles = obstacles;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public ArrayList getObstacles() {
        return obstacles;
    }
}
