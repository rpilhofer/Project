package com.richard.airline.reservations1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;



public class Database {

	static Connection connection;
	static Connection bankConn;
	static Connection flightConn;

	static {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dickairlines?user=root");
			bankConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bank?user=root");
			flightConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dickflights?user=root");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static ResultSet getUsers(String userName, String passWord) {
		try {
			return connection.createStatement().executeQuery("select Customer_ID from login_info where Customer_ID = '" + userName + "'and Customer_pass = '" + passWord + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void addUser(String[] info){
		
		try {
			connection.createStatement().executeUpdate("insert into customer_info (FirstName, LastName, Address, ContactNum, City, State, Country, Gender, EmailAddress, CustomerID, CustomerPassword) values ( '"+ info[0] + "', '" + info[1] + "', '" + info[2]
																								+ "', '" + info[3] + "', '" + info[4] + "', '" + info[5]
																								+ "', '" + info[6] + "', '" + info[7] + "', '" + info[8]
																								+ "', '" + info[9] + "', '" + info[10] + "');");
			
			connection.createStatement().executeUpdate("insert into login_info (Customer_ID , Customer_pass) values ( '"+ info[9] +"', '" + info[10] + "'); ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
					
		
		
		
	}
	
	public static void addPaymentMethod(String[] specs, int num){
		try {
			connection.createStatement().executeUpdate("insert into payment_methods (credit_num, holder, customer) values ('" + specs[0] + "', '" + specs[1] + "' , " + num + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet getFlightName(Integer num){
		try {
			return connection.createStatement().executeQuery("select flight_name from flight_info where flight_name = 'flight" + num + "';");
			}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void createFlightTable(String[] specs, Integer[] nums){
		try{
			flightConn.createStatement().executeUpdate("create table flight" + nums[0] + " ( id serial, price int, seat_type varchar(14));");
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	public static void addFlightInfo(String[] specs, Integer[] nums){
//		coming soon
		try {
			connection.createStatement().executeUpdate("insert into Flight_Info(Flight_name, depart_time, arrival_time, depart_date, origin, destination, num_of_seats, origin_country_name) values "
												   + "('flight" + nums[0] + "','" + specs[5] + ":"+ specs[6] + ":00', '16:20:00', '2018:" + specs[3] + ":" + specs[4] + "', '" + specs[0] + "',"
												   + " '" + specs[2] + "', " + (nums[1] + nums[3]) + " , '" + specs[1] + "');" );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addCoachSeatToFlight(String[] specs, Integer[] nums){
		try {
			flightConn.createStatement().executeUpdate("insert into flight" + nums[0] + " (price, seat_type) values (" + nums[0] + ", 'coach' );");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	
	public static void addFirstClassSeatToFlight(String[] specs, Integer[] nums){
		try {
			flightConn.createStatement().executeUpdate("insert into flight" + nums[0] + " (price, seat_type) values (" + nums[0] + ", 'first class' );");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public static int getCurrentUserID(String userName){
		try {
			ResultSet rs = connection.createStatement().executeQuery("select id from customer_info where customerID = '" + userName + "';");
			rs.next();
			System.out.println("success");
			return rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		
		return 0;
		
	}
	
 	public static ResultSet getSearchReservations (String[] specs){
	
		try {
			return connection.createStatement().executeQuery("Select * from flight_info where Destination = '" + specs[0] + "' and Origin = '" + specs[1] + "'and Depart_date like '_____" + specs[2] + "-" + specs[3] + "';"); 
		} catch (SQLException e) {  
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static ResultSet getCardFromBank(String specs[]){
		
		try{
			return bankConn.createStatement().executeQuery("Select * from cards where cardholder = '" + specs[1] + "' and cardnumber = '" + specs[0] + "' and experationdate = '" + specs[4] + "-" + specs[3] + "-00' and securekey = '" + specs[2] + "';");
		}
			catch (SQLException e){
				e.printStackTrace();
			}
		return null;
		
	}
	
	public static ResultSet getCardFromAirline(String specs[]){
		
		try {
			return connection.createStatement().executeQuery("select * from payment_methods where credit_num = '" + specs[1] + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static double getAvailableBalance(String spec){
		
		try{
			ResultSet rs = bankConn.createStatement().executeQuery("select balance from cards where num = '" + spec + "';");
			rs.next();
			return rs.getDouble(1);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void updateAvailableBalance(double balance, String card){
		
		try {
			bankConn.createStatement().executeUpdate("update cards set balance = " + balance + " where cards = '" + card + "';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}

