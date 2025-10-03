package busReservationProject;
import java.sql.*;

public class DbConnection {
	static final String url="jdbc:mysql://localhost:3306/busreserv";
	static final String user="root";
	static final String password="kalpana@sql";
	public static Connection getConnection() throws SQLException { 
		return DriverManager.getConnection(url, user, password);
	}
}
