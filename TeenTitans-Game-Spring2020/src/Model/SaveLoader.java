package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/* Loads the save file in the database */

public class SaveLoader extends java.util.Observable{

	String url ="jdbc:ucanaccess://Resource/SoftDevPro_Final_One_For_Real_JK.accdb";
	private ArrayList<SaveFile> saves;
	Entity player;
	
	public SaveLoader() {
		saves = new ArrayList<SaveFile>();
		
		try {
			Connection con = DriverManager.getConnection(url);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(
					"SELECT saveID, health, attack, playerState, equipped, room_id, items from player");
			while (rs.next()) {
				String saveID = rs.getString(1);
				String health = rs.getString(2);
				String attack = rs.getString(3);
				String playerState = rs.getString(4);
				String equipped = rs.getString(5);
				String room_id = rs.getString(6);
				String items = rs.getString(7);

				saves.add(new SaveFile(saveID, health, attack, playerState, equipped, room_id, items));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getSaves() {
		setChanged();
		notifyObservers(saves);
	}
	
}
