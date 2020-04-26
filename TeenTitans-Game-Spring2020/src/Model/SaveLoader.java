package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/* Loads the save file in the database */

public class SaveLoader extends java.util.Observable {

	String url = "jdbc:ucanaccess://Resource/SoftDevPro_Final_One_For_Real_JK.accdb";
	private ArrayList<SaveFile> saves;
	Entity player;

	public SaveLoader() {
		saves = new ArrayList<SaveFile>();

		try {
			Connection con = DriverManager.getConnection(url);
			Statement s = con.createStatement();
//			ResultSet rs = s.executeQuery(
//					"SELECT saveID, room_id from player");
			ResultSet rs = s
					.executeQuery("SELECT p.saveid, r.room FROM player p INNER JOIN rooms r ON r.room_id = p.room_id");

			while (rs.next()) {
				String saveID = rs.getString(1);
				String room_id = rs.getString(2);

//				Connection con1 = DriverManager.getConnection(url);
//				Statement s1 = con1.createStatement();
//				ResultSet r = s1.executeQuery(
//						"SELECT room FROM Rooms WHERE room_id =" + room_id);
//				r.next();

//				room_id = r.getString(1);

				saves.add(new SaveFile(saveID, room_id));
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
