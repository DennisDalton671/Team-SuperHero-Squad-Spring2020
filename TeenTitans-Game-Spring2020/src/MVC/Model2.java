package MVC;

import BaseClasses.Item;
import BaseClasses.Monster;
import BaseClasses.Puzzle;
import Model.Room;

import java.sql.*;
import java.util.ArrayList;

public class Model2 {

    public static void main(String args[]) {

<<<<<<< HEAD
        String url = "jdbc:ucanaccess://Resource/SoftDevPro.accdb";

=======
<<<<<<< HEAD
<<<<<<<< HEAD:TeenTitans-Game-Spring2020/src/MVC/Model2.java
        String url = "jdbc:ucanaccess://Resource/SoftDevPro.accdb";

        // Rooms ################
=======
        String url = "jdbc:ucanaccess://Resource/SoftDevPro.accdb";

>>>>>>> Dennis
>>>>>>> 32b070bc1de243585fb143f96e81a9ea29579d0a
        ArrayList<Room> list = new ArrayList<Room>();

        try {
            Connection con = DriverManager.getConnection(url);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT room_id, room, floor, room_desc, monster_id, item_id, puzzle_id, north_id, south_id, west_id, east_id, item_id2, item_id3  FROM rooms");
            int count = 0;
            while (rs.next()) {
                String room_id = rs.getString(1);
                String room = rs.getString(2);
                String floor = rs.getNString(3);
                String room_desc = rs.getString(4);
                String monster_id = rs.getString(5);
                String item_id = rs.getString(6);
                String puzzle_id = rs.getString(7);
                String north_id = rs.getString(8);
                String south_id = rs.getString(9);
                String west_id = rs.getString(10);
                String east_id = rs.getString(11);
                String item_id2 = rs.getString(12);
                String item_id3 = rs.getString(13);
<<<<<<< HEAD
                //list.add(new Room(room_id, room, floor, room_desc, monster_id, item_id, puzzle_id, north_id, south_id, west_id, east_id, item_id2, item_id3));
=======
<<<<<<< HEAD
                list.add(new Room(room_id, room, floor, room_desc, monster_id, item_id, puzzle_id, north_id, south_id, west_id, east_id, item_id2, item_id3));
=======
                //list.add(new Room(room_id, room, floor, room_desc, monster_id, item_id, puzzle_id, north_id, south_id, west_id, east_id, item_id2, item_id3));
>>>>>>> Dennis
>>>>>>> 32b070bc1de243585fb143f96e81a9ea29579d0a
                System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD

        
        
=======
<<<<<<< HEAD
========
        String url = "jdbc:ucanaccess://Resource/SoftDevPro_2.accdb";
>>>>>>>> Dennis:TeenTitans-Game-Spring2020/src/MVC/Model.java



        // Puzzles ################
=======



>>>>>>> Dennis
>>>>>>> 32b070bc1de243585fb143f96e81a9ea29579d0a
        ArrayList<Puzzle> plist = new ArrayList<Puzzle>();

        try {
            Connection con = DriverManager.getConnection(url);
            Statement s = con.createStatement();
<<<<<<< HEAD
=======
<<<<<<< HEAD
            ResultSet rs = s.executeQuery("SELECT puzzle_id, puzzle_desc, puzzle_desc2, puzzle_desc3, puzzle_desc4, hint1, hint2, hint3, hint4, solution, solution2, solution3, solution4, reward, penalty, room_puzzle, room_puzzle2 FROM puzzles");
            while (rs.next()) {
                String puzzle_id = rs.getString(1);
                String puzzle_desc = rs.getString(2);
<<<<<<<< HEAD:TeenTitans-Game-Spring2020/src/MVC/Model2.java
=======
>>>>>>> 32b070bc1de243585fb143f96e81a9ea29579d0a
            ResultSet rs = s.executeQuery("SELECT puzzle_id, puzzle_desc, puzzle_desc2, puzzle_desc3, puzzle_desc4, hint, hint2, hint3, hint4, solution, solution2, solution3, solution4, reward, penalty, room_puzzle, room_puzzle2 FROM puzzles");
            while (rs.next()) {
                String puzzle_id = rs.getString(1);
                String puzzle_desc = rs.getString(2);
<<<<<<< HEAD
=======
>>>>>>> Dennis
>>>>>>> 32b070bc1de243585fb143f96e81a9ea29579d0a
                String puzzle_desc2 = rs.getString(4);
                String puzzle_desc3 = rs.getString(5);
                String puzzle_desc4 = rs.getString(6);
                String hint = rs.getString(7);
                String hint2 = rs.getString(8);
                String hint3 = rs.getString(9);
                String hint4 = rs.getString(10);
                String solution = rs.getString(11);
                String solution2 = rs.getString(12);
                String solution3 = rs.getString(13);
                String solution4 = rs.getString(14);
                String reward = rs.getString(15);
                String penalty = rs.getString(16);
                String room_puzzle = rs.getString(17);
                String room_puzzle2 = rs.getString(18);
<<<<<<< HEAD

                plist.add(new Puzzle(puzzle_id, puzzle_desc, puzzle_desc2, puzzle_desc3, puzzle_desc4, hint, hint2, hint3, hint4, solution, solution2, solution3, solution4, reward, penalty, room_puzzle, room_puzzle2));

=======
<<<<<<< HEAD
========
                String puzzle_desc2 = rs.getString(3);
                String puzzle_desc3 = rs.getString(4);
                String puzzle_desc4 = rs.getString(5);
                String hint = rs.getString(6);
                String hint2 = rs.getString(7);
                String hint3 = rs.getString(8);
                String hint4 = rs.getString(9);
                String solution = rs.getString(10);
                String solution2 = rs.getString(11);
                String solution3 = rs.getString(12);
                String solution4 = rs.getString(13);
                String reward = rs.getString(14);
                String penalty = rs.getString(15);
                String room_puzzle = rs.getString(16);
                String room_puzzle2 = rs.getString(17);
>>>>>>>> Dennis:TeenTitans-Game-Spring2020/src/MVC/Model.java

                plist.add(new Puzzle(puzzle_id, puzzle_desc, puzzle_desc2, puzzle_desc3, puzzle_desc4, hint, hint2, hint3, hint4, solution, solution2, solution3, solution4, reward, penalty, room_puzzle, room_puzzle2));
                System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2));
=======

                plist.add(new Puzzle(puzzle_id, puzzle_desc, puzzle_desc2, puzzle_desc3, puzzle_desc4, hint, hint2, hint3, hint4, solution, solution2, solution3, solution4, reward, penalty, room_puzzle, room_puzzle2));

>>>>>>> Dennis
>>>>>>> 32b070bc1de243585fb143f96e81a9ea29579d0a
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }


<<<<<<< HEAD
=======
<<<<<<< HEAD

        // Monster ################
=======
>>>>>>> Dennis
>>>>>>> 32b070bc1de243585fb143f96e81a9ea29579d0a
        ArrayList<Monster> mlist = new ArrayList<Monster>();


        try {
            Connection con = DriverManager.getConnection(url);
            Statement s = con.createStatement();
<<<<<<< HEAD
            ResultSet rs = s.executeQuery("SELECT monster_id, monster, monster_desc, health_point, attack_point, room_id FROM monsters");
=======
<<<<<<< HEAD
            ResultSet rs = s.executeQuery("SELECT monster_id, monster, monster_desc, health_point, attack_point, room_id, defeat_message, item_reward, item_reward2 FROM monsters");
=======
            ResultSet rs = s.executeQuery("SELECT monster_id, monster, monster_desc, health_point, attack_point, room_id FROM monsters");
>>>>>>> Dennis
>>>>>>> 32b070bc1de243585fb143f96e81a9ea29579d0a
            while (rs.next()) {
                String monster_id = rs.getString(1);
                String monster = rs.getString(2);
                String monster_desc = rs.getString(3);
                String health_point = rs.getString(4);
                String attack_point = rs.getString(5);
                String room_id = rs.getString(6);
                String defeat_message = rs.getString(7);
                String item_reward = rs.getString(8);
                String item_reward2 = rs.getString(9);

                mlist.add(new Monster(monster_id, monster, monster_desc, health_point, attack_point, room_id, defeat_message, item_reward, item_reward2));
<<<<<<< HEAD
            
=======
<<<<<<< HEAD
                System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2));
=======

>>>>>>> Dennis
>>>>>>> 32b070bc1de243585fb143f96e81a9ea29579d0a
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



<<<<<<< HEAD
=======
<<<<<<< HEAD
        // Items ################
=======
>>>>>>> Dennis
>>>>>>> 32b070bc1de243585fb143f96e81a9ea29579d0a
        ArrayList<Item> ilist = new ArrayList<Item>();

        try {
            Connection con = DriverManager.getConnection(url);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT item_id, item, item_desc, acquired, acquired_additional, item_boost, item_benefit, item_use, craft FROM items");
            while (rs.next()) {
                String item_id = rs.getString(1);
                String item = rs.getString(2);
                String item_desc = rs.getString(3);
                String acquired = rs.getString(4);
                String acquired_additional = rs.getString(5);
                String item_boost = rs.getString(6);
                String item_benefit = rs.getString(7);
                String item_use = rs.getString(8);
                String craft = rs.getString(9);

                ilist.add(new Item(item_id, item, item_desc, acquired, acquired_additional, item_boost, item_benefit, item_use, craft));
<<<<<<< HEAD

=======
<<<<<<< HEAD
                System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2));
=======

>>>>>>> Dennis
>>>>>>> 32b070bc1de243585fb143f96e81a9ea29579d0a
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        boolean gameLoop = true;
        while (gameLoop){

            System.out.println(list.get(1));

        }



<<<<<<< HEAD
=======
<<<<<<< HEAD


=======
>>>>>>> Dennis
>>>>>>> 32b070bc1de243585fb143f96e81a9ea29579d0a
    }
}