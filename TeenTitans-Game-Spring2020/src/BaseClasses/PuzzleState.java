package BaseClasses;

import java.util.ArrayList;
import java.util.Scanner;

public class PuzzleState {

    public static void puzzleState(Puzzle puzzle) {
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


        Scanner keyboard = new Scanner(System.in);
        String answer = "";
        int hintCount = 1;


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
        
        
        

        boolean puzzleState = true;
        while (puzzleState) {
            
            boolean WaitingForAnswer = true;
            while (WaitingForAnswer) {
                answer = keyboard.nextLine();

                if (answer.toUpperCase().equals("HINT")) {
                    WaitingForAnswer = false;
                }

                if (answer.equalsIgnoreCase( puzzle.getSolution() ) ){
                    

                }


            }
            boolean result = true;
            while (result){

                if (answer.toUpperCase().equals("HINT")) {

                    if (hintCount == 1 && HintInfo.size() >= 1) {
                        System.out.println(puzzle.getHint1());
                        hintCount++;
                        result = false;
                    }

                    if (hintCount == 2 && HintInfo.size() >= 2) {
                        System.out.println(puzzle.getHint1());
                        hintCount++;
                        result = false;
                    }

                    if (hintCount == 3 && HintInfo.size() >= 3) {
                        System.out.println(puzzle.getHint1());
                        hintCount++;
                        result = false;
                    }

                    if (hintCount == 4 && HintInfo.size() >= 4) {
                        System.out.println(puzzle.getHint1());
                        hintCount = 1;
                        result = false;
                    }
                }
                
            }






        }

    }

}
