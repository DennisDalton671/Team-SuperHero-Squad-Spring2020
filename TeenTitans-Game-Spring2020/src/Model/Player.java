package Model;

import java.util.ArrayList;

public class Player extends Entity{

	private String equipped;
	
	public Player(String ID, String health, String attack, String room, String equipped) {
		super(ID, health, attack, room);
		// TODO Auto-generated constructor stub
	}

	public boolean checkKey(String key) {
		for (int x = 0; x < super.getInventory().size(); x++) {
			if (key.equalsIgnoreCase(super.getInventory().get(x))) return true;
		}
		return false;
	}
	
	public void addItem(String id) {
		super.addInventory(id);
	}
	
	public ArrayList<String> showInventory() {
		ArrayList<String> temp = new ArrayList<String>();
		if (super.getInventory().size() == 0) temp.add("Empty");
		for (int x = 0; x < super.getInventory().size(); x++) {
			temp.add(super.getInventory().get(x));
		}
		return temp;
	}
	
}
