package Model;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Player extends Entity{

	private String equipped;
	private String playerState;
	
	public Player(String ID, String health, String attack, String room, String equipped, String playerState) {
		super(ID, health, attack, room);
		this.equipped = equipped;
		this.playerState = playerState;
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
	
	public void removeItem(String id) {
		super.dropInventory(id);
	}
		
	public ArrayList<String> showInventory() {
		ArrayList<String> temp = new ArrayList<String>();
		if (super.getInventory().size() == 0) temp.add("Empty");
		for (int x = 0; x < super.getInventory().size(); x++) {
			temp.add(super.getInventory().get(x));
		}
		return temp;
	}

	public String getEquipped() {
		return equipped;
	}

	public void setEquipped(String equipped) {
		this.equipped = equipped;
	}

	public String getPlayerState() {
		return playerState;
	}

	public void setPlayerState(String playerState) {
		this.playerState = playerState;
	}
	
}
