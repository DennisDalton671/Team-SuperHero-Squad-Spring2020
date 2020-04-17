package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class InputC extends java.util.Observable {

	String url;

	// Rooms ################
	ArrayList<Room> list;
	String room;
	
	public InputC() {
		
		url = "jdbc:ucanaccess://Resource/SoftDevPro_1.accdb";
		list = new ArrayList<Room>();
		room = "RM_1";
		
		try {
			Connection con = DriverManager.getConnection(url);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(
					"SELECT room_id, room, floor, room_desc, monster_id, item_id, puzzle_id, north_id, south_id, west_id, east_id, item_id2, item_id3  FROM rooms");
			while (rs.next()) {
				String room_id = rs.getString(1);
				String room = rs.getString(2);
				String floor = rs.getString(3);
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
				list.add(new Room(room_id, room, floor, room_desc, monster_id, item_id, puzzle_id, north_id, south_id,
						west_id, east_id, item_id2, item_id3));
				System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void checkUserInput(String s) {
		
		String output = "";
		output = checkDirection(s);
   
		setChanged();
		notifyObservers(output);
	}

	
	public String checkDirection(String s) {
		String output = "";
		int temp = checkCurrrentRoom();
		// expects North, East, South, or West as an answer
		// if the Answer is NORTH
		if (s.equalsIgnoreCase("NORTH")) {
            if (list.get(temp).getNorthID() == null) {
            	output = "You can not go that way";
            } else if (list.get(temp).getNorthID() != null) {
            	room = list.get(temp).getNorthID();
            	temp = checkCurrrentRoom();
            	output = list.get(temp).getDescription();
            }
        }
        // if the Answer is EAST
        else if (s.equalsIgnoreCase("EAST")) {
            if (list.get(temp).getEastID() == null) {
            	output = "You can not go that way";
            } else if (list.get(temp).getEastID() != null) {
            	room = list.get(temp).getEastID().substring(3);
            	temp = checkCurrrentRoom();
            	output = list.get(temp).getDescription();
            }
        }
        // if the Answer is SOUTH
        else if (s.equalsIgnoreCase("SOUTH")) {
            if (list.get(temp).getSouthID() == null) {
            	output = "You can not go that way";
            } else if (list.get(temp).getSouthID() != null) {
            	room = list.get(temp).getSouthID().substring(3);
            	temp = checkCurrrentRoom();
            	output = list.get(temp).getDescription();
            }
        }
        // if the Answer is WEST
        else if (s.equalsIgnoreCase("WEST")) {
            if (list.get(temp).getWestID() == null) {
            	output = "You can not go that way";
            } else if (list.get(temp).getWestID() != null) {
            	room = list.get(temp).getWestID();
            	temp = checkCurrrentRoom();
            	output = list.get(temp).getDescription();
            }
        }
		return output;
	}
	
	public int checkCurrrentRoom() {
		for (int x = 0; x < list.size(); x++) {
			if (list.get(x).getId().equals(room)) {
				return x;
			}
		}
		return -1;
	}
	
}
