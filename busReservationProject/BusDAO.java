package busReservationProject;
//Bus Data Access Object
import java.sql.*;
public class BusDAO {

	public void displayBusInfo() throws SQLException{
		
		Connection con=DbConnection.getConnection();
		String sql="select *from bus";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println("Bus No: "+rs.getInt(1));
			if(rs.getInt(2)==1) {
				System.out.println("Ac: Yes");
			}
			else {
				System.out.println("Ac: No");
			}
			System.out.println("Capacity: "+rs.getInt(3));
			System.out.println();
		}
		System.out.println("--------------------------------");
		con.close();
	}

	public int getCapacity(int busNo) throws SQLException {
		String sql="select capacity from bus where id="+busNo;
		Connection con=DbConnection.getConnection();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		rs.next();
		return rs.getInt(1);
	}
	public void currentCapacity() throws SQLException{
		String sql="select capacity from bus";
		Connection con=DbConnection.getConnection();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println("Capacities: "+rs.getInt(1));
		}
	}

}
