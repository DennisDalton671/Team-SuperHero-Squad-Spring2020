package Model;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputC extends java.util.Observable {

	String url;
	Connector connector;

	Entity player;
	Entity monster;
	Room room;
	ArrayList<Room> rList;
	ArrayList<Item> iList;
	ArrayList<Puzzle> pList;
	ArrayList<Monster> mList;
	ArrayList<Player> plList;

	public InputC() {

		url = "jdbc:ucanaccess://Resource/SoftDevPro_Final_One_For_Real_JK.accdb";
		rList = new ArrayList<Room>();
		iList = new ArrayList<Item>();
		pList = new ArrayList<Puzzle>();
		mList = new ArrayList<Monster>();
		connector = new Connector();

		// player.addInventory("AR_KEY5");

		// Rooms ################
		ArrayList<Room> list;
		String room;

		// ###################################################### Data Loading #################################################################################
		// Loads Room data from database
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
				rList.add(new Room(room_id, room_name, floor, room_desc, monster_id, item_id, puzzle_id, north_id,
						south_id, west_id, east_id, key));
				System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Loads Item data from database
		try {
			Connection con = DriverManager.getConnection(url);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(
					"SELECT item_id, item, item_desc, acquired, acquired_additional, item_boost, item_benefit, item_use, craft FROM items");
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

				iList.add(new Item(item_id, item, item_desc, acquired, acquired_additional, item_boost, item_benefit,
						item_use, craft));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Loads Puzzle data from database
		try {
			Connection con = DriverManager.getConnection(url);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(
					"SELECT puzzle_id, puzzleName, puzzle_desc, hint1, hint2, hint3, hint4, solution, reward, penalty, room_puzzle, completion, itemRequired, itemRequired2, itemRequired3, itemRequired4 FROM puzzles");
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
				String itemRequired_2 = rs.getString(14);
				String itemRequired_3 = rs.getString(15);
				String itemRequired_4 = rs.getString(16);

				pList.add(new Puzzle(puzzle_id, puzzle_name, puzzle_desc, hint1, hint2, hint3, hint4, solution, reward,
						penalty, room_puzzle, completion, itemRequired_1, itemRequired_2, itemRequired_3,
						itemRequired_4));
				System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Loads Monster data from database
		try {
			Connection con = DriverManager.getConnection(url);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(
					"SELECT monster_id, monster, monster_desc, health_point, attack_point, room_id, defeat_message, item_reward FROM monsters");
			while (rs.next()) {
				String monster_id = rs.getString(1);
				String monster = rs.getString(2);
				String monster_desc = rs.getString(3);
				String health_point = rs.getString(4);
				String attack_point = rs.getString(5);
				String room_id = rs.getString(6);
				String defeat_message = rs.getString(7);
				String item_reward = rs.getString(8);

				mList.add(new Monster(monster_id, health_point, attack_point, room_id, monster, monster_desc,
						defeat_message, item_reward));
				System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Loads Monster data from database
		try {
			Connection con = DriverManager.getConnection(url);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(
					"SELECT monster_id, monster, monster_desc, health_point, attack_point, room_id, defeat_message, item_reward FROM monsters");
			while (rs.next()) {
				String monster_id = rs.getString(1);
				String monster = rs.getString(2);
				String monster_desc = rs.getString(3);
				String health_point = rs.getString(4);
				String attack_point = rs.getString(5);
				String room_id = rs.getString(6);
				String defeat_message = rs.getString(7);
				String item_reward = rs.getString(8);

				mList.add(new Monster(monster_id, health_point, attack_point, room_id, monster, monster_desc,
						defeat_message, item_reward));
				System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// imports save data from database
		try {
			Connection con = DriverManager.getConnection(url);
			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("SELECT saveID, health, attack, playerstate, equipped, room_id, items FROM player");
			rs.next();
			String id = rs.getString(1);
			String health = rs.getString(2);
			String attack = rs.getString(3);
			String room_id = rs.getString(6);
			String inventory = rs.getString(7);
			String playerState = rs.getString(4);
			String equipped = rs.getString(5);

			List<String> inventoryL = Arrays.asList(inventory.substring(1, inventory.length() - 1).split(", "));

			ArrayList<String> temp = new ArrayList<String>(inventoryL);

			player = new Player(id, health, attack, room_id, equipped, playerState);
			player.setInventory(temp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// imports load data from database
	public void loadPlayer(Object save) {

		try {
			Connection con = DriverManager.getConnection(url);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(
					"SELECT monster_id, monster, monster_desc, health_point, attack_point, room_id, defeat_message, item_reward FROM monsters");
			while (rs.next()) {
				String monster_id = rs.getString(1);
				String monster = rs.getString(2);
				String monster_desc = rs.getString(3);
				String health_point = rs.getString(4);
				String attack_point = rs.getString(5);
				String room_id = rs.getString(6);
				String defeat_message = rs.getString(7);
				String item_reward = rs.getString(8);

				mList.add(new Monster(monster_id, health_point, attack_point, room_id, monster, monster_desc,
						defeat_message, item_reward));
				System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	// ###################################################### Data Loading #################################################################################


	// Checks the user's input
	public void checkUserInput(String s) {
		String temp = " ";
		if (s.contains(" ")) {
			temp = s;
		}

		// Prints the Player state in the console.
		/*
		1 = Navigation State
		2 = Puzzle     State
		3 = Battle     State
		 */
		System.out.println(( (Player) player).getPlayerState());


		// Commands that are active during player state 2 (Puzzle State)
		if (((Player) player).getPlayerState().equalsIgnoreCase("2")) {

					// List Of all Commands the user can input
			if (       s.equalsIgnoreCase("Give up")
					|| s.equalsIgnoreCase("leave")
					|| s.equalsIgnoreCase(getCurrentPuzzle().getSolution())
					|| s.equalsIgnoreCase("observe")
					|| s.equalsIgnoreCase("hint") )
			{
				connector.setOutput(puzzleCommands(s));
			}

			else {
				connector.setOutput("No none puzzling inputs while puzzling");
			}

		}

		// Commands that are active during player state 3 (Battle State)
		if (((Player) player).getPlayerState().equalsIgnoreCase("3")) {

			if (       s.equalsIgnoreCase("pull out")
					|| s.equalsIgnoreCase("retreat")
					|| s.equalsIgnoreCase("inspect")
					|| s.equalsIgnoreCase("attack")
					|| temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase("use"))
			{
				connector.setOutput(monsterCommands(s));
			}

			else {
				connector.setOutput("No none battling inputs while battling");
			}
		}

		// Commands that are active during player state 1 (Navigation State)
		else if (((Player) player).getPlayerState().equalsIgnoreCase("1")) {

			if (       s.equalsIgnoreCase("North")
					|| s.equalsIgnoreCase("East")
					|| s.equalsIgnoreCase("South")
					|| s.equalsIgnoreCase("West"))
			{
				connector.setOutput(checkDirection(s));
			}

			else if (  s.equalsIgnoreCase("Look")
					|| s.equalsIgnoreCase("L")
					|| temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase("Pickup")
					|| s.equalsIgnoreCase("Inventory")
					|| s.equalsIgnoreCase("I")
					|| temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase("Drop")
					|| s.equalsIgnoreCase("Solve")
					|| temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase("Examine")
					|| s.equalsIgnoreCase("help")
					|| s.equalsIgnoreCase("save")
					|| s.equalsIgnoreCase("Fight")
					|| temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase(("Equip"))
					|| s.equalsIgnoreCase("unequip")
					|| s.equalsIgnoreCase("heal"))
				connector.setOutput(roomCommands(s));
		}

		// Opens the Help.txt after the player types help. This will allow the player to see understand the game and its commands
		if (s.equalsIgnoreCase("help")) {
			try {

				ProcessBuilder help = new ProcessBuilder("Notepad.exe", "Resource/Help.txt");
				help.start();

			}

			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Will drop the player into the Torture Chamber (RM_3) if they "look" inside of Sitting Room (RM_16)
		if (s.equalsIgnoreCase("look") || s.equalsIgnoreCase("l")) {

			if ( ((Player) player).getRoom().equalsIgnoreCase("RM_16")) {
				player.setRoom("RM_3");
			}

		}

		// rList.get(checkCurrentRoom()).setMap("default.jpg"); ======> Unused Code
		connector.setImage(rList.get(checkCurrentRoom()).getMap());			// Updates Map according to Current Room Player is in
		connector.setList(showInventoryD());								// Updates Inventory (Visual)
		connector.setHealth(player.getHealth());							// Updates Player Health (Visual)
		connector.setAttack(player.getAttack());							// Updates Player Attack (Visual)
		connector.setEquipped(((Player) player).getEquipped());				// Updates Player Equipped Item (Visual)

		// If Player health is 0, the game is over and it closes
		if (Integer.parseInt(((Player) player).getHealth()) <= 0) {
			System.exit(0);
		}

		// If Player gets to Room 7 (Outside), the game is over and it closes
		if (((Player) player).getRoom().equalsIgnoreCase("RM_7")) {
			System.exit(0);
		}

		setChanged();
		notifyObservers(connector);
		connector.clearList();
	}

	//Sets stuff
	public void startup() {
		connector.setDescription("Room Name: " + rList.get(checkCurrentRoom()).getName() + "\nRoom Description: "
				+ rList.get(checkCurrentRoom()).getDescription());
		connector.setOutput("");
		connector.setList(showInventoryD());
		connector.setImage(rList.get(checkCurrentRoom()).getMap());
		connector.setHealth(player.getHealth());
		connector.setAttack(player.getAttack());
		connector.setEquipped(((Player) player).getEquipped());
		setChanged();
		notifyObservers(connector);
	}

	// Check Direction according to input
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
						output = "Room Unlocked\n" + rList.get(temp).getName();
					} else {
						output = "Key Required";
					}
				} else {
					player.setRoom(rList.get(temp).getNorthID());
					temp = checkCurrentRoom();
					output = rList.get(temp).getName();
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
						output = "Room Unlocked\n" + rList.get(temp).getName();
					} else {
						output = "Key Required";
					}
				} else {
					player.setRoom(rList.get(temp).getEastID());
					temp = checkCurrentRoom();
					output = rList.get(temp).getName();
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
						output = "Room Unlocked\n" + rList.get(temp).getName();
					} else {
						output = "Key Required";
					}
				} else {
					player.setRoom(rList.get(temp).getSouthID());
					temp = checkCurrentRoom();
					output = rList.get(temp).getName();
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
						output = "Room Unlocked\n" + rList.get(temp).getName();
					} else {
						output = "Key Required";
					}
				} else {
					player.setRoom(rList.get(temp).getWestID());
					temp = checkCurrentRoom();
					output = rList.get(temp).getName();
				}
			}
		}
		return output;
	}


	// Commands the player is able to do (for rooms)
	public String roomCommands(String s) {
		String temp = " ";
		if (s.contains(" ")) {
			temp = s;
		}
		String output = "";

		// Allows the player to see the Item, puzzle, or monster in the room they are currently in
		if (s.equalsIgnoreCase("Look") || s.equalsIgnoreCase("L")) {

			connector.setDescription("Room Name: " + rList.get(checkCurrentRoom()).getName() + "\nRoom Description: "
					+ rList.get(checkCurrentRoom()).getDescription());
			output = "\nItem List: " + itemList() + "\nPuzzle Name: " + checkRoomPuzzle() + "\nMonster(s): "
					+ checkRoomMonster();
		}

		// "Pickup" command; Allows the player to pick up the item in the current room they are in
		else if (temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase(("Pickup"))) {

			// If the item does not exist
			if (convertIName(temp.substring(temp.indexOf(" ") + 1)).equalsIgnoreCase("false")) {
				output = "Item does not exist";
			}

			// If there is an item in the room
			if (rList.get(checkCurrentRoom()).pickupItem(convertIName(temp.substring(temp.indexOf(" ") + 1)))) {
				player.addInventory(convertIName(temp.substring(temp.indexOf(" ") + 1)));
				output = "Item added to inventory";
			}

			// If there is no item in the room
			else
				output = "Item not in room";
		}


		// "Drop" command; Allows the player to drop the item in the current room they are in
		else if (temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase(("Drop"))) {

			// If the item does not exist
			if (convertIName(temp.substring(temp.indexOf(" ") + 1)).equalsIgnoreCase("false")) {
				output = "Item does not exist";
			}

			// If there is an item in the player's inventory
			if (player.inventoryCheck(convertIName(temp.substring(temp.indexOf(" ") + 1)))) {
				player.dropInventory(convertIName(temp.substring(temp.indexOf(" ") + 1)));
				rList.get(checkCurrentRoom()).addInventory(convertIName(temp.substring(temp.indexOf(" ") + 1)));
				output = "Item dropped into room";
			}

			// If there is no item in the inventory
			else
				output = "Item not in inventory";
		}


		// "Inventory" command; Allows the player to check their inventory
		else if (s.equalsIgnoreCase("Inventory") || s.equalsIgnoreCase("I")) {
			output = "Inventory: " + showInventory();
		}


		// "Solve" command; allows the player to enter the puzzle state if a puzzle exists in the current room they are in
		else if (s.equalsIgnoreCase("Solve")) {

			// Informs the player they have entered the puzzle state
			if (!rList.get(checkCurrentRoom()).getPuzzleID().equalsIgnoreCase("0")) {
				((Player) player).setPlayerState("2");
				output = "You are now puzzling";
			}

			// Informs the player there is no puzzle in the room they are currently in
			else {
				output = "No puzzle in the room";
			}

		}


		// "Fight" command; allows the player to enter the battle state if a monster exists in the current room they are in
		else if (s.equalsIgnoreCase("Fight")) {

			// Informs the player they have entered the battle state
			if (!rList.get(checkCurrentRoom()).getMonsterID().equalsIgnoreCase("0")) {
				((Player) player).setPlayerState("3");
				output = "You are now in battle";
				// r.list.get(checkCurrentRoom()).getMonsterID())  ===> Unused command
			}

			// Informs the player there is no monster in the room they are currently in
			else {
				output = "There is no monster in this room";
			}

		}


		// "Examine" command; allows the player to see the description of an item
		else if ( temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase(("Examine")) ) {

			// informs the player they cannot examine the
			if (convertIName(temp.substring(temp.indexOf(" ") + 1)).equalsIgnoreCase("false")) {
				output = "You cannot examine that item";
			}

			// showcases the description of the item if it is in the current room
			else if (rList.get(checkCurrentRoom()).checkInventory(convertIName(temp.substring(temp.indexOf(" ") + 1)))) {
				output = "Description: " + itemDesc(convertIName(temp.substring(temp.indexOf(" ") + 1)));
			}

			// showcases the description of the item if it is in the player's inventory
			else if (player.inventoryCheck(convertIName(temp.substring(temp.indexOf(" ") + 1)))) {
				output = "Description: " + showInventoryDesc(convertIName(temp.substring(temp.indexOf(" ") + 1)));
			}

			// informs the player the item they are trying to examine is not in the room
			else
				output = "Item not in room";
		}


		// Save's the player's current progress in the game
		else if (s.equalsIgnoreCase("save")) {
			String item = player.getInventory().toString();
			try {

				String playerSave = "INSERT INTO Player (saveID, health, attack, playerState, equipped, room_id, items) VALUES (?,?,?,?,?,?,?)";
				Connection con = DriverManager.getConnection(url);
				PreparedStatement PreparedStatement = con.prepareStatement(playerSave);

				PreparedStatement.setInt(1, 1);
				PreparedStatement.setString(2, getHealth());
				PreparedStatement.setString(3, getAttack());
				PreparedStatement.setString(4, getPlayerState());
				PreparedStatement.setString(5, ((Player) player).getEquipped());
				PreparedStatement.setString(6, getRoomID());
				PreparedStatement.setString(7, item);

				int row = PreparedStatement.executeUpdate();
				if (row > 0) {
					System.out.println("A row has been inserted successfully");
				}

			}
			catch (SQLException e) {
				e.printStackTrace();
			}

			output = "Game successfully Saved";
		}


		// "Equip" command; allows the player to equip an item from their inventory
		else if (temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase(("Equip"))) {

			// If the player has the item they are trying to equip...
			if (player.getInventory().contains(getItemID(temp.substring(temp.indexOf(" ") + 1)))) {

				// Equips item to player
				if (((Player) player).getEquipped().equalsIgnoreCase("None")) {
					((Player) player).setEquipped(getItemID(temp.substring(temp.indexOf(" ") + 1)),
							iList.get(getItem(temp.substring(temp.indexOf(" ") + 1))).getItemBoost(),
							temp.substring(temp.indexOf(" ") + 1));
					output = "Item equipped";
				}

				// Player already has the item equipped
				else {
					output = "Weapon already equipped";
				}
			}

			// Player is unable to equip item
			else {
				output = "Unable to equip item";
			}
		}


		// "UnEquip" command; allows the player to un-equip an item
		else if (s.equalsIgnoreCase(("unequip"))) {

			// Un-equips item from player
			if (!((Player) player).getEquipped().equalsIgnoreCase("None")) {
				((Player) player).setUnequip(iList.get(getItem(temp.substring(temp.indexOf(" ") + 1))).getItemBoost(),
						getItemID(((Player) player).getEquipped()));
				output = "Item Unequipped";
			}

			// Player cannot un-equip item
			else
				output = "Cannot unequip";
		}


		// "heal" command; allows the player to heal themselves using an item
		else if (s.equalsIgnoreCase("heal")) {

			// if the player has an item that can heal, it will increase player health
			if (player.getInventory().contains(iList.get(0).getId())) {
				player.dropInventory(iList.get(0).getId());
				player.addHealth(iList.get(0).getItemBenefit());
				output = "You healed yourself!";
			}

			// Player cannot heal
			else {
				output = "Cannot heal";
			}

		}

		return output;
	}


	// Commands the player is able to do (for puzzles)
	public String puzzleCommands(String s) {
		String output = "";
		Puzzle p = getCurrentPuzzle();

		// "give up" command; allows the player to stop doing the puzzle and receive the reward
		if (s.equalsIgnoreCase("give up")) {
			((Player) player).setPlayerState("1");
			((Player) player).addInventory(p.getReward());
			rList.get(checkCurrentRoom()).setPuzzleID("0");
			output = "Puzzle Skipped";
		}

		// "leave" command; allows the player to stop doing the puzzle
		else if (s.equalsIgnoreCase("leave")) {
			((Player) player).setPlayerState("1");
			output = "Left Puzzle";
		}

		// If player answers the puzzle...
		else if (s.equalsIgnoreCase(p.getSolution())) {
			//with required item(s)
			if ((((Player) player).getInventory().contains(p.getItemRequired_1())
					|| (p.getItemRequired_1().equalsIgnoreCase("0"))
						&& (((Player) player).getInventory().contains(p.getItemRequired_2())
						|| (p.getItemRequired_2().equalsIgnoreCase("0"))
							&& (((Player) player).getInventory().contains(p.getItemRequired_3())
							|| (p.getItemRequired_3().equalsIgnoreCase("0"))
								&& (((Player) player).getInventory().contains(p.getItemRequired_4())
								|| (p.getItemRequired_4().equalsIgnoreCase("0"))))))) {

				((Player) player).setPlayerState("1");
				((Player) player).addInventory(p.getReward());
				rList.get(checkCurrentRoom()).setPuzzleID("0");
				output = p.getCompletion();

			}

			//without required item(s)
			else {
				output = "Missing required item";
			}
		}

		// "Observe" command; Allows the player to view puzzle description
		else if (s.equalsIgnoreCase("observe")) {
			output = p.getDescription();
		}

		// "hint" command; Allows the player to view puzzle hint(s)
		else if (s.equalsIgnoreCase("hint")) {

			// If there are no hints available
			if (p.getHint1().equalsIgnoreCase("0")) {
				output = "No Hints GL ;-)";
			}

			// Hint 1
			else {
				output = "\nHint 1: " + p.getHint1();
			}

			// Hint 2
			if (!p.getHint2().equalsIgnoreCase("0")) {
				output += "\nHint 2: " + p.getHint2();
			}

			// Hint 3
			if (!p.getHint3().equalsIgnoreCase("0")) {
				output += "\nHint 3: " + p.getHint3();
			}

			// Hint 4
			if (!p.getHint4().equalsIgnoreCase("0")) {
				output += "\nHint 4: " + p.getHint4();
			}

		}

		return output;
	}


	// Commands the player is able to do (for battles)
	public String monsterCommands(String s) {
		String output = "";
		String temp = " ";

		if (s.contains(" ")) {
			temp = s;
		}

		// "pull out" command; allows the player to stop doing the battle and receive the reward
		Monster m = getCurrentMonster();
		if (s.equalsIgnoreCase("pull out")) {
			((Player) player).setPlayerState("1");
			((Player) player).addInventory(m.getItemReward());
			rList.get(checkCurrentRoom()).setMonsterID("0");
			output = "Battle Skipped";
		}

		// "retreat" command; allows the player to stop doing the battle
		else if (s.equalsIgnoreCase("retreat")) {
			((Player) player).setPlayerState("1");
			output = "Left Battle";
		}

		// "inspect" command; allows the player view the monster's name, description, health, and attack power
		else if (s.equalsIgnoreCase("inspect")) {

			// Displays monster's name, description, health, and attack power
			if (!rList.get(checkCurrentRoom()).getMonsterID().equalsIgnoreCase("0")) {
				output = "Monster Name: " + m.getName() + "\nMonster Description: " + m.getDescription()
						+ "\nMonster Health: " + m.getHealth() + "\nAttack Power: " + m.getAttack();
			}

		}

		// "attack" command; allows the player to attack the monster
		else if (s.equalsIgnoreCase("attack")) {
			if (Integer.parseInt(((Monster) m).getHealth()) > 0) {

				// Displays Monster health and player health after calculations are done for monster and player health for all monsters except "MN6_VP" (Vampire)
				if (!((Monster) m).getID().equalsIgnoreCase("MN6_VP")) {

					m.MonsterGetsAttacked(((Player) player).getAttack());
					((Player) player).PlayerGetsAttacked(m.getAttack());
					output = "Monster health: " + m.getHealth() + "\nPlayer Health: " + ((Player) player).getHealth();

				}

				// Informs the player the monster is immune to attacks
				else {
					output = "Immune to attacks";
				}
			}

			// Informs the player the monster is defeated and rewards the player with an item
			else {
				m.setID("0");
				output = m.getMonsterDefeatedMessage() + "\nItems Rewarded: " + m.getItemReward();
				//monsterDrop();
				((Player) player).addInventory(m.getItemReward());
				((Player) player).addInventory("AR_HP");
				((Player) player).setPlayerState("1");
			}

		}

		// "use" command; allows the player to use an item
		else if (temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase("use")) {

			if (((Player) player).getInventory().contains(temp.substring(temp.indexOf(" ") + 1))) {

				// Player will defeat MN6_VP (Vampire) instantly if they have the required item
				if (((Monster) m).getID().equalsIgnoreCase("MN6_VP")
						&& (temp.substring(temp.indexOf(" ") + 1).equalsIgnoreCase("garlic")
								|| temp.substring(temp.indexOf(" ") + 1).equalsIgnoreCase("stake"))) {
					((Player) player).getInventory().remove(getItemID(temp.substring(temp.indexOf(" ") + 1)));
					m.setID("0");
					output = m.getMonsterDefeatedMessage() + "\nItems Rewarded: " + m.getItemReward();
					//monsterDrop();
					((Player) player).addInventory(m.getItemReward());
					((Player) player).addInventory("AR_HP");
					((Player) player).setPlayerState("1");
				}

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

	public String getItemID(String name) {
		for (int x = 0; x < iList.size(); x++) {
			if (iList.get(x).getItemName().equalsIgnoreCase(name)) {
				return iList.get(x).getId();
			}
		}
		return "false";
	}

	public int getItem(String name) {
		for (int x = 0; x < iList.size(); x++) {
			if (iList.get(x).getItemName().equalsIgnoreCase(name)) {
				return x;
			}
		}
		return 0;
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
		if (item.equalsIgnoreCase(""))
			item = "None";
		return item;
	}

	public String convertIName(String name) {
		for (int x = 0; x < iList.size(); x++) {
			if (iList.get(x).getItemName().equalsIgnoreCase(name))
				return iList.get(x).getId();
		}
		return "False";
	}

	public String convertMName(String name) {
		for (int x = 0; x < mList.size(); x++) {
			if (mList.get(x).getName().equalsIgnoreCase(rList.get(checkCurrentRoom()).getMonsterID())) {
				return mList.get(x).getName();
			}
		}
		return "None";
	}

	public String showInventory() {
		ArrayList<String> temp = ((Player) player).showInventory();
		String output = "";
		for (int x = 0; x < iList.size(); x++) {
			for (int y = 0; y < temp.size(); y++) {
				if (iList.get(x).getId().equalsIgnoreCase(temp.get(y)))
					output += "[" + iList.get(x).getItemName() + "]";
			}
		}
		if (output.equalsIgnoreCase(""))
			output = "None";
		return output;
	}

	public ArrayList<String> showInventoryD() {
		ArrayList<String> temp = ((Player) player).showInventory();
		ArrayList<String> temp2 = new ArrayList<String>();
		for (int x = 0; x < iList.size(); x++) {
			for (int y = 0; y < temp.size(); y++) {
				if (iList.get(x).getId().equalsIgnoreCase(temp.get(y)))
					temp2.add(iList.get(x).getItemName());
			}
		}
		return temp2;
	}

	public String checkRoomPuzzle() {
		if (!rList.get(checkCurrentRoom()).getPuzzleID().equalsIgnoreCase("0")) {
			for (int x = 0; x < pList.size(); x++) {
				if (pList.get(x).getId().equalsIgnoreCase(rList.get(checkCurrentRoom()).getPuzzleID())) {
					return pList.get(x).getName();
				}
			}
		}
		return "None";
	}

	public String checkRoomMonster() {
		if (!rList.get(checkCurrentRoom()).getMonsterID().equalsIgnoreCase("0")) {
			for (int x = 0; x < mList.size(); x++) {
				if (mList.get(x).getID().equalsIgnoreCase(rList.get(checkCurrentRoom()).getMonsterID())) {
					return mList.get(x).getName();
				}
			}
		}
		return "None";
	}

	public void monsterDrop() {
        for (int i = 0; i < mList.size(); i++) {
            if (mList.get(i).getRoom().equalsIgnoreCase(rList.get(checkCurrentRoom()).getId())) {
                for (int j = 0; j < iList.size(); j++) {
                    if (mList.get(i).getItemReward().equalsIgnoreCase(iList.get(j).getId())) {
                        player.addInventory(iList.get(j).getId());
                    }
                    if (iList.get(j).getId().equalsIgnoreCase("AR_HP")) {
                        player.addInventory(iList.get(j).getId());
                    }
                }
            }
        }
    }

	public String itemDesc(String id) {
		String item = "";
		for (int x = 0; x < iList.size(); x++) {
			if (rList.get(checkCurrentRoom()).checkInventory(iList.get(x).getId())) {
				if (iList.get(x).getId().equalsIgnoreCase(id)) {
					item += "[" + iList.get(x).getDescription() + "] ";
				}
			}
		}
		return item;
	}

	public String getHealth() {
		return ((Player) player).getHealth();
	}

	public String getAttack() {
		return ((Player) player).getAttack();
	}

	public String getPlayerState() {
		return ((Player) player).getPlayerState();
	}

	public String getRoomID() {
		return ((Player) player).getRoom();
	}

	public String getEquipped() {
		return ((Player) player).getEquipped();
	}

	public ArrayList<String> getInventory() {
		return ((Player) player).getInventory();
	}

	int counter = 0;

	public String AutoNumber() {
		int tmp = counter;
		counter++;
		return Integer.toString(tmp);
	}

	public String showInventoryDesc(String id) {
		ArrayList<String> temp = ((Player) player).showInventory();
		String output = "";
		for (int x = 0; x < iList.size(); x++) {
			for (int y = 0; y < temp.size(); y++) {
				if (iList.get(x).getId().equalsIgnoreCase(temp.get(y))) {
					if (temp.get(y).equalsIgnoreCase(id)) {
						output += iList.get(x).getDescription();
					}
				}
			}
		}
		return output;
	}

	public Puzzle getCurrentPuzzle() {
		for (int x = 0; x < pList.size(); x++) {
			if (pList.get(x).getName().equalsIgnoreCase(checkRoomPuzzle())) {
				return pList.get(x);
			}
		}
		return null;
	}

	public Monster getCurrentMonster() {
		for (int x = 0; x < mList.size(); x++) {
			if (mList.get(x).getName().equalsIgnoreCase(checkRoomMonster())) {
				return mList.get(x);
			}
		}
		return null;
	}
}