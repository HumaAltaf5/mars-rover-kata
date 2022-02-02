package com.huma.rover;

public enum Direction {
    NORTH ("N"),
    SOUTH ("S"),
    EAST ("E"),
    WEST ("W");

    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

     public void setDirection(String direction) {
        this.direction = direction;
    }
}
