package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Base class for the monster and player to share */

public class Entity {

	private String ID;
	private String health;
	private String attack;
	private String room;
	private ArrayList<String> inventory;

	public Entity(String ID, String health, String attack, String room) {
		this.ID = ID;
		this.health = health;
		this.attack = attack;
		this.room = room;
		this.inventory = new ArrayList<String>();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getAttack() {
		return attack;
	}

	public void setAttack(String attack) {
		this.attack = attack;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public void addInventory(String ID) {
		inventory.add(ID);
	}

	public void dropInventory(String ID) {
		inventory.remove(ID);
	}

	public boolean inventoryCheck(String ID) {
		return inventory.contains(ID);
	}

	public ArrayList<String> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<String> s) {
		inventory = s;
	}

	public void addHealth(String s) {
		int temp = Integer.parseInt(health);
		temp = Integer.parseInt(health) + Integer.parseInt(s);
		health = Integer.toString(temp);
	}

	public void setInventory(String s) {
		List<String> inventoryL = Arrays.asList(s.substring(1, s.length() - 1).split(", "));
		this.inventory = new ArrayList<String>(inventoryL);
	}
}
