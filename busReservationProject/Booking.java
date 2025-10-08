package busReservationProject;

import java.sql.SQLException;
import java.text.*;
import java.util.*;

public class Booking {
	String PassengerName;
    int busNo;
    Date date;
    
    Booking(){
    	Scanner scr=new Scanner(System.in);
        System.out.println("Enter Passenger Name:");
        PassengerName=scr.next();
        System.out.println("Enter Bus no. :");
        busNo=scr.nextInt();
        System.out.println("Enter Date(dd-mm-yyyy):");
        String dateInp=scr.next();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");//MM-Month(not minutes)
        try {
            date=dateFormat.parse(dateInp);
        } catch (ParseException e) {
            System.out.println("Invalid Date Format");
        }
    }
    
    public boolean isAvailable() throws SQLException {
    	BusDAO busDAO=new BusDAO();
    	BookingDAO bookingDAO=new BookingDAO();
    	int capacity=busDAO.getCapacity(busNo);
    	int booked=bookingDAO.getBookedCount(busNo,date);
    	return booked<capacity;
    }
}
