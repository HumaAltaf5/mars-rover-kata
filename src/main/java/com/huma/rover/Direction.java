package com.huma.rover;

public enum Direction {
    North ("N"),
    South ("S"),
    East ("E"),
    West ("W");

    private String cardinalValue;

    Direction(String direction) {
        this.cardinalValue = direction;
    }

    public String getDirection() {
        return cardinalValue;
    }

     public void setDirection(String cardinal) {
        this.cardinalValue = cardinal;
    }


}
