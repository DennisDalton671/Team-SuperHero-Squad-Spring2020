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
	Connector connector;

	Player player;
	ArrayList<Room> list;
	
	public InputC() {
		
		url = "jdbc:ucanaccess://Resource/SoftDevPro_2.accdb";
		list = new ArrayList<Room>();
		connector = new Connector();
		player = new Player("P1", "100", "5", "RM_1", "None");
		
		player.addInventory("AR_KEY5");
		
		try {
			Connection con = DriverManager.getConnection(url);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(
					"SELECT room_id, room, floor, room_desc, monster_id, item_id, puzzle_id, north_id, south_id, west_id, east_id, key  FROM rooms");
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
				String key = rs.getString(12);
				list.add(new Room(room_id, room, floor, room_desc, monster_id, item_id, puzzle_id, north_id, south_id,
						west_id, east_id, key));
				System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void checkUserInput(String s) {
		connector.setOutput(checkDirection(s));
   
		setChanged();
		notifyObservers(connector);
	}

	public String checkDirection(String s) {
		String output = "";
		int temp = checkCurrentRoom();
		// expects North, East, South, or West as an answer
		// if the Answer is NORTH
		if (s.equalsIgnoreCase("NORTH")) {
            if (list.get(temp).getNorthID() == null) {
            	output = "You can not go that way";
            } else if (list.get(temp).getNorthID() != null) {
            	if (!list.get(checkNorthRoom()).getKey().equalsIgnoreCase("0")) {
            		if (player.checkKey(list.get(checkNorthRoom()).getKey())) {
            			player.setRoom(list.get(temp).getNorthID());
            			temp = checkCurrentRoom();
            			output = "Room Unlocked\n"  + list.get(temp).getDescription();
            		} else {
            			output = "Key Required";
            		}
            	} else {
            		player.setRoom(list.get(temp).getNorthID());
        			temp = checkCurrentRoom();
        			output = list.get(temp).getDescription();
            	}
            }
        }
        // if the Answer is EAST
        else if (s.equalsIgnoreCase("EAST")) {
            if (list.get(temp).getEastID() == null) {
            	output = "You can not go that way";
            } else if (list.get(temp).getEastID() != null) {
            	if (!list.get(checkEastRoom()).getKey().equalsIgnoreCase("0")) {
            		if (player.checkKey(list.get(checkEastRoom()).getKey())) {
            			player.setRoom(list.get(temp).getEastID());
            			temp = checkCurrentRoom();
            			output = "Room Unlocked\n"  + list.get(temp).getDescription();
            		} else {
            			output = "Key Required";
            		}
            	} else {
            		player.setRoom(list.get(temp).getEastID());
        			temp = checkCurrentRoom();
        			output = list.get(temp).getDescription();
            	}
            }
        }
        // if the Answer is SOUTH
        else if (s.equalsIgnoreCase("SOUTH")) {
            if (list.get(temp).getSouthID() == null) {
            	output = "You can not go that way";
            } else if (list.get(temp).getSouthID() != null) {
            	if (!list.get(checkSouthRoom()).getKey().equalsIgnoreCase("0")) {
            		if (player.checkKey(list.get(checkSouthRoom()).getKey())) {
            			player.setRoom(list.get(temp).getSouthID());
            			temp = checkCurrentRoom();
            			output = "Room Unlocked\n"  + list.get(temp).getDescription();
            		} else {
            			output = "Key Required";
            		}
            	} else {
            		player.setRoom(list.get(temp).getSouthID());
        			temp = checkCurrentRoom();
        			output = list.get(temp).getDescription();
            	}
            }
        }
        // if the Answer is WEST
        else if (s.equalsIgnoreCase("WEST")) {
            if (list.get(temp).getWestID() == null) {
            	output = "You can not go that way";
            } else if (list.get(temp).getWestID() != null) {
            	if (!list.get(checkWestRoom()).getKey().equalsIgnoreCase("0")) {
            		if (player.checkKey(list.get(checkWestRoom()).getKey())) {
            			player.setRoom(list.get(temp).getWestID());
            			temp = checkCurrentRoom();
            			output = "Room Unlocked\n"  + list.get(temp).getDescription();
            		} else {
            			output = "Key Required";
            		}
            	} else {
            		player.setRoom(list.get(temp).getWestID());
        			temp = checkCurrentRoom();
        			output = list.get(temp).getDescription();
            	}
            }
        }
		return output;
	}
	
	public int checkCurrentRoom() {
		for (int x = 0; x < list.size(); x++) {
			if (list.get(x).getId().equals(player.getRoom())) {
				return x;
			}
		}
		return -1;
	}
	
	public int checkNorthRoom() {
		for (int x = 0; x < list.size(); x++) {
			if (list.get(x).getId().equals(list.get(checkCurrentRoom()).getNorthID())) {
				return x;
			}
		}
		return -1;
	}
	
	public int checkEastRoom() {
		for (int x = 0; x < list.size(); x++) {
			if (list.get(x).getId().equals(list.get(checkCurrentRoom()).getEastID())) {
				return x;
			}
		}
		return -1;
	}
	
	public int checkSouthRoom() {
		for (int x = 0; x < list.size(); x++) {
			if (list.get(x).getId().equals(list.get(checkCurrentRoom()).getSouthID())) {
				return x;
			}
		}
		return -1;
	}
	
	public int checkWestRoom() {
		for (int x = 0; x < list.size(); x++) {
			if (list.get(x).getId().equals(list.get(checkCurrentRoom()).getWestID())) {
				return x;
			}
		}
		return -1;
	}
}
