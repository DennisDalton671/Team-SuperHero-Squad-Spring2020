package Model;

import java.util.ArrayList;

/* Stores all of the information about the player */

public class Player extends Entity {

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
			if (key.equalsIgnoreCase(super.getInventory().get(x)))
				return true;
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
		if (super.getInventory().size() == 0)
			temp.add("Empty");
		for (int x = 0; x < super.getInventory().size(); x++) {
			temp.add(super.getInventory().get(x));
		}
		return temp;
	}

	public String getEquipped() {
		return equipped;
	}

	public void setEquipped(String equipped, String attack, String name) {
		String temp2 = name.substring(0, 1).toUpperCase() + name.substring(1);
		this.equipped = temp2;
		int temp = Integer.parseInt(super.getAttack());
		temp += Integer.parseInt(attack);
		super.setAttack(Integer.toString(temp));
		super.getInventory().remove(equipped);
<<<<<<< HEAD
	}

	public void setEquipped1(String equipped) {
		this.equipped = equipped;
=======
>>>>>>> 9000c3e9637ea0629556b0ae229f077350f81a1c
	}

	public void setUnequip(String attack, String id) {
		super.addInventory(id);
		equipped = "None";
		int temp = Integer.parseInt(super.getAttack());
		temp -= Integer.parseInt(attack);
		super.setAttack(Integer.toString(temp));
	}
<<<<<<< HEAD

=======
	
>>>>>>> 9000c3e9637ea0629556b0ae229f077350f81a1c
	public String getPlayerState() {
		return playerState;
	}

	public void setPlayerState(String playerState) {
		this.playerState = playerState;
	}

	public void PlayerGetsAttacked(String i) {
		super.setHealth(Integer.toString(Integer.parseInt(super.getHealth()) - Integer.parseInt(i)));
	}
<<<<<<< HEAD

=======
	
>>>>>>> 9000c3e9637ea0629556b0ae229f077350f81a1c
}
