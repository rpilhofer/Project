package com.richard.airline.reservations1;

import javafx.application.Application;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class Back {

	
	
	String[] registerInfo = new String[11];
	static String[] specs = new String[8];
	static Database database = new Database();
	private static String currentUser;
	static Integer[] nums = new Integer[8];
	static Integer currentUserID;
	
	public boolean login(String userName, String passWord)  {
		
	
		ResultSet myRs = null;	
		myRs = Database.getUsers(userName, passWord);
			try {
				if (myRs.next() == true){
					setCurrentUser(userName);
					setCurrentUserID(userName);
					
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
		
	}
			
	public ArrayList<Flight> searchReservations(String[] specs){
		
		ArrayList<Flight> searchFlightAL = new ArrayList();
		
		ResultSet specRs = null;
		
		try {	
			specRs = database.getSearchReservations(specs);
			while (specRs.next() == true){
				Flight thisFlight = new Flight();
			thisFlight.setFlightID(specRs.getInt(1));
			thisFlight.setDepartTime(specRs.getString(3));
			thisFlight.setArrivalTime(specRs.getString(4));
			thisFlight.setDepartDate(specRs.getString(5));
			thisFlight.setOriginCity(specRs.getString(6));
			thisFlight.setDestinationCity(specRs.getString(7));
			thisFlight.setSeatQuantity(specRs.getInt(8));
			thisFlight.setOriginCountry(specRs.getString(9));
			searchFlightAL.add(thisFlight);
			}
			return searchFlightAL;
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Seat> getAvailableSeats(Flight currentFlight){
		
		ResultSet rs = currentFlight.getSeatsFromFlight();
		ArrayList<Seat> specAL= new ArrayList();
		try {
				
			while (rs.next() == true){
				Seat seat = new Seat();
				seat.setSeatID(rs.getInt(1));
				seat.setSeatClass(rs.getString(2));
				seat.setSeatPrice(rs.getDouble(3));
				seat.setFlightID(rs.getInt(4));
				specAL.add(seat);
			}
			return specAL;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
				
	public static void registerNewUser(String[] info){
				
				ResultSet dBrs = database.getUsers(info[9], info[10]);	
		
				try {	   
					if (dBrs.next() == false){
						database.addUser(info);
						}
				} catch (SQLException e){
					e.printStackTrace();
				}
		}
	
	public static boolean addPaymentMethod(String[] specs){
		
		
		try{
		if (database.getCardFromBank(specs).next() == true){
			if (database.getCardFromAirline(specs).next() == false){
					database.addPaymentMethod(specs, database.getCurrentUserID(getCurrentUser()));
					return true;
				}
			}
		}
		catch (Exception e){
			e.printStackTrace();
			}
		return false;
	}	

	public static void addNewFlight(String[] specs, Integer[] nums){

			try {
				database.addFlightInfo(specs, nums);
				nums[5] = database.getLastFlightID();
				database.addSeats(specs, nums);
				
					
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public static boolean transact(String spec, double price){
		try{
		double availableBalance = database.getAvailableBalance(spec);
		if (availableBalance <= price){
			availableBalance -= price;
			database.updateAvailableBalance(availableBalance, spec);
			return true;
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public String convertMonth(String arg){
		
		if (arg == "January"){
			arg = "01";
		}
		if (arg == "Febuary"){
			arg = "02";
		}
		if (arg == "March"){
			arg = "03";
		}
		if (arg == "April"){
			arg = "04";
		}
		if (arg == "May"){
			arg = "05";
		}
		if (arg == "June"){
			arg = "06";
		}
		if (arg == "July"){
			arg = "07";
		}
		if (arg == "August"){
			arg = "08";
		}
		if (arg == "September"){
			arg = "09";
		}
		if (arg == "October"){
			arg = "10";
		}
		if (arg == "November"){
			arg = "11";
		}
		if (arg == "December"){
			arg = "12";
		}
		
		return arg;
	}

//	public ArrayList<String> getAvailblePaymentMethods(String[] specs, Integer[] nums){
//		ArrayList<String[]> specAL = new ArrayList();
//		ResultSet rs = Database.getPaymentMethods(currentUserID);
//		try {
//			while (rs.next() == true){
//				
//			}
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//		
//		
//		
//	}
	
	public static String getCurrentUser() {
		return currentUser;
	}

	
	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
		System.out.println("this.Username = " + currentUser);
		}
		
	public void setCurrentUserID(String userName){
		this.currentUserID = Database.getCurrentUserID(userName);
		System.out.println("id = " + currentUserID);
	}
	
}
	
	

