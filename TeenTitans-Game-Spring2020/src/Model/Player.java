package Model;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Player extends Entity{

	private String equipped;
	private String playerState;
	private String healthPoint;
	private String attackPoint;
	private Item item;
	private String equip;
	
	
	public Player(String ID, String health, String attack, String room, String equipped, String playerState) {
		super(ID, health, attack, room);
		this.attackPoint = attack;
		this.healthPoint = health;
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
	
	/**
	 * @return the healthPoint
	 */
	public String getHealthPoint() {
		return healthPoint;
	}

	/**
	 * @param healthPoint the healthPoint to set
	 */
	public void setHealthPoint(String healthPoint) {
		this.healthPoint = healthPoint;
	}

	/**
	 * @return the attackPoint
	 */
	public String getAttackPoint() {
		return attackPoint;
	}

	/**
	 * @param attackPoint the attackPoint to set
	 */
	public void setAttackPoint(String attackPoint) {
		this.attackPoint = attackPoint;
	}

	public void PlayerGetsAttacked(String i) {
		healthPoint = Integer.toString(Integer.parseInt(healthPoint) - Integer.parseInt(i));
	}
	
	public String HitsMonster() {
		return attackPoint;
	}
	
}
