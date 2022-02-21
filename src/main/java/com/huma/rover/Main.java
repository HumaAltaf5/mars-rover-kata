package com.huma.rover;

import java.util.Scanner;
import static com.huma.rover.Direction.*;

public class Main {
    public static void main(String args[]) {
        Direction direction = N;
        Coordinate coordinate = new Coordinate();
        Controller controller = new Controller();
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Mars Rover Program");
        System.out.println("Instructions to the Rover can be entered below");
        System.out.println("Enter x coordinate for Plateau size :");
        int maxX = scan.nextInt();
        System.out.println("Enter y coordinate for Plateau size :");
        int maxY = scan.nextInt();
        Plateau plateau = new Plateau(maxX, maxY);
        Vehicle rover = new MarsRover(direction, coordinate, plateau);
        System.out.println("Enter x coordinate for Rover :");
        int x = scan.nextInt();
        System.out.println("Enter y coordinate for Rover :");
        int y = scan.nextInt();
        System.out.println("Enter direction for Rover eg N/S/E/W :");
        String cardinal = scan.next().toUpperCase();
        controller.setRoverPosition(x, y, cardinal, coordinate, direction, plateau);
        do {
            System.out.println("Enter commands to rotate or move Rover eg, L for Left, M for Move and Right :");
            String move = scan.next().toUpperCase();
            String finalPosition = controller.executeCommands(move, rover, coordinate, direction);
            System.out.println("Rover current postion is " + finalPosition);
            System.out.println("Continue moving Rovers ? Enter y/n :");
        } while (scan.next().equalsIgnoreCase("y"));
        System.out.println("Bye, Have a good day!");
    }
}
