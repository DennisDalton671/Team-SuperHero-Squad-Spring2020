package BaseClasses;

import java.util.ArrayList;
import java.util.Scanner;

public class PuzzleState {
    /* Here's the Puzzle State method version 1.0.

    This method should be used when the player engages in a puzzle.
    This method was made with the 3.2.5 Puzzle Feature in mind from the TeenTitans_MansionEscapeRequirments in mind.
    Due to type constraints, the puzzles had to be modified and more user friendly.

     */


    public static String puzzleState(Puzzle puzzle) {

        // Loads Hint info in an arraylist of Strings if there are any
        ArrayList<String> HintInfo = new ArrayList<String>();
        if (!(puzzle.getHint1().equals("0"))){
            HintInfo.add(puzzle.getHint1());
        }
        if (!(puzzle.getHint2().equals("0"))){
            HintInfo.add(puzzle.getHint2());
        }
        if (!(puzzle.getHint3().equals("0"))){
            HintInfo.add(puzzle.getHint3());
        }
        if (!(puzzle.getHint4().equals("0"))){
            HintInfo.add(puzzle.getHint4());
        }

        // Scanner for inputs, String for answers, hint counter
        Scanner keyboard = new Scanner(System.in);
        String answer = "";
        int hintCount = 1;

        // Displays descriptions if there are any
        if (!puzzle.getDescription().equals("0")) {
            System.out.println( puzzle.getDescription()  );
        }
        if (!puzzle.getDescription2().equals("0")) {
            System.out.println(puzzle.getDescription2());
        }
        if (!puzzle.getDescription3().equals("0")) {
            System.out.println(puzzle.getDescription3());
        }
        if (!puzzle.getDescription4().equals("0")) {
            System.out.println(puzzle.getDescription4());
        }
        System.out.println("Figure out the solution for the Puzzle.");
        System.out.println("Type and enter Hint for a hint.");
        System.out.println("Type Quit if you don't want to solve the puzzle.");
        
        
        

        boolean puzzleState = true;
        while (puzzleState) {
            
            boolean WaitingForAnswer = true;
            while (WaitingForAnswer) {
                answer = keyboard.nextLine();

                // If player types Hint, it sets the answer to hint
                if (answer.toUpperCase().equals("HINT")) {
                    WaitingForAnswer = false;
                }

                // If player types Hint, it sets the answer to hint
                else if (answer.equalsIgnoreCase( puzzle.getSolution() ) ){
                    WaitingForAnswer = false;
                }

                // If player types quit, the puzzle will stop
                else if (answer.toUpperCase().equals("QUIT")) {
                    WaitingForAnswer = false;
                }

                // If player provides any other answer
                else {
                    System.out.println("Please type a valid answer");
                }


            }
            boolean result = true;
            while (result){

                // result from the answer is a hint that displays depending on what the hint counter is
                // Hint counter goes from 1-4 and resets back to 1 after 4
                if (answer.toUpperCase().equals("HINT")) {

                    if (hintCount == 1 && HintInfo.size() >= 1) {
                        System.out.println(puzzle.getHint1());
                        hintCount++;
                        result = false;
                    }

                    else if (hintCount == 2 && HintInfo.size() >= 2) {
                        System.out.println(puzzle.getHint2());
                        hintCount++;
                        result = false;
                    }

                    else if (hintCount == 3 && HintInfo.size() >= 3) {
                        System.out.println(puzzle.getHint3());
                        hintCount++;
                        result = false;
                    }

                    else if (hintCount == 4 && HintInfo.size() >= 4) {
                        System.out.println(puzzle.getHint4());
                        hintCount = 1;
                        result = false;
                    }
                }

                // result from the answer being the solution, in which case the player is presented with the puzzle complete description, returns puzzle reward, and puzzleState closes
                if (answer.equalsIgnoreCase( puzzle.getSolution() ) ){
                    System.out.println("You solved the puzzle");  // ###################### Replace this with puzzle completed message after the table has been updated with it ##################
                    result = false;
                    puzzleState = false;
                    return puzzle.getReward();
                }

                // result being quit, in which case the puzzleState closes
                if (answer.toUpperCase().equals("QUIT")) {
                    System.out.println("You quit the puzzle");
                    result = false;
                    puzzleState = false;
                    return "quit";
                }
                
            }






        }
        return "quit";
    }

}
