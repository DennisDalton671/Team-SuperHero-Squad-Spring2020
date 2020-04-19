package Model;

import java.util.ArrayList;

public class Entity {

	private String ID;
	private String health;
	private String attack;
	private String room;
	private ArrayList<String> inventory;
	
	public Entity(String ID, String health, String attack,String room) {
		this.ID= ID;
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
	
	public ArrayList<String> getInventory() {
		return inventory;
	}
}
