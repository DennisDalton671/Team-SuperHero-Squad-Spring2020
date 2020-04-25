import BaseClasses.Monster;
import BaseClasses.PuzzleState;
import Model.AttackState;
import Model.Puzzle;

import java.sql.*;

public class Temp {

	public static void main(String[] args) throws InterruptedException {


		Monster Test = new Monster("1", "TestMonster", "desc","50", "5", "1","oof","e","");
		//Puzzle Test2 = new Puzzle("1","Puzzledesc1","Puzzledesc2","puzzledesc3","puzzledesc4", "hint1", "hint2", "hint3", "hint4", "solution", "solution2", "solution3", "solution4", "reward", "penalty", "Room1", "Room2");
		//PuzzleState.puzzleState(Test2);
		//AttackState.attackState(Test);

		/*System.out.println("Hello Team");
		System.out.println("Sebastien Says hey");
		System.out.println("Taylor's commit");
		System.out.println("Omar was here");

		String url = "jdbc:ucanaccess://Resource/DatabasePractice.accdb";
		//String url = "jdbc:ucanaccess://D://School//Database//DatabasePractice.accdb";
		
		try {
			Connection con = DriverManager.getConnection(url);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Address");
			while (rs.next()) {
				System.out.println(rs.getInt("Address_ID") + "\t\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3) + "\t\t\t" + rs.getString(4) + "\t\t\t" + rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/

	}

}
