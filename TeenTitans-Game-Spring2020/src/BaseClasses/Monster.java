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
    private int health;
    private int attackPoints;
    private int roomLocaiton;
    private String monsterDefeatedMessage;

    public Monster(String id, String name, String description, int health, int attackPoints, int roomLocaiton, String monsterDefeatedMessage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.health = health;
        this.attackPoints = attackPoints;
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
}
