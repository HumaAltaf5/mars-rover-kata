package com.huma.rover;

public class Plateau {
    private int maxX;
    private int maxY;
    private int obstacleX;
    private int obstacleY;
    private String cardinal;

    public void setPlateauSize(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setObstacle(int x, int y, String cardinalVal) {
        this.obstacleX = x;
        this.obstacleY = y;
        this.cardinal = cardinalVal;
    }

    public int getObstacleX() {
        return obstacleX;
    }

    public int getObstacleY() {
        return obstacleY;
    }

    public String getCardinal() {
        return cardinal;
    }
}
