package busReservationProject;
import java.sql.*;
import java.util.Date;

public class BookingDAO {

	public int getBookedCount(int busNo, Date date) throws SQLException{
		String sql="select count(name) from booking where bus_no=? and travel_date=?";
		Connection con=DbConnection.getConnection();
		PreparedStatement pst=con.prepareStatement(sql);
		//since both SQL and util have date object, to avoid confusion we create a sqlDate object
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		pst.setInt(1, busNo);
		pst.setDate(2, sqlDate);
		ResultSet rs=pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	public void addBooking(Booking booking) throws SQLException {
		String sql="insert into booking values(?,?,?)";
		Connection con=DbConnection.getConnection();
		java.sql.Date sqlDate=new java.sql.Date(booking.date.getTime());
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, booking.PassengerName);
		pst.setInt(2, booking.busNo);
		pst.setDate(3, sqlDate);
		pst.executeUpdate();
	}

}
