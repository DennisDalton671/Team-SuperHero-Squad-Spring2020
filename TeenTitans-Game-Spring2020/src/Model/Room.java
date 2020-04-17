package Model;

public class Room {

    private String id;
    private String name;
    private String description;
    private String monsterID;
    private String itemID;
    private String puzzleID;
    private String floor;
    private String NorthID;
    private String SouthID;
    private String EastID;
    private String WestID;
    private String itemID2;
    private String itemID3;

    //BaseClasses.Room with everything
    public Room (String id, String name, String description, String monsterID, String itemID, String puzzleID, String NorthID, String SouthID, String EastID, String WestID, String itemId2, String itemId3) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.monsterID = monsterID;
        this.itemID = itemID;
        this.puzzleID = puzzleID;
        this.floor = floor;
        this.NorthID = NorthID;
        this.SouthID = SouthID;
        this.EastID = EastID;
        this.WestID = WestID;
        this.itemID2 = itemId2;
        this.itemID3 = itemId3;
    }

    //BaseClasses.Room without BaseClasses.Puzzle
    public Room (String id, String name, String description, String monsterID, String itemID,String floor, String NorthID, String SouthID, String EastID, String WestID) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.monsterID = monsterID;
        this.itemID = itemID;
        this.floor = floor;
        this.NorthID = NorthID;
        this.SouthID = SouthID;
        this.EastID = EastID;
        this.WestID = WestID;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getMonsterID() { return monsterID; }
    public String getItemID() { return itemID; }
    public String getPuzzleID() { return puzzleID; }
    public String getFloor() { return floor; }
    public String getNorthID() { return NorthID; }
    public String getSouthID() { return SouthID; }
    public String getEastID() { return EastID; }
    public String getWestID() { return WestID; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setMonsterID(String monsterID) { this.monsterID = monsterID; }
    public void setItemID(String itemID) { this.itemID = itemID; }
    public void setPuzzleID(String puzzleID) { this.puzzleID = puzzleID; }
    public void setFloor(String floor) { this.floor = floor; }
    public void setNorthID(String northID) { NorthID = northID; }
    public void setSouthID(String southID) { SouthID = southID; }
    public void setEastID(String eastID) { EastID = eastID; }
    public void setWestID(String westID) { WestID = westID; }







}
