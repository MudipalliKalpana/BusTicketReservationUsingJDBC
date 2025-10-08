package busReservationProject;

import java.sql.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws SQLException {
		Scanner scr = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n***Bus Ticket Reservation!!***\n");
            System.out.println("1.Get Bus Details\n2.Book a Ticket\n3.Initial Capacity\n4.Exit");
            System.out.println("Enter you choice:");
            String input = scr.nextLine(); // Read the entire line (including the number and newline)
            try {
                choice = Integer.parseInt(input); // Parse the integer from the line
            } catch (NumberFormatException e) {
                // Handle non-numeric input gracefully
                choice = -1; 
            }
            System.out.println();
            switch (choice) {
                case 1:
            		BusDAO bus=new BusDAO();
                    System.out.println("The Bus Details are: ");
                    bus.displayBusInfo();
                    break;
                    
                case 2:
                    Booking booking=new Booking();
                    if(booking.isAvailable()) {
                    	BookingDAO bookingDAO=new BookingDAO();
                    	bookingDAO.addBooking(booking);
                    	System.out.println("Your booking is confirmed!");
                    }
                    else {
                    	System.out.println("Sorry! Bus is full, Try another bus or date.");
                    }
                    break;
                case 3:
                	BusDAO busDAO=new BusDAO();
                	System.out.print("Initial Capacity: ");
                	busDAO.currentCapacity();
                	System.out.println();
                    break;
                case 4:
                    System.out.println("Thank you, Exiting...");
                    scr.close();
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice!(1-3)");
            }
        } while (true);
	}
}
