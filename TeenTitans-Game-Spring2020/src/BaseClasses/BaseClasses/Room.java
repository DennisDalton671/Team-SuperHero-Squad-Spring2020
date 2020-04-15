package BaseClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Room {

    private String id;
    private String name;
    private String description;
    private String monsterID;
    private String itemID;
<<<<<<< HEAD
    private String itemID2;
    private String itemID3;
    private String puzzleID;
    private int floor;
    private String NorthID;
    private String SouthID;
    private String EastID;
    private String WestID;

    //BaseClasses.Room with everything
    public Room (String id, String name, String description, String monsterID, String itemID, String itemID2, String itemID3, String puzzleID,int floor, String NorthID, String SouthID, String EastID, String WestID) {
=======
    private String puzzleID;
    private String NorthID;
    private String SouthID;
    private String WestID;
    private String EastID;
    private String itemID2;
    private String itemID3;

    //BaseClasses.Room with everything
    public Room (String id, String name, String description, String monsterID, String itemID, String puzzleID, String NorthID, String SouthID, String WestID, String EastID, String itemID2, String itemID3 ) {
>>>>>>> origin/Omar
        this.id = id;
        this.name = name;
        this.description = description;
        this.monsterID = monsterID;
        this.itemID = itemID;
        this.itemID2 = itemID2;
        this.itemID3 = itemID3;
        this.puzzleID = puzzleID;
        this.NorthID = NorthID;
        this.SouthID = SouthID;
        this.WestID = WestID;
<<<<<<< HEAD
    }

    //BaseClasses.Room without BaseClasses.Puzzle
    public Room (String id, String name, String description, String monsterID, String itemID, String itemID2, String itemID3, int floor, String NorthID, String SouthID, String EastID, String WestID) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.monsterID = monsterID;
        this.itemID = itemID;
        this.itemID2 = itemID2;
        this.itemID3 = itemID3;
        this.floor = floor;
        this.NorthID = NorthID;
        this.SouthID = SouthID;
=======
>>>>>>> origin/Omar
        this.EastID = EastID;
        this.itemID2 = itemID2;
        this.itemID3 = itemID3;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getMonsterID() { return monsterID; }
    public String getItemID() { return itemID; }
    public String getPuzzleID() { return puzzleID; }
<<<<<<< HEAD
    public int getFloor() { return floor; }
=======
>>>>>>> origin/Omar
    public String getNorthID() { return NorthID; }
    public String getSouthID() { return SouthID; }
    public String getEastID() { return EastID; }
    public String getWestID() { return WestID; }
<<<<<<< HEAD
=======
    public String getItemID2() { return itemID2; }
    public String getItemID3() { return itemID3; }
>>>>>>> origin/Omar

    // Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setMonsterID(String monsterID) { this.monsterID = monsterID; }
    public void setItemID(String itemID) { this.itemID = itemID; }
<<<<<<< HEAD
    public void setItemI2D(String itemID2) { this.itemID2 = itemID2; }
    public void setItemID3(String itemID3) { this.itemID3 = itemID3; }
    public void setPuzzleID(String puzzleID) { this.puzzleID = puzzleID; }
    public void setFloor(int floor) { this.floor = floor; }
=======
    public void setPuzzleID(String puzzleID) { this.puzzleID = puzzleID; }
>>>>>>> origin/Omar
    public void setNorthID(String northID) { NorthID = northID; }
    public void setSouthID(String southID) { SouthID = southID; }
    public void setEastID(String eastID) { EastID = eastID; }
    public void setWestID(String westID) { WestID = westID; }
<<<<<<< HEAD
    
    
    public static void main(String[] args) {
    ArrayList<String> rlist = new ArrayList<String>();
	
	String url = "jdbc:ucanaccess://Resource/SoftDevPro.accdb";
	
	try {
		Connection con = DriverManager.getConnection(url);
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT room_id, room, room_desc, monster_id, item_id, item_id2, item_id3, puzzle_id, floor, north_id, south_id, east_id, west_id FROM rooms");
		while (rs.next()) {
			rlist.add(rs.getString(1));
			rlist.add(rs.getString(2));
			rlist.add(rs.getString(3));
			rlist.add(rs.getString(4));
			rlist.add(rs.getString(5));
			rlist.add(rs.getString(6));
			rlist.add(rs.getString(7));
			rlist.add(rs.getString(8));
			rlist.add(rs.getString(9));
			rlist.add(rs.getString(10));
			rlist.add(rs.getString(11));
			rlist.add(rs.getString(12));
			rlist.add(rs.getString(13));
			System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3) + "\t\t\t" + rs.getString(4)+ "\t\t\t" + rs.getString(5)
								+ "\t\t\t" + rs.getString(6) + "\t\t\t" + rs.getString(6) + "\t\t\t" + rs.getString(7) + "\t\t\t" + rs.getString(8)
								+ "\t\t\t" + rs.getString(9) + "\t\t\t" + rs.getString(10) + "\t\t\t" + rs.getString(11));
		}
	} catch (SQLException e) {
		e.printStackTrace();
		
		}
    }
=======
    public void setItemID2(String itemID2) { this.itemID2 = itemID2; }
    public void setItemID3(String itemID3) { this.itemID3 = itemID3; }







>>>>>>> origin/Omar
}
