package BaseClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Monster {

    private String id;
    private String name;
    private String description;
    private String health;
    private String attackPoints;
    private String roomid;
    private String DefeatedMessage;
    private String itemReward;
    private String itemReward2;

<<<<<<< HEAD
    public Monster(String id, String name, String description, int health, int attackPoints, int roomLocaiton, String monsterDefeatedMessage) {
=======

    public Monster(String id, String name, String description, String health, String attackPoints, String roomid, String defeatedMessage, String itemReward, String itemReward2) {
>>>>>>> origin/Omar
        this.id = id;
        this.name = name;
        this.description = description;
        this.health = health;
        this.attackPoints = attackPoints;
<<<<<<< HEAD
        this.roomLocaiton = roomLocaiton;
        this.monsterDefeatedMessage = monsterDefeatedMessage;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getHealth() { return health; }
    public int getAttackPoints() { return attackPoints; }
    public int getRoomLocaiton() { return roomLocaiton; }
    public String getMonsterDefeatedMessage() { return monsterDefeatedMessage; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setHealth(int health) { this.health = health; }
    public void setAttackPoints(int attackPoints) { this.attackPoints = attackPoints; }
    public void setRoomLocaiton(int roomLocaiton) { this.roomLocaiton = roomLocaiton; }
    public void setMonsterDefeatedMessage(String monsterDefeatedMessage) { this.monsterDefeatedMessage = monsterDefeatedMessage;}
    
    public static void main(String[] args) {
    ArrayList<String> mlist = new ArrayList<String>();
	
	String url = "jdbc:ucanaccess://Resource/SoftDevPro.accdb";
	
	try {
		Connection con = DriverManager.getConnection(url);
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT monster_id, monster, monster_desc, health_point, attack_point, room_id FROM monsters");
		while (rs.next()) {
			mlist.add(rs.getString(1));
			mlist.add(rs.getString(2));
			mlist.add(rs.getString(3));
			mlist.add(rs.getString(4));
			mlist.add(rs.getString(5));
			mlist.add(rs.getString(6));
			System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3) + "\t\t\t" + rs.getString(4));
		}
	} catch (SQLException e) {
		e.printStackTrace();
		}
	}
=======
        this.roomid = roomid;
        DefeatedMessage = defeatedMessage;
        this.itemReward = itemReward;
        this.itemReward2 = itemReward2;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(String attackPoints) {
        this.attackPoints = attackPoints;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getDefeatedMessage() {
        return DefeatedMessage;
    }

    public void setDefeatedMessage(String defeatedMessage) {
        DefeatedMessage = defeatedMessage;
    }

    public String getItemReward() {
        return itemReward;
    }

    public void setItemReward(String itemReward) {
        this.itemReward = itemReward;
    }

    public String getItemReward2() {
        return itemReward2;
    }

    public void setItemReward2(String itemReward2) {
        this.itemReward2 = itemReward2;
    }
>>>>>>> origin/Omar
}
