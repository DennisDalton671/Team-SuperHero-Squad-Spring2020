package Model;

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

/* The main class of the model and controls all the user inputs and how to deal with them */

public class InputC extends java.util.Observable {

	String url;
	Connector connector;

	Entity player;
	Entity monster;
	Room room;
	boolean keyCheck;
	ArrayList<Room> rList;
	ArrayList<Item> iList;
	ArrayList<Puzzle> pList;
	ArrayList<Monster> mList;
	ArrayList<Player> plList;

	/*
	 * In the constructor we get all the data from the database and store it into
	 * array list so the model can access the data whenever it needs it and also
	 * creates the connector object to send to the view model.
	 */

	public InputC() {

		keyCheck = true;

		url = "jdbc:ucanaccess://Resource/SoftDevPro_Final_One_For_Real_JK.accdb";
		rList = new ArrayList<Room>();
		iList = new ArrayList<Item>();
		pList = new ArrayList<Puzzle>();
		mList = new ArrayList<Monster>();
		connector = new Connector();

		// player.addInventory("AR_KEY5");

		// Rooms ################

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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

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

	/*
	 * The load player method loads the information from the database to retrieve
	 * the data from a previous save for the player
	 */

	public void loadPlayer(Object save) {

		if (!((SaveFile) save).getId().equalsIgnoreCase("1")) {
			try {
				Connection con = DriverManager.getConnection(url);
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(
						"SELECT RoomID, Inventory, Monster, Puzzle FROM roomsave" + ((SaveFile) save).getId());
				while (rs.next()) {
					for (int x = 0; x < rList.size(); x++) {
						if (rList.get(x).getId().equalsIgnoreCase(rs.getString(1))) {
							rList.get(x).setInventory(rs.getString(2));
							rList.get(x).setMonsterID(rs.getString(3));
							rList.get(x).setPuzzleID(rs.getString(4));
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				Connection con = DriverManager.getConnection(url);
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(
						"SELECT saveID, health, attack, playerState, equipped, room_id, items FROM Player WHERE saveid = '"
								+ ((SaveFile) save).getId() + "'");
				while (rs.next()) {

					player.setHealth(rs.getString(2));
					player.setAttack(rs.getString(3));
					((Player) player).setPlayerState(rs.getString(4));
					((Player) player).setEquipped1(rs.getString(5));
					player.setRoom(rs.getString(6));
					((Player) player).setInventory(rs.getString(7));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * This method checks the current user input and decides which course of action
	 * it should take based on the players current state and the input the player
	 * inputed. This method also checks to see if the player won or lost and stores
	 * the information.
	 */

	public void checkUserInput(String s) {
		String temp = " ";
		if (s.contains(" ")) {
			temp = s;
		}

		if (s.equalsIgnoreCase("craft")) {
			if (player.getInventory().contains("AR_WP2") && player.getInventory().contains("AR_WP4")) {
				player.addInventory("AR_VP1");
				player.dropInventory("AR_WP4");
				player.dropInventory("AR_WP2");
				connector.setOutput("You've got the power, the Stake it is now in your inventory");
			} else {
				connector.setOutput("You do not have the materials to craft anything");
			}
		}

		if (player.getInventory().contains("AR_KEY5") && keyCheck) {
			rList.get(checkCurrentRoom()).setMonsterID("0");
			rList.get(checkCurrentRoom()).setPuzzleID("0");
			keyCheck = false;
		}

		if (((Player) player).getPlayerState().equalsIgnoreCase("2")) {

			if (s.equalsIgnoreCase("Give up") || s.equalsIgnoreCase("leave")
					|| s.equalsIgnoreCase(getCurrentPuzzle().getSolution()) || s.equalsIgnoreCase("observe")
					|| s.equalsIgnoreCase("hint")) {
				connector.setOutput(puzzleCommands(s));
			} else {
				connector.setOutput("No none puzzling inputs while puzzling");
			}

		}
		if (((Player) player).getPlayerState().equalsIgnoreCase("3")) {

			if (s.equalsIgnoreCase("pull out") || s.equalsIgnoreCase("retreat") || s.equalsIgnoreCase("inspect")
					|| s.equalsIgnoreCase("attack") || temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase("use")
					|| s.equalsIgnoreCase("a")) {
				connector.setOutput(monsterCommands(s));
			} else {
				connector.setOutput("No none battling inputs while battling");
			}
		} else if (((Player) player).getPlayerState().equalsIgnoreCase("1")) {
			if (s.equalsIgnoreCase("North") || s.equalsIgnoreCase("East") || s.equalsIgnoreCase("South")
					|| s.equalsIgnoreCase("West"))
				connector.setOutput(checkDirection(s));
			else if (s.equalsIgnoreCase("Look") || s.equalsIgnoreCase("L")
					|| temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase("Pickup")
					|| s.equalsIgnoreCase("Inventory") || s.equalsIgnoreCase("I")
					|| temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase("Drop") || s.equalsIgnoreCase("Solve")
					|| temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase("Examine") || s.equalsIgnoreCase("help")
					|| s.equalsIgnoreCase("save") || s.equalsIgnoreCase("Fight")
					|| temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase(("Equip")) || s.equalsIgnoreCase("unequip")
					|| s.equalsIgnoreCase("heal"))
				connector.setOutput(roomCommands(s));
		}

		if (s.equalsIgnoreCase("help")) {
			try {

				ProcessBuilder help = new ProcessBuilder("Notepad.exe", "Resource/Help.txt");
				help.start();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (s.equalsIgnoreCase("look") || s.equalsIgnoreCase("l")) {
			if (((Player) player).getRoom().equalsIgnoreCase("RM_16")) {
				player.setRoom("RM_3");
			}
		}
		if (s.equalsIgnoreCase("reset")) {
			connector.setRestart(true);
		}

		if (s.equalsIgnoreCase("quit")) {
			System.exit(0);
			;
		}

		if (s.equalsIgnoreCase("up up down down left right left right b a")) {
			player.setHealth("666");
			player.setAttack("999");
			connector.setOutput("Konami Code Accepted");
		}

		// rList.get(checkCurrentRoom()).setMap("default.jpg");
		connector.setImage(rList.get(checkCurrentRoom()).getMap());
		connector.setList(showInventoryD());
		connector.setHealth(player.getHealth());
		connector.setAttack(player.getAttack());
		connector.setEquipped(((Player) player).getEquipped());

		if (Integer.parseInt(((Player) player).getHealth()) <= 0) {
			connector.setLose(true);
		}

		if (((Player) player).getRoom().equalsIgnoreCase("RM_7")) {
			connector.setWin(true);
		}

		setChanged();
		notifyObservers(connector);
		connector.clearList();
	}

	/*
	 * The initial startup of the program and gets all the initial information to
	 * send to the view initial. Also called if the user wants to restart the game.
	 * Very seldom used but very important for the initial startup of the game.
	 */

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

	/*
	 * Checks the input for the direction that was inputed and moves the player to
	 * the direction they inputed, otherwise the game will notify the user that
	 * there is no room in that direction.
	 */

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
			if (player.getRoom().equalsIgnoreCase("RM_28")
					&& !rList.get(checkCurrentRoom()).getPuzzleID().equalsIgnoreCase(("0"))) {
				output = "Puzzle Required to enter Observatory.";
				return output;
			}
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

	/*
	 * If the user is in the navigation state the game will direct the users input
	 * here and decide what to do with given input, It has multiple functions from
	 * starting a fight to equipping items and so on.
	 */

	public String roomCommands(String s) {
		String temp = " ";
		if (s.contains(" ")) {
			temp = s;
		}
		String output = "";

		if (s.equalsIgnoreCase("Look") || s.equalsIgnoreCase("L")) {
			connector.setDescription("Room Name: " + rList.get(checkCurrentRoom()).getName() + "\nRoom Description: "
					+ rList.get(checkCurrentRoom()).getDescription());
			output = "\nItem List: " + itemList() + "\nPuzzle Name: " + checkRoomPuzzle() + "\nMonster(s): "
					+ checkRoomMonster();
		} else if (temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase(("Pickup"))) {
			if (getItemID(temp.substring(temp.indexOf(" ") + 1)).equalsIgnoreCase("false")) {
				output = "Item does not exist";
			}
			if (rList.get(checkCurrentRoom()).pickupItem(getItemID(temp.substring(temp.indexOf(" ") + 1)))) {
				player.addInventory(getItemID(temp.substring(temp.indexOf(" ") + 1)));
				output = "Item added to inventory";
			} else
				output = "Item not in room";
		} else if (temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase(("Drop"))) {
			if (getItemID(temp.substring(temp.indexOf(" ") + 1)).equalsIgnoreCase("false")) {
				output = "Item does not exist";
			}
			if (player.inventoryCheck(getItemID(temp.substring(temp.indexOf(" ") + 1)))) {
				player.dropInventory(getItemID(temp.substring(temp.indexOf(" ") + 1)));
				rList.get(checkCurrentRoom()).addInventory(getItemID(temp.substring(temp.indexOf(" ") + 1)));
				output = "Item dropped into room";
			} else
				output = "Item not in inventory";

		} else if (s.equalsIgnoreCase("Inventory") || s.equalsIgnoreCase("I")) {
			output = "Inventory: " + showInventory();
		} else if (s.equalsIgnoreCase("Solve")) {
			if (!rList.get(checkCurrentRoom()).getPuzzleID().equalsIgnoreCase("0")) {
				((Player) player).setPlayerState("2");
				output = "You are now puzzling";
			} else {
				output = "No puzzle in the room";
			}
		} else if (s.equalsIgnoreCase("Fight")) {
			if (!rList.get(checkCurrentRoom()).getMonsterID().equalsIgnoreCase("0")) {
				((Player) player).setPlayerState("3");
				output = "You are now in battle";
				// r.list.get(checkCurrentRoom()).getMonsterID())
			} else {
				output = "There is no monster in this room";
			}

		} else if (temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase(("Examine"))) {
			if (getItemID(temp.substring(temp.indexOf(" ") + 1)).equalsIgnoreCase("false")) {
				output = "You cannot examine that item";
			} else if (rList.get(checkCurrentRoom()).checkInventory(getItemID(temp.substring(temp.indexOf(" ") + 1)))) {
				output = "Description: " + itemDesc(getItemID(temp.substring(temp.indexOf(" ") + 1)));
			} else if (player.inventoryCheck(getItemID(temp.substring(temp.indexOf(" ") + 1)))) {
				output = "Description: " + showInventoryDesc(getItemID(temp.substring(temp.indexOf(" ") + 1)));
			} else
				output = "Item not in room";
		} else if (s.equalsIgnoreCase("save")) {
			try {

				String playerSave = "INSERT INTO Player (saveID, health, attack, playerState, equipped, room_id, items) VALUES (?,?,?,?,?,?,?)";
				Connection con = DriverManager.getConnection(url);
				PreparedStatement PreparedStatement = con.prepareStatement(playerSave);

				PreparedStatement.setInt(1, 1);
				PreparedStatement.setString(2, player.getHealth());
				PreparedStatement.setString(3, player.getAttack());
				PreparedStatement.setString(4, ((Player) player).getPlayerState());
				PreparedStatement.setString(5, ((Player) player).getEquipped());
				PreparedStatement.setString(6, player.getRoom());
				PreparedStatement.setString(7, player.getInventory().toString());

				PreparedStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {

				Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT LAST (saveID) FROM Player");

				rs.next();

				String roomSave = rs.getString(1);

				roomSave = roomSave.substring(0, roomSave.indexOf("."));

				String createTable = "CREATE TABLE roomsave" + roomSave
						+ " (RoomID CHAR(255), Inventory VARCHAR(4000), Monster CHAR(255), Puzzle CHAR(255))";

				Statement stmt = con.createStatement();
				stmt.executeUpdate(createTable);

				for (int x = 0; x < rList.size(); x++) {
					String playerSave1 = "INSERT INTO roomsave" + roomSave
							+ " (RoomID, Inventory, Monster, Puzzle) VALUES (?,?,?,?)";

					PreparedStatement PreparedStatement = con.prepareStatement(playerSave1);

					PreparedStatement.setString(1, rList.get(x).getId());
					PreparedStatement.setString(2, rList.get(x).getInventory().toString());
					PreparedStatement.setString(3, rList.get(x).getMonsterID());
					PreparedStatement.setString(4, rList.get(x).getPuzzleID());

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			output = "Game successfully Saved";
		} else if (temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase(("Equip"))) {
			if (player.getInventory().contains(getItemID(temp.substring(temp.indexOf(" ") + 1)))) {
				if (((Player) player).getEquipped().equalsIgnoreCase("None")) {
					((Player) player).setEquipped(getItemID(temp.substring(temp.indexOf(" ") + 1)),
							iList.get(getItem(temp.substring(temp.indexOf(" ") + 1))).getItemBoost(),
							temp.substring(temp.indexOf(" ") + 1));
					output = "Item equipped";
				} else {
					output = "Weapon already equipped";
				}
			} else {
				output = "Unable to equip item";
			}
		} else if (s.equalsIgnoreCase(("unequip"))) {
			if (!((Player) player).getEquipped().equalsIgnoreCase("None")) {
				((Player) player).setUnequip(iList.get(getItem(((Player) player).getEquipped())).getItemBoost(),
						getItemID(((Player) player).getEquipped()));
				output = "Item Unequipped";
			} else
				output = "Cannot unequip";
		} else if (s.equalsIgnoreCase("heal")) {
			if (player.getInventory().contains(iList.get(0).getId())) {
				player.dropInventory(iList.get(0).getId());
				player.addHealth(iList.get(0).getItemBenefit());
				output = "You have been healed";
			} else
				output = "You do not have any health potions to heal";
		}

		return output;
	}

	/*
	 * If the user is in the puzzle state it will send its inputs here and check to
	 * see which commands the user inputed and decided what to do while inside the
	 * puzzle state. Such as a hint or solving the puzzle.
	 */

	public String puzzleCommands(String s) {
		String output = "";
		Puzzle p = getCurrentPuzzle();
		if (s.equalsIgnoreCase("give up")) {
			((Player) player).setPlayerState("1");
			((Player) player).addInventory(p.getReward());
			rList.get(checkCurrentRoom()).setPuzzleID("0");
			output = "Puzzle Skipped";
		} else if (s.equalsIgnoreCase("leave")) {
			((Player) player).setPlayerState("1");
			output = "Left Puzzle";
		} else if (s.equalsIgnoreCase(p.getSolution())) {
			if ((((Player) player).getInventory().contains(p.getItemRequired_1()) || (p.getItemRequired_1()
					.equalsIgnoreCase("0"))
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
			} else {
				output = "Missing required item";
			}
		} else if (s.equalsIgnoreCase("observe")) {
			output = p.getDescription();
		} else if (s.equalsIgnoreCase("hint")) {
			if (p.getHint1().equalsIgnoreCase("0")) {
				output = "No Hints GL ;-)";
			} else {
				output = "\nHint 1: " + p.getHint1();
			}
			if (!p.getHint2().equalsIgnoreCase("0")) {
				output += "\nHint 2: " + p.getHint2();
			}
			if (!p.getHint3().equalsIgnoreCase("0")) {
				output += "\nHint 3: " + p.getHint3();
			}
			if (!p.getHint4().equalsIgnoreCase("0")) {
				output += "\nHint 4: " + p.getHint4();
			}
		}
		return output;
	}

	/*
	 * If the player is in the monster combat state it will direct the user input
	 * here and will check what to do with the user input and how the battle will be
	 * dne with the current monster the player is fighting.
	 */

	public String monsterCommands(String s) {
		String output = "";
		String temp = " ";
		if (s.contains(" ")) {
			temp = s;
		}
		Monster m = getCurrentMonster();
		if (s.equalsIgnoreCase("pull out")) {
			((Player) player).setPlayerState("1");
			((Player) player).addInventory(m.getItemReward());
			rList.get(checkCurrentRoom()).setMonsterID("0");
			output = "Battle Skipped";
		} else if (s.equalsIgnoreCase("retreat")) {
			((Player) player).setPlayerState("1");
			output = "Left Battle";
		} else if (s.equalsIgnoreCase("inspect")) {
			if (!rList.get(checkCurrentRoom()).getMonsterID().equalsIgnoreCase("0")) {
				output = "Monster Name: " + m.getName() + "\nMonster Description: " + m.getDescription()
						+ "\nMonster Health: " + m.getHealth() + "\nAttack Power: " + m.getAttack();
			}
		} else if (s.equalsIgnoreCase("attack") || s.equalsIgnoreCase("a")) {

			m.MonsterGetsAttacked(((Player) player).getAttack());
			((Player) player).PlayerGetsAttacked(m.getAttack());
			if (Integer.parseInt(((Monster) m).getHealth()) > 0) {
				if (!((Monster) m).getID().equalsIgnoreCase("MN6_VP")) {
					output = "Monster health: " + m.getHealth() + "\nPlayer Health: " + ((Player) player).getHealth();

				} else {
					output = "Immune to attacks";
				}
			} else {
				m.setID("0");
				output = m.getMonsterDefeatedMessage() + "\nItems Rewarded: " + getItemName(m.getItemReward());
				// monsterDrop();
				((Player) player).addInventory(m.getItemReward());
				((Player) player).addInventory("AR_HP");
				((Player) player).setPlayerState("1");
			}

		} else if (temp.substring(0, temp.indexOf(" ")).equalsIgnoreCase("use")) {
			if (((Player) player).getInventory().contains(getItemID(temp.substring(temp.indexOf(" ") + 1)))) {
				if (((Monster) m).getID().equalsIgnoreCase("MN6_VP")
						&& (temp.substring(temp.indexOf(" ") + 1).equalsIgnoreCase("garlic")
								|| temp.substring(temp.indexOf(" ") + 1).equalsIgnoreCase("stake"))) {
					((Player) player).getInventory().remove(getItemID(temp.substring(temp.indexOf(" ") + 1)));
					m.setID("0");
					output = m.getMonsterDefeatedMessage() + "\nItems Rewarded: " + getItemName(m.getItemReward());
					// monsterDrop();
					((Player) player).addInventory(m.getItemReward());
					((Player) player).addInventory("AR_HP");
					((Player) player).setPlayerState("1");
				}
			}
		}
		return output;
	}

	/*
	 * The check room to the directional room methods will return the location the
	 * next room is in the array list give it to the program to work with.
	 */

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

	/*
	 * The getItemId will convert the given item name into an id for the program to
	 * use, the get item will find the item in the array list and return the
	 * location of the item in the array list. The item list will return the item
	 * list in the current room in string format.
	 */

	public String getItemID(String name) {
		for (int x = 0; x < iList.size(); x++) {
			if (iList.get(x).getItemName().equalsIgnoreCase(name)) {
				return iList.get(x).getId();
			}
		}
		return "false";
	}

	public String getItemName(String id) {
		for (int x = 0; x < iList.size(); x++) {
			if (iList.get(x).getId().equalsIgnoreCase(id)) {
				return iList.get(x).getItemName();
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

	/* convertMName will take the name of the monster and convert it into its ID */

	public String convertMName(String name) {
		for (int x = 0; x < mList.size(); x++) {
			if (mList.get(x).getName().equalsIgnoreCase(rList.get(checkCurrentRoom()).getMonsterID())) {
				return mList.get(x).getName();
			}
		}
		return "None";
	}

	/* Show inventory will show the players inventory for the user to see */

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

	/*
	 * Gets the inventory of the player and combines it with more information for
	 * the display.
	 */

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

	/*
	 * the check methods checks to see if a monster or a puzzle are in the same room
	 * as the player
	 */

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

	/*
	 * itemDesc retrieves the description of the item with the given id.
	 * showInventoryDesc displays the description of an item in the users inventory
	 */

	public String itemDesc(String id) {
		String item = "";
		for (int x = 0; x < iList.size(); x++) {
			if (rList.get(checkCurrentRoom()).checkInventory(iList.get(x).getId())) {
				if (iList.get(x).getId().equalsIgnoreCase(id)) {
					item += "[" + iList.get(x).getDescription() + "] ";
					if (!iList.get(x).getItemBoost().equalsIgnoreCase("0")) {
						item += " [ + " + iList.get(x).getItemBoost() + " Attack ]";
					} else if (!iList.get(x).getItemBenefit().equalsIgnoreCase("0")) {
						item += "[ + " + iList.get(x).getItemBenefit() + " Health ]";
					}
					item += "";
				}
			}

		}
		return item;
	}

	public String showInventoryDesc(String id) {
		ArrayList<String> temp = ((Player) player).showInventory();
		String output = "";
		for (int x = 0; x < iList.size(); x++) {
			for (int y = 0; y < temp.size(); y++) {
				if (iList.get(x).getId().equalsIgnoreCase(temp.get(y))) {
					if (temp.get(y).equalsIgnoreCase(id)) {
						output += iList.get(x).getDescription();
						if (!iList.get(x).getItemBoost().equalsIgnoreCase("0")) {
							output += "      + " + iList.get(x).getItemBoost() + " Attack ";
						} else if (!iList.get(x).getItemBenefit().equalsIgnoreCase("0")) {
							output += "[ + " + iList.get(x).getItemBenefit() + " Health ]";
						}
						output += "";
					}

				}

			}
		}
		return output;
	}

	/*
	 * getCurrentPuzzle and monster both get the monster in the room with the user
	 * and puzzle in the same room as the user
	 */

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