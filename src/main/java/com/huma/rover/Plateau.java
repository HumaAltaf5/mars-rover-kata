package com.huma.rover;

public class Plateau {
    private int maxX;
    private int maxY;

    public void setPlateauSize(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public String getPlateauSize() {
        return maxX + " " + maxY;
    }

    public int getMaxY() {
        return maxY;
    }
}
