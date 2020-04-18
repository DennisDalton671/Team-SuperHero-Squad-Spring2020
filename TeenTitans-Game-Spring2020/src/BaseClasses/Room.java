package BaseClasses;

import java.util.ArrayList;

public class Room {

    private String id;
    private String name;
    private String description;
    private String monsterID;
    private String itemID;
    private String puzzleID;
    private String NorthID;
    private String SouthID;
    private String WestID;
    private String EastID;
    private String itemID2;
    private String itemID3;

    ArrayList<String> inventory = new ArrayList<String>();
    
    //BaseClasses.Room with everything
    public Room (String id, String name, String description, String monsterID, String itemID, String puzzleID, String NorthID, String SouthID, String WestID, String EastID, String itemID2, String itemID3 ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.monsterID = monsterID;
        this.itemID = itemID;
        this.puzzleID = puzzleID;
        this.NorthID = NorthID;
        this.SouthID = SouthID;
        this.WestID = WestID;
        this.EastID = EastID;
        this.itemID2 = itemID2;
        this.itemID3 = itemID3;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { 
    	/*If there are more then 50 character in a line, 
		it'll make a new line*/
		if(description.length() > 50) {
			int totalCharacterLength = 0;
			int descriptionLength = description.length();
			String outputString ="";

			for (String word : description.split(" ")) {
				totalCharacterLength += word.length();
				descriptionLength -= word.length()+1;
				outputString += word + " ";

				if(totalCharacterLength > 40 && descriptionLength > 0) {
					totalCharacterLength = 0;
					outputString += "\n";
				}
			}
			description = outputString;
		}
		return description; 
		}
    public String getMonsterID() { return monsterID; }
    public String getItemID() { return itemID; }
    public String getPuzzleID() { return puzzleID; }
    public String getNorthID() { return NorthID; }
    public String getSouthID() { return SouthID; }
    public String getEastID() { return EastID; }
    public String getWestID() { return WestID; }
    public String getItemID2() { return itemID2; }
    public String getItemID3() { return itemID3; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) {this.description = description;} 
    public void setMonsterID(String monsterID) { this.monsterID = monsterID; }
    public void setItemID(String itemID) { this.itemID = itemID; }
    public void setPuzzleID(String puzzleID) { this.puzzleID = puzzleID; }
    public void setNorthID(String northID) { NorthID = northID; }
    public void setSouthID(String southID) { SouthID = southID; }
    public void setEastID(String eastID) { EastID = eastID; }
    public void setWestID(String westID) { WestID = westID; }
    public void setItemID2(String itemID2) { this.itemID2 = itemID2; }
    public void setItemID3(String itemID3) { this.itemID3 = itemID3; }
	
    public void Scan() {
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println(inventory.get(i));
		}
	}
	
	public void PickUp(Player p) {
		for (int i = 0; i < inventory.size(); i++) {
			p.addInventory(inventory.get(i));
		}
		inventory.clear();
		return p;
	}
	
	public void Drop(Player p) {
		for (int i = 0; i < p.getSize(); i++) {
			inventory.add(p.getIndex(i));
		}
		p.clear();
		return p;
	}
	
	public void Inspect(String puzzleID) {
		this.puzzleID = puzzleID;
	}
	public void puzzleClear() {
		this.puzzleID = "0";
		}
	}




