import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Trial {
	
	public static void main(String[] args) {
		
		String url = "/Users/sebastien/git/gitDemo/Team-SuperHero-Squad-Spring2020/Game Project/TeenTitans-Game-Spring2020/Resource/SoftDevPro.accdb";
		
		try {
			Connection con = DriverManager.getConnection(url);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("SELECT i.item, r.room FROM items INNER JOIN rooms r WHERE i.item_id = r.item_id ");
			while (rs.next()) {
				System.out.println(rs.getString("1") + "\t\t\t" + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
