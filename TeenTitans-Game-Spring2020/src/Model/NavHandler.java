package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NavHandler {
    // Handles the answer and outputs a room ID.
    public String ResultfromNavAnswer (String answer, Room roomObj) {

        Scanner keyboard = new Scanner(System.in);
        // expects North, East, South, or West as an answer
        boolean validAnswer = false;
        while (validAnswer == false) {

            // if the Answer is NORTH
            if (answer.toUpperCase().equals("NORTH")) {
                if (roomObj.getNorthID() == null) {
                    System.out.println("You cannot go that way");
                    answer = keyboard.nextLine();
                } else if (roomObj.getNorthID() != null) {
                    validAnswer = true;
                    return roomObj.getNorthID();
                }
            }
            // if the Answer is EAST
            else if (answer.toUpperCase().equals("EAST")) {
                if (roomObj.getEastID() == null) {
                    System.out.println("You cannot go that way");
                    answer = keyboard.nextLine();
                } else if (roomObj.getEastID() != null) {
                    validAnswer = true;
                    return roomObj.getEastID();
                }
            }
            // if the Answer is SOUTH
            else if (answer.toUpperCase().equals("SOUTH")) {
                if (roomObj.getSouthID() == null) {
                    System.out.println("You cannot go that way");
                    answer = keyboard.nextLine();
                } else if (roomObj.getSouthID() != null) {
                    validAnswer = true;
                    return roomObj.getSouthID();
                }
            }
            // if the Answer is WEST
            else if (answer.toUpperCase().equals("WEST")) {
                if (roomObj.getWestID() == null) {
                    System.out.println("You cannot go that way");
                    answer = keyboard.nextLine();
                } else if (roomObj.getWestID() != null) {
                    validAnswer = true;
                    return roomObj.getWestID();
                }
            }

            // if the Answer is anything but NORTH, EAST, SOUTH, or WEST
            else {
                return "";
            }
        }


        return "";
    }
}