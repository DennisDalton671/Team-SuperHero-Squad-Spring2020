package Model;

import java.util.ArrayList;

/* An object to be passed to the view so it can get all the necessary variables it needs in order to display and update*/

public class Connector {

	private String output;
	private String description;
	private String image;
	private String health;
	private String attack;
	private String equipped;
	private boolean isDesc;
	private ArrayList<Inventory> list;
	private boolean lose;
	private boolean win;
	private static boolean restart;

	public Connector() {
		list = new ArrayList<Inventory>();
		lose = false;
		win = false;
		restart = false;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public ArrayList<Inventory> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		for (int x = 0; x < list.size(); x++) {
			this.list.add(new Inventory(list.get(x)));
		}
	}

	public void clearList() {
		list.clear();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		isDesc = true;
	}

	public boolean isDesc() {
		return isDesc;
	}

	public void setDesc(boolean isDesc) {
		this.isDesc = isDesc;
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

	public String getEquipped() {
		return equipped;
	}

	public void setEquipped(String equipped) {
<<<<<<< HEAD
		if (equipped.equalsIgnoreCase("0") || equipped.equalsIgnoreCase(""))
			this.equipped = "None";
		else
			this.equipped = equipped;
=======
		if (equipped.equalsIgnoreCase("0") || equipped.equalsIgnoreCase("")) this.equipped = "None";
		else this.equipped = equipped;
>>>>>>> 9000c3e9637ea0629556b0ae229f077350f81a1c
	}

	public String getHealth() {
		return health;
	}
<<<<<<< HEAD

	public boolean isLose() {
		return lose;
	}

	public void setLose(boolean lose) {
		this.lose = lose;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public boolean isRestart() {
		return restart;
	}

	public void setRestart(boolean restart) {
		Connector.restart = restart;
	}

=======
	
	
	
>>>>>>> 9000c3e9637ea0629556b0ae229f077350f81a1c
}
