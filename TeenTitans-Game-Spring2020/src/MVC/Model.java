package MVC;

import BaseClasses.Monster;
import Model.Item;
import Model.Puzzle;
import Model.Room;

import java.sql.*;
import java.util.ArrayList;

public class Model {

    public static void main(String args[]) {

        String url = "jdbc:ucanaccess://Resource/SoftDevPro_2.accdb";




        // Monster ################
        ArrayList<Monster> mlist = new ArrayList<Monster>();


        try {
            Connection con = DriverManager.getConnection(url);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT monster_id, monster, monster_desc, health_point, attack_point, room_id, defeat_message, item_reward, item_reward2 FROM monsters");
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
                System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



        // Items ################
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
                System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }





    }
}
