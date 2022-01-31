package com.huma.rover;


import static com.huma.rover.Direction.North;

public class Controller {
    Direction direction = North;
    Coordinate coordinate = new Coordinate();
    Plateau plateau  = new Plateau();

    public void setPlateauSize(int x, int y) {

        plateau.setPlateauSize(x, y );

    }



    public void getPosition(int x, int y, String cardinal) {
        coordinate.setX(x);
        coordinate.setY(y);
        direction.setDirection(cardinal);
    }

    public String executeCommands(String command) {
        for (char c : command.toCharArray()) {
            if (c == 'L') {
                rotateLeft();
            } else if (c == 'R') {
                  rotateRight();
            } else if (c == 'M') {
                move();
            }
        }
             return coordinate.getX() + " " + coordinate.getY() + " " + direction.getDirection();
    }

    public void rotateLeft() {
        if(direction.getDirection().equals("N")) {
            direction.setDirection("W");
        } else if (direction.getDirection().equals("S")) {
            direction.setDirection("E");
        } else if (direction.getDirection().equals("E")) {
            direction.setDirection("N");
        } else if (direction.getDirection().equals("W")) {
            direction.setDirection("S");
        }
    }

    public void rotateRight() {
        if(direction.getDirection().equals("N")) {
            direction.setDirection("E");
        } else if (direction.getDirection().equals("S")) {
            direction.setDirection("W");
        } else if (direction.getDirection().equals("E")) {
            direction.setDirection("S");
        } else if (direction.getDirection().equals("W")) {
            direction.setDirection("N");
        }
    }

    public void move() {
        int x = this.coordinate.getX();
        int y = this.coordinate.getY();
        if (direction.getDirection().equals("N")) {
            y = y + 1;
        } else if (direction.getDirection().equals("S")) {
            y = (y > 0) ? y - 1 : y;
            //y = y - 1;
        } else if (direction.getDirection().equals("E")) {
            x = x + 1;
        } else if (direction.getDirection().equals("W")) {
            x = (x > 0) ? x - 1 : x;
        }

        coordinate.setX(x);
        coordinate.setY(y);
    }

}
