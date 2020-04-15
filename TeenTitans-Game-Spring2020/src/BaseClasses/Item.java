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

    public Item(String id, String itemName, String description, String roomLocation, String attack_point, String room_id, String item_benefit, String item_use, String craft) {
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
        
    	ArrayList<Item> ilist = new ArrayList<Item>();
    	
    	String url = "jdbc:ucanaccess://Resource/SoftDevPro.accdb";
    	
    	try {
    		Connection con = DriverManager.getConnection(url);
    		Statement s = con.createStatement();
    		ResultSet rs = s.executeQuery("SELECT item_id, item, item_desc, acquired, acquired_additional, item_boost, item_benefit, item_use, craft FROM monsters");
    		while (rs.next()) {
    			String item_id = rs.getString(1);
    			String item = rs.getString(2);
    			String item_desc = rs.getString(3);
    			String acquired = rs.getString(4);
    			String acquired_additional = rs.getString(5);
    			String item_boost = rs.getString(6);
    			String item_benefit = rs.getString(7);
    			String item_use = rs.getString(8);
    			String craft = rs.getString(9);
    			
    			ilist.add(new Item(item_id, item, item_desc, acquired, acquired_additional, item_boost, item_benefit, item_use, craft));
    			
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    		}
    	}
    }