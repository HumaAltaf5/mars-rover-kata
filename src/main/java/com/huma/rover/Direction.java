package com.huma.rover;

public enum Direction {
    N ("N"),
    S ("S"),
    E ("E"),
    W ("W");

    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return this.direction;
    }

     public void setDirection(String direction) {
        this.direction = direction;
    }
}
