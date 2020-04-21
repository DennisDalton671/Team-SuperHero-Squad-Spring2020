package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BaseClasses.Item;

public class InputC extends java.util.Observable {

	String url;
	Connector connector;

	Entity player;
	ArrayList<Room> rList;
	ArrayList<Item> iList;
	ArrayList<Puzzle> pList;
	
	public InputC() {
		
		url = "jdbc:ucanaccess://Resource/SoftDevPro_Final_One_For_Real_JK.accdb";
		rList = new ArrayList<Room>();
		iList = new ArrayList<Item>();
		pList = new ArrayList<Puzzle>();
		connector = new Connector();
		player = new Player("P1", "100", "5", "RM_1", "None", "1");
		
		player.addInventory("AR_KEY5");

	// Rooms ################
	ArrayList<Room> list;
	String room;
	
		
		try {
			Connection con = DriverManager.getConnection(url);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(
					"SELECT room_id, room, floor, room_desc, monster_id, item_id, puzzle_id, north_id, south_id, west_id, east_id, key  FROM rooms");
			while (rs.next()) {
				String room_id = rs.getString(1);
				String room_name = rs.getString(2);
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
				rList.add(new Room(room_id, room_name, floor, room_desc, monster_id, item_id, puzzle_id, north_id, south_id,
						west_id, east_id, key));
				System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	



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

                iList.add(new Item(item_id, item, item_desc, acquired, acquired_additional, item_boost, item_benefit, item_use, craft));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Connection con = DriverManager.getConnection(url);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT puzzle_id, puzzleName, puzzle_desc, hint1, hint2, hint3, hint4, solution, reward, penalty, room_puzzle, completion, itemRequired, itemRequired2, itemRequired3, itemRequired4 FROM puzzles");
            while (rs.next()) {
                String puzzle_id = rs.getString(1);
                String puzzle_name = rs.getString(2);
                String puzzle_desc = rs.getString(3);
                String hint1 = rs.getString(4);
                String hint2 = rs.getString(5);
                String hint3 = rs.getString(6);
                String hint4 = rs.getString(7);
                String solution = rs.getString(8);
                String reward = rs.getString(9);
                String penalty = rs.getString(10);
                String room_puzzle = rs.getString(11);
                String completion = rs.getString(12);
                String itemRequired_1 = rs.getString(13);
                String itemRequired_2  = rs.getString(14);
                String itemRequired_3 = rs.getString(15);
                String itemRequired_4  = rs.getString(16);

                pList.add(new Puzzle(puzzle_id, puzzle_name, puzzle_desc, hint1, hint2, hint3, hint4, solution, reward, penalty, room_puzzle, completion, itemRequired_1, itemRequired_2, itemRequired_3, itemRequired_4));
                System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
	}

	public void checkUserInput(String s) {
		String temp = " ";
		if (s.contains(" ")) {
			temp = s;
		}
		if (((Player) player).getPlayerState().equalsIgnoreCase("1")) {
			if (s.equalsIgnoreCase("North") || s.equalsIgnoreCase("East") || s.equalsIgnoreCase("South")
					|| s.equalsIgnoreCase("West"))
				connector.setOutput(checkDirection(s));
			else if (s.equalsIgnoreCase("Look") || s.equalsIgnoreCase("L")
					|| temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase("Pickup")
					|| s.equalsIgnoreCase("Inventory") || s.equalsIgnoreCase("I")
					|| temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase("Drop") || s.equalsIgnoreCase("Solve"))
				connector.setOutput(roomCommands(s));
			else connector.setOutput("Invalid Input");
		} else if (((Player) player).getPlayerState().equalsIgnoreCase("2")) {
			connector.setOutput("No none puzzling inputs while puzzling");
		} else {
			connector.setOutput("Invalid Input");
		}
		
		
		//rList.get(checkCurrentRoom()).setMap("default.jpg");
		connector.setImage(rList.get(checkCurrentRoom()).getMap());
		
		setChanged();
		notifyObservers(connector);
	}
	
	public void startup() {
		connector.setOutput(rList.get(checkCurrentRoom()).getDescription());
		connector.setImage(rList.get(checkCurrentRoom()).getMap());
		setChanged();
		notifyObservers(connector);
	}

	public String checkDirection(String s) {
		String output = "";
		int temp = checkCurrentRoom();
		// expects North, East, South, or West as an answer
		// if the Answer is NORTH
		if (s.equalsIgnoreCase("NORTH")) {
            if (rList.get(temp).getNorthID() == null) {
            	output = "You can not go that way";
            } else if (rList.get(temp).getNorthID() != null) {
            	if (!rList.get(checkNorthRoom()).getKey().equalsIgnoreCase("0")) {
            		if (((Player) player).checkKey(rList.get(checkNorthRoom()).getKey())) {
            			player.setRoom(rList.get(temp).getNorthID());
            			temp = checkCurrentRoom();
            			output = "Room Unlocked\n"  + rList.get(temp).getDescription();
            		} else {
            			output = "Key Required";
            		}
            	} else {
            		player.setRoom(rList.get(temp).getNorthID());
        			temp = checkCurrentRoom();
        			output = rList.get(temp).getDescription();
            	}
            }
        }
        // if the Answer is EAST
        else if (s.equalsIgnoreCase("EAST")) {
            if (rList.get(temp).getEastID() == null) {
            	output = "You can not go that way";
            } else if (rList.get(temp).getEastID() != null) {
            	if (!rList.get(checkEastRoom()).getKey().equalsIgnoreCase("0")) {
            		if (((Player) player).checkKey(rList.get(checkEastRoom()).getKey())) {
            			player.setRoom(rList.get(temp).getEastID());
            			temp = checkCurrentRoom();
            			output = "Room Unlocked\n"  + rList.get(temp).getDescription();
            		} else {
            			output = "Key Required";
            		}
            	} else {
            		player.setRoom(rList.get(temp).getEastID());
        			temp = checkCurrentRoom();
        			output = rList.get(temp).getDescription();
            	}
            }
        }
        // if the Answer is SOUTH
        else if (s.equalsIgnoreCase("SOUTH")) {
            if (rList.get(temp).getSouthID() == null) {
            	output = "You can not go that way";
            } else if (rList.get(temp).getSouthID() != null) {
            	if (!rList.get(checkSouthRoom()).getKey().equalsIgnoreCase("0")) {
            		if (((Player) player).checkKey(rList.get(checkSouthRoom()).getKey())) {
            			player.setRoom(rList.get(temp).getSouthID());
            			temp = checkCurrentRoom();
            			output = "Room Unlocked\n"  + rList.get(temp).getDescription();
            		} else {
            			output = "Key Required";
            		}
            	} else {
            		player.setRoom(rList.get(temp).getSouthID());
        			temp = checkCurrentRoom();
        			output = rList.get(temp).getDescription();
            	}
            }
        }
        // if the Answer is WEST
        else if (s.equalsIgnoreCase("WEST")) {
            if (rList.get(temp).getWestID() == null) {
            	output = "You can not go that way";
            } else if (rList.get(temp).getWestID() != null) {
            	if (!rList.get(checkWestRoom()).getKey().equalsIgnoreCase("0")) {
            		if (((Player) player).checkKey(rList.get(checkWestRoom()).getKey())) {
            			player.setRoom(rList.get(temp).getWestID());
            			temp = checkCurrentRoom();
            			output = "Room Unlocked\n"  + rList.get(temp).getDescription();
            		} else {
            			output = "Key Required";
            		}
            	} else {
            		player.setRoom(rList.get(temp).getWestID());
        			temp = checkCurrentRoom();
        			output = rList.get(temp).getDescription();
            	}
            }
        }
		return output;
	}
	
	public String roomCommands(String s) {
		String temp = " ";
		if (s.contains(" ")) {
			temp = s;
		}
		String output = "";
		
		if (s.equalsIgnoreCase("Look") || s.equalsIgnoreCase("L")) {
			output = "Room Name: " + rList.get(checkCurrentRoom()).getName() + "\nRoom Description: " + rList.get(checkCurrentRoom()).getDescription() + "\nItem List: " + itemList() + "Puzzle Name: " + checkRoomPuzzle();
		} else if (temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase(("Pickup"))) {
			if (convertIName(temp.substring(temp.indexOf(" ") + 1)).equalsIgnoreCase("false")) {
				output = "Item does not exist";
			}
			if (rList.get(checkCurrentRoom()).pickupItem(convertIName(temp.substring(temp.indexOf(" ") + 1)))) {
				player.addInventory(convertIName(temp.substring(temp.indexOf(" ") + 1)));
				output = "Item added to inventory";
			} else output = "Item not in room";
		} else if (temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase(("Drop"))) {
			if (convertIName(temp.substring(temp.indexOf(" ") + 1)).equalsIgnoreCase("false")) {
				output = "Item does not exist";
			}
			if (player.inventoryCheck(convertIName(temp.substring(temp.indexOf(" ") + 1)))) {
				player.dropInventory(convertIName(temp.substring(temp.indexOf(" ") + 1)));
				rList.get(checkCurrentRoom()).addInventory(convertIName(temp.substring(temp.indexOf(" ") + 1)));
				output = "Item dropped into room";
			} else output = "Item not in inventory";
			
		} else if (s.equalsIgnoreCase("Inventory") || s.equalsIgnoreCase("I")) {
			output = "Inventory: " + showInventory();
		} else if (s.equalsIgnoreCase("Solve")) {
			if (!rList.get(checkCurrentRoom()).getPuzzleID().equalsIgnoreCase("0")) {
				((Player) player).setPlayerState("2");
				output = "You are now puzzling";
			} else {
				output = "No puzzle in the room";
			}
		}
		return output;
	}
	
	public int checkCurrentRoom() {
		for (int x = 0; x < rList.size(); x++) {
			if (rList.get(x).getId().equals(player.getRoom())) {
				return x;
			}
		}
		return -1;
	}
	
	public int checkNorthRoom() {
		for (int x = 0; x < rList.size(); x++) {
			if (rList.get(x).getId().equals(rList.get(checkCurrentRoom()).getNorthID())) {
				return x;
			}
		}
		return -1;
	}
	
	public int checkEastRoom() {
		for (int x = 0; x < rList.size(); x++) {
			if (rList.get(x).getId().equals(rList.get(checkCurrentRoom()).getEastID())) {
				return x;
			}
		}
		return -1;
	}
	
	public int checkSouthRoom() {
		for (int x = 0; x < rList.size(); x++) {
			if (rList.get(x).getId().equals(rList.get(checkCurrentRoom()).getSouthID())) {
				return x;
			}
		}
		return -1;
	}
	
	public int checkWestRoom() {
		for (int x = 0; x < rList.size(); x++) {
			if (rList.get(x).getId().equals(rList.get(checkCurrentRoom()).getWestID())) {
				return x;
			}
		}
		return -1;
	}
	
	public String itemList() {
		String item = "";
		for (int x = 0; x < iList.size(); x++) {
			if (rList.get(checkCurrentRoom()).checkInventory(iList.get(x).getId())) {
				item += "[" + iList.get(x).getItemName() + "] ";
			}
		}
		return item;
	}
	
	public String convertIName(String name) {
		for (int x = 0; x < iList.size(); x++) {
    		if (iList.get(x).getItemName().equalsIgnoreCase(name)) return iList.get(x).getId();
    	}
		return "False";
	}
	
	public String showInventory() {
		ArrayList<String> temp = ((Player) player).showInventory();
		String output = "";
		for (int x = 0; x < iList.size(); x++) {
			for (int y = 0; y < temp.size(); y++) {
				if (iList.get(x).getId().equalsIgnoreCase(temp.get(y)))
					output +=  "[" + iList.get(x).getItemName() + "]";
			}
    	}
		return output;
	}
	
	public String checkRoomPuzzle() {
		if (!rList.get(checkCurrentRoom()).getPuzzleID().equalsIgnoreCase("0")) {
			for (int x = 0; x < pList.size(); x++) {
				if (pList.get(x).getId().equalsIgnoreCase(rList.get(checkCurrentRoom()).getPuzzleID())) {
					return pList.get(x).getDescription();
				}
			}
		}
		return "None";
	}
}
