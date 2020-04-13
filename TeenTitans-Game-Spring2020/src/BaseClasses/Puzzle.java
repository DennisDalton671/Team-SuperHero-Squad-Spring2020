package BaseClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Puzzle {

    private String id;
    private String description;
    private String description2;
    private String description3;
    private String description4;
    private String hint;
    private String hint2;
    private String hint3;
    private String hint4;
    private String solution;
    private String solution2;
    private String solution3;
    private String solution4;
    private String rewards;
    private String punishment;
    private String roomLocation;
    private String roomLocation2;

    public Puzzle(String id, String description, String description2, String description3, String description4,
    		String hint, String hint2, String hint3, String hint4, String solution, String solution2, String solution3,
    		String solution4, String rewards, String punishment, String roomLocation, String roomLocation2) {
        this.id = id;
        this.description = description;
        this.solution = solution;
        this.rewards = rewards;
        this.punishment = punishment;
    }

    // Getters
    public String getId() { return id; }
    public String getDescription() { return description; }
    public String getDescription2() { return description2; }
    public String getDescription3() { return description3; }
    public String getDescription4() { return description4; }
    public String gethint() { return hint; }
    public String gethint2() { return hint2; }
    public String gethint3() { return hint3; }
    public String gethint4() { return hint4; }
    public String getSolution() { return solution; }
    public String getSolution2() { return solution2; }
    public String getSolution3() { return solution3; }
    public String getSolution4() { return solution4; }
    public String getRewards() { return rewards; }
    public String isPunishment() { return punishment; }
    public String getRoomLocation() { return roomLocation; }
    public String getRoomLocation2() { return roomLocation2; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
    public void setDescription2(String description2) { this.description2 = description2; }
    public void setDescription3(String description3) { this.description3 = description3; }
    public void setDescription4(String description4) { this.description4 = description4; }
    public void setHint(String hint) { this.hint = hint; }
    public void setHint2(String hint2) { this.hint2 = hint2; }
    public void setHint3(String hint3) { this.hint3 = hint3; }
    public void setHint4(String hint4) { this.hint4 = hint4; }
    public void setSolution(String solution) { this.solution = solution; }
    public void setSolution2(String solution2) { this.solution2 = solution2; }
    public void setSolution3(String solution3) { this.solution3 = solution3; }
    public void setSolution4(String solution4) { this.solution4 = solution4; }
    public void setRewards(String rewards) { this.rewards = rewards; }
    public void setPunishment(String punishment) { this.punishment = punishment; }
    public void setRoomLocation(String roomLocation) { this.roomLocation = roomLocation; }
    public void setRoomLocation2(String roomLocation2) { this.roomLocation2 = roomLocation2; }
    
    public static void main(String[] args) {
        ArrayList<String> plist = new ArrayList<String>();
    	
    	String url = "jdbc:ucanaccess://Resource/SoftDevPro.accdb";
    	
    	try {
    		Connection con = DriverManager.getConnection(url);
    		Statement s = con.createStatement();
    		ResultSet rs = s.executeQuery("SELECT puzzle_id, puzzle_desc, puzzle_desc2, puzzle_desc3, puzzle_desc4, hint, hint2, hint3, hint4, solution, solution2, solution3, solution4, reward, penalty, room_puzzle, room_puzzle2 FROM puzzles");
    		while (rs.next()) {
    			plist.add(rs.getString(1));
    			plist.add(rs.getString(2));
    			plist.add(rs.getString(3));
    			plist.add(rs.getString(4));
    			plist.add(rs.getString(5));
    			plist.add(rs.getString(6));
    			plist.add(rs.getString(7));
    			plist.add(rs.getString(8));
    			plist.add(rs.getString(9));
    			plist.add(rs.getString(10));
    			plist.add(rs.getString(11));
    			plist.add(rs.getString(12));
    			plist.add(rs.getString(13));
    			plist.add(rs.getString(14));
    			plist.add(rs.getString(15));
    			plist.add(rs.getString(16));
    			plist.add(rs.getString(17));
    			System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3) + "\t\t\t" + rs.getString(4)+ "\t\t\t" + rs.getString(5)
    								+ "\t\t\t" + rs.getString(6) + "\t\t\t" + rs.getString(6) + "\t\t\t" + rs.getString(7) + "\t\t\t" + rs.getString(8)
    								+ "\t\t\t" + rs.getString(9) + "\t\t\t" + rs.getString(10) + "\t\t\t" + rs.getString(11));
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    		
    		}
        }
    }
