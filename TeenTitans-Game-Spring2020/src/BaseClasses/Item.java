package BaseClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Item {

    private String id;
    private String itemName;
    private String description;
    private String roomLocation;

    public Item(String id, String itemName, String description, String roomLocation) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.roomLocation = roomLocation;
    }

    // Getters
    public String getId() { return id; }
    public String getItemName() { return itemName; }
    public String getDescription() { return description; }
    public String getRoomLocation() { return roomLocation; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setDescription(String description) { this.description = description; }
    public void setRoomLocation(String roomLocation) { this.roomLocation = roomLocation; }
    public static void main(String[] args) {
        
    	ArrayList<String> ilist = new ArrayList<String>();
    	
    	String url = "jdbc:ucanaccess://Resource/SoftDevPro.accdb";
    	
    	try {
    		Connection con = DriverManager.getConnection(url);
    		Statement s = con.createStatement();
    		ResultSet rs = s.executeQuery("SELECT monster_id, monster, monster_desc, health_point, attack_point, room_id FROM monsters");
    		while (rs.next()) {
    			ilist.add(rs.getString(1));
    			ilist.add(rs.getString(2));
    			ilist.add(rs.getString(3));
    			ilist.add(rs.getString(4));
    			ilist.add(rs.getString(5));
    			ilist.add(rs.getString(6));
    			System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3) + "\t\t\t" + rs.getString(4));
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    		}
    	}
    }