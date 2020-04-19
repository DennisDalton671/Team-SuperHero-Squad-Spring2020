package Model;

import java.util.ArrayList;

public class Room {

    private String id;
    private String name;
    private String floor;
    private String description;
    private String monsterID;
    private String roomItemID;
    private String puzzleID;
    private String NorthID;
    private String SouthID;
    private String WestID;
    private String EastID;
    private String key;
    private ArrayList<String> roomItemInventory;
    

    //BaseClasses.Room with everything
    public Room (String id, String name, String floor, String description, String monsterID, String itemID, String puzzleID, String NorthID, String SouthID, String WestID, String EastID, String key) {
    	this.roomItemInventory = new ArrayList<String>();
    	this.id = id;
        this.id = id;
        this.name = name;
        this.floor = floor;
        this.description = description;
        this.monsterID = monsterID;
        this.roomItemInventory.add(itemID);
        this.puzzleID = puzzleID;
        this.NorthID = NorthID;
        this.SouthID = SouthID;
        this.WestID = WestID;
        this.EastID = EastID;
        this.key = key;
    }

    @Override
    public String toString() {
        return name + "\n" +
               description;
    }
    
    public boolean checkInventory(String id) {
    	return roomItemInventory.contains(id);
    }

	public boolean pickupItem(String name) {
		if (roomItemInventory.contains(name)) {
			roomItemInventory.remove(name);
			return true;
		}
		return false;
	}

    public void addInventory(String id) {
    	roomItemInventory.add(id);
    }
    
    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getFloor() { return floor; }
    public String getDescription() { return description; }
    public String getMonsterID() { return monsterID; }
   // public String getItemID() { return itemID; }
    public String getPuzzleID() { return puzzleID; }
    public String getNorthID() { return NorthID; }
    public String getSouthID() { return SouthID; }
    public String getEastID() { return EastID; }
    public String getWestID() { return WestID; }
    public String getKey() { return key; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setFloor(String floor) { this.floor = floor; }
    public void setDescription(String description) { this.description = description; }
    public void setMonsterID(String monsterID) { this.monsterID = monsterID; }
  //  public void setItemID(String itemID) { this.itemID = itemID; }
    public void setPuzzleID(String puzzleID) { this.puzzleID = puzzleID; }
    public void setNorthID(String northID) { this.NorthID = northID; }
    public void setSouthID(String southID) { this.SouthID = southID; }
    public void setEastID(String eastID) { this.EastID = eastID; }
    public void setWestID(String westID) { this.WestID = westID; }
    public void setkey(String key) { this.key = key; }

    





}
