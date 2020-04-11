public class Room {

    private int id;
    private String name;
    private String description;
    private int monsterID;
    private int itemID;
    private int puzzleID;
    private int NorthID;
    private int SouthID;
    private int EastID;
    private int WestID;

    //Room with everything
    public Room (int id, String name, String description, int monsterID, int itemID, int puzzleID, int NorthID, int SouthID, int EastID, int WestID) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.monsterID = monsterID;
        this.itemID = itemID;
        this.puzzleID = puzzleID;
        this.NorthID = NorthID;
        this.SouthID = SouthID;
        this.EastID = EastID;
        this.WestID = WestID;
    }

    //Room without Puzzle
    public Room (int id, String name, String description, int monsterID, int itemID, int NorthID, int SouthID, int EastID, int WestID) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.monsterID = monsterID;
        this.itemID = itemID;
        this.NorthID = NorthID;
        this.SouthID = SouthID;
        this.EastID = EastID;
        this.WestID = WestID;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getMonsterID() { return monsterID; }
    public int getItemID() { return itemID; }
    public int getPuzzleID() { return puzzleID; }
    public int getNorthID() { return NorthID; }
    public int getSouthID() { return SouthID; }
    public int getEastID() { return EastID; }
    public int getWestID() { return WestID; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setMonsterID(int monsterID) { this.monsterID = monsterID; }
    public void setItemID(int itemID) { this.itemID = itemID; }
    public void setPuzzleID(int puzzleID) { this.puzzleID = puzzleID; }
    public void setNorthID(int northID) { NorthID = northID; }
    public void setSouthID(int southID) { SouthID = southID; }
    public void setEastID(int eastID) { EastID = eastID; }
    public void setWestID(int westID) { WestID = westID; }







}
