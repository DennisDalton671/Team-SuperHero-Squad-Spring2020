import java.sql.*;

public class Temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Team");
		System.out.println("Sebastien Says hey");


		
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
		


		System.out.println("Taylor's commit");
		System.out.println("Omar was here");

	}

}
