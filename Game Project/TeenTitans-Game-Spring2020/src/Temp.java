import java.sql.*;

public class Temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Team");
		System.out.println("Sebastien Says hey");


		
		String url = "jdbc:ucanaccess://Resource/SoftDevPro.accdb";
		//String url = "jdbc:ucanaccess://D://School//Database//SoftDevPro.accdb";
		
		try {
			Connection con = DriverManager.getConnection(url);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("SELECT i.item, r.room FROM items INNER JOIN rooms r WHERE i.item_id = r.item_id");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3) + "\t\t\t" + rs.getString(4) + "\t\t\t" + rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		System.out.println("Taylor's commit");
		
	}

}
