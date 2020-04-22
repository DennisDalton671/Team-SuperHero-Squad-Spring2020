package BaseClasses;

public class Room {

    private String id;
    private String name;
    private String floor;
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

    //BaseClasses.Room with everything
    public Room (String id, String name, String floor, String description, String monsterID, String itemID, String puzzleID, String NorthID, String SouthID, String WestID, String EastID, String itemID2, String itemID3 ) {
        this.id = id;
        this.name = name;
        this.floor = floor;
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

    @Override
    public String toString() {
        return name + "\n" +
               description;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getFloor() { return floor; }
    public String getDescription() { return description; }
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
    public void setFloor(String floor) { this.floor = floor; }
    public void setDescription(String description) { this.description = description; }
    public void setMonsterID(String monsterID) { this.monsterID = monsterID; }
    public void setItemID(String itemID) { this.itemID = itemID; }
    public void setPuzzleID(String puzzleID) { this.puzzleID = puzzleID; }
    public void setNorthID(String northID) { NorthID = northID; }
    public void setSouthID(String southID) { SouthID = southID; }
    public void setEastID(String eastID) { EastID = eastID; }
    public void setWestID(String westID) { WestID = westID; }
    public void setItemID2(String itemID2) { this.itemID2 = itemID2; }
    public void setItemID3(String itemID3) { this.itemID3 = itemID3; }







}