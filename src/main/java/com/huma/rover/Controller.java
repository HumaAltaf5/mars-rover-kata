package com.huma.rover;


import static com.huma.rover.Direction.North;

public class Controller {
    Direction direction = North;
    public String moveRover(String command) {

        if (command.equals("L")) {
            return rotateLeft();
        } else if (command.equals("R")) {
            return rotateRight();
        }
        return null;
    }

    public String rotateLeft() {

        if(direction.getDirection().equals("N")) {
            return "W";
        } else if (direction.getDirection().equals("S")) {
            return "E";
        } else if (direction.getDirection().equals("E")) {
            return "N";
        } else if (direction.getDirection().equals("W")) {
            return "S";
        }
        return null;
    }

    public String rotateRight() {
        if(direction.getDirection().equals("N")) {
            return "E";
        } else if (direction.getDirection().equals("S")) {
            return "W";
        } else if (direction.getDirection().equals("E")) {
            return "S";
        } else if (direction.getDirection().equals("W")) {
            return "N";
        }
        return null;
    }

}
