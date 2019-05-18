import java.sql.Connection;
import java.sql.DriverManager;

//The Connection Class which Connects to MySQL server 
public class getNewConnection {
	public static Connection getSQLConnection() {
		String myDriver = "com.mysql.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/lib";
		Connection con = null;
		{
			try {
				Class.forName(myDriver);
				con = DriverManager.getConnection(myUrl, "root", "root");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
	}
}
