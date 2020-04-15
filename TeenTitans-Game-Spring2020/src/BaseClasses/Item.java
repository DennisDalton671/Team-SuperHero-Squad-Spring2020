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
<<<<<<< HEAD
    private String roomLocation;

    public Item(String id, String itemName, String description, String roomLocation, String attack_point, String room_id, String item_benefit, String item_use, String craft) {
=======
    private String acquired;
    private String acquired2;
    private String itemBoost;
    private String itemBenefit;
    private String itemUse;
    private String Craft;

    public Item(String id, String itemName, String description, String acquired, String acquired2, String itemBoost, String itemBenefit, String itemUse, String craft) {
>>>>>>> origin/Omar
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.acquired = acquired;
        this.acquired2 = acquired2;
        this.itemBoost = itemBoost;
        this.itemBenefit = itemBenefit;
        this.itemUse = itemUse;
        Craft = craft;
    }

<<<<<<< HEAD
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
=======
    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAcquired() {
        return acquired;
    }

    public void setAcquired(String acquired) {
        this.acquired = acquired;
    }

    public String getAcquired2() {
        return acquired2;
    }

    public void setAcquired2(String acquired2) {
        this.acquired2 = acquired2;
    }

    public String getItemBoost() {
        return itemBoost;
    }

    public void setItemBoost(String itemBoost) {
        this.itemBoost = itemBoost;
    }

    public String getItemBenefit() {
        return itemBenefit;
    }

    public void setItemBenefit(String itemBenefit) {
        this.itemBenefit = itemBenefit;
    }

    public String getItemUse() {
        return itemUse;
    }

    public void setItemUse(String itemUse) {
        this.itemUse = itemUse;
    }

    public String getCraft() {
        return Craft;
    }

    public void setCraft(String craft) {
        Craft = craft;
    }
}
>>>>>>> origin/Omar
