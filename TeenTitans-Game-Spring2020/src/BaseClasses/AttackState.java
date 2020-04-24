package BaseClasses;


import Model.Player;
import Model.Monster;

import java.util.Scanner;

public class AttackState {

    /* Here's the Attack State method version 2.0.

        Change log
     -> Overhauled the Attack state, now has question and answer format
     -> AttackState now returns a string intended on either returning quit or the reward id from monster
     -> New Command = Quit - Allows the player to stop fighting the monster
     ->

    This method should be used when the player engages a monster.
    This method was made base off the Attack Monster functional requirement (ID: FR3.2)

                                                                                   ------------------
                                                                                   -= Description =-
                                                                                   ------------------
   => "Assuming the player is in the same room as a monster, and the monster hasn't been defeated yet, the player must be able to type Attack or Hit followed by monster name.
   =>  After each attack command, the monster's HP will be subtracted by the player's AP and the monster will counter-attack.
   =>  If the monster can counter-attack, the player's HP will be subtracted from the monster's AP.
   =>  When the monster's HP reaches 0, the monster will be defeated and will not spawn in that room anymore.
   =>  After the monster is defeated, the player will be told that the monster is defeated and the items that the monster had will be removed from their inventory and added to the player's inventory."


    */
    public static String attackState(Player player, Monster monster) throws InterruptedException {

        // Scanner for inputs, String for answers, hint counter
        Scanner keyboard = new Scanner(System.in);
        boolean battleState = true;
        int turnCount = 1;
        String answer = "";

        while (battleState) {

            // Shows Turn, health for player and monster, attack of player and monster, and what's currently in the inventory
            System.out.println("Turn: " + turnCount);
            System.out.println(monster.getName() + " Health: " + monster.getHealth());
            System.out.println(monster.getName() + " Attack power: " + monster.getAttack());
            //Displays Type Attack of hit once
            if (turnCount == 1) {
                System.out.println("Type Attack or Hit");
            }


            if (turnCount % 2 != 0) {
                // ##################### Question #####################
                boolean WaitingForAnswer = true;
                while (WaitingForAnswer) {
                    answer = keyboard.nextLine();

                    // If player types Attack or Hit, it sets the answer to Attack or Hit
                    if (answer.toUpperCase().equals("ATTACK") || answer.toUpperCase().equals("HIT")) {
                        WaitingForAnswer = false;
                    }

                    // If player types quit, the battle will stop
                    else if (answer.toUpperCase().equals("QUIT")) {
                        WaitingForAnswer = false;
                    }

                    // If player provides any other answer
                    else {
                        System.out.println("Please type a valid answer");
                    }
                }
                // ##################### Question ##################### (End)

                // ##################### Answer #####################
                boolean result = true;
                while (result){

                    // => result from the answer is a hint that displays depending on what the hint counter is <=


                    // result from player typing attack or hit, in which the monster's health will be subtracted by player's attack
                    if (answer.toUpperCase().equals("ATTACK") || answer.toUpperCase().equals("HIT")) {
                        monster.setHealth(Integer.toString(Integer.parseInt(monster.getHealth()) - Integer.parseInt(player.getAttack())));
                        System.out.println();
                        System.out.println();
                        System.out.println("You attack the " + monster.getName() + " and do " + player.getAttack() + " damage!");
                        result = false;
                    }

                    // result being quit, in which case the battleState closes
                    if (answer.toUpperCase().equals("QUIT")) {
                        System.out.println("You run away from the monster");
                        result = false;
                        battleState = false;
                        return "quit";
                    }

                    // Checks if monster has less than zero health to determine whether it's defeated or not
                    if (Integer.parseInt(monster.getHealth()) <= 0) {
                        battleState = false;
                        System.out.println("You win!");
                        result = false;
                        battleState = false;
                        return monster.getItemReward();
                    }

                }
                // ##################### Answer ##################### (End)

                //Turn count increases by one
                turnCount++;

            }

            else {

                // Monster's turn to attack
                if (turnCount % 2 == 0) {
                    player.setHealth(Integer.toString(Integer.parseInt(player.getHealth()) - Integer.parseInt(monster.getAttack())));
                    Thread.sleep(1000);
                    System.out.println();
                    System.out.println();
                    System.out.println("Monster attacks you and does " + monster.getAttack() + " damage!");


                    // Checks if player has less than zero health to determine whether it's defeated or not
                    if (Integer.parseInt(player.getHealth() ) <= 0) {
                        System.out.println("You lose!");
                        battleState = false;
                    }

                }
                //Turn count increases by one
                turnCount++;

            }

        }
        return "quit";
    }


        }

