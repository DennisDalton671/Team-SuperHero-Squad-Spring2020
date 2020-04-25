package BaseClasses;


import java.util.Scanner;

public class AttackState {

    /* Here's the Attack State method version 1.0.

    This method should be used when the player engages a monster.
    This method was made base off the Attack Monster functional requirement (ID: FR3.2)

                                                                                   ------------------
                                                                                   -= Description =-
                                                                                   ------------------
   => "Assuming the player is in the same room as a monster, and the monster hasnâ€™t been defeated yet, the player must be able to type â€œAttackâ€� or â€œHitâ€� followed by monster name.
   =>  After each attack command, the monsterâ€™s HP will be subtracted by the playerâ€™s AP and the monster will counter-attack.
   =>  If the monster can counter-attack, the playerâ€™s HP will be subtracted from the monsterâ€™s AP.
   =>  When the monsterâ€™s HP reaches 0, the monster will be defeated and will not spawn in that room anymore.
   =>  After the monster is defeated, the player will be told that the monster is defeated and the items that the monster had will be removed from their inventory and added to the playerâ€™s inventory."


    */
    public static void attackState(Monster monster) throws InterruptedException {
        Scanner keyboard = new Scanner(System.in);
        boolean battleState = true;
        int playerhealth = 100;
        int playerAttack = 5;
        int turnCount = 1;
        String answer;
        while (battleState) {
            // Shows Turn, health for player and monster, attack of player and monster, and what's currently in the inventory
            System.out.println("Turn: " + turnCount);
            System.out.println("Health: " + playerhealth + "         " + monster.getName() + " Health: " + monster.getHealth());
            System.out.println("Attack power: " + playerAttack + "     " + monster.getName() + " Attack power: " + monster.getAttackPoints());
            System.out.println("Inventory: " /* Inventory goes here */);
                //Displays Type Attack of hit once
            if (turnCount == 1) {
                System.out.println("Type Attack or Hit");
            }
            int rand = (int) (Math.random() * 100);

            if (turnCount % 2 != 0) {
                answer = keyboard.nextLine();
                // Player Attacks Monster, Monster attacks back

                // Player types attack or hit.
                if (answer.toUpperCase().equals("ATTACK") || answer.toUpperCase().equals("HIT")) {
                    monster.setHealth(Integer.toString(Integer.parseInt(monster.getHealth()) - playerAttack));
                    System.out.println();
                    System.out.println();
                    System.out.println("You attack the " + monster.getName() + " and do " + playerAttack + " damage!");
                }

                // Checks if monster has less than zero health to determine whether it's defeated or not
                if (Integer.parseInt(monster.getHealth()) <= 0) {
                    battleState = false;
                    System.out.println("You win!");
                }
            }

            // Monster's turn to attack
            if (turnCount % 2 == 0) {
                playerhealth = (playerhealth - Integer.parseInt(monster.getAttackPoints()));
                Thread.sleep(1000);
                System.out.println();
                System.out.println();
                System.out.println("Monster attacks you and does " + monster.getAttackPoints() + " damage!");


                // Checks if player has less than zero health to determine whether it's defeated or not
                if (playerhealth <= 0) {
                    System.out.println("You lose!");
                    battleState = false;
                    }

                }
            //Turn count increases by one
            turnCount++;
            }

        }
    }

