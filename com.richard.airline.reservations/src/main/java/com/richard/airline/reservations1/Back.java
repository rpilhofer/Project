package com.richard.airline.reservations1;

import javafx.application.Application;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class Back {

	
	
	String[] registerInfo = new String[11];
	String[] specs = new String[8];
	static Database database = new Database();
	private static String currentUser;
	Integer[] nums = new Integer[8];
	static Random flightNameGenerator;
	static Integer flightNum = 001;
	
	public boolean login(String userName, String passWord)  {
		
	
		ResultSet myRs = null;	
		myRs = Database.getUsers(userName, passWord);
			try {
				if (myRs.next() == true){
					setCurrentUser(userName);
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
		
	}
		
	
	public ArrayList<String[]> searchReservations(String[] specs){
		
		ArrayList<String[]> specAL = new ArrayList();
	
		ResultSet specRs = null;
		String[] results = new String[5];
		specRs = database.getSearchReservations(specs);
		try {	
			while (specRs.next() == true){
			 	results[0] = specRs.getString(5);
			 	results[1] = specRs.getString(6);
			 	results[2] = specRs.getString(7);
			 	results[3] = specRs.getString(3);
			 	results[4] = specRs.getString(4);
			 	specAL.add(results);	 	
			 	
			}
			return specAL;
		}
		catch (SQLException e){
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
//		coming soon
			nums[0] = flightNum;
			try {
			if (database.getFlightName(nums[0]).next() == false){
					database.createFlightTable(specs, nums);
						for (int i = 0; i <= nums[1]+1; i++){
							database.addFirstClassSeatToFlight(specs, nums);
						}
						for (int i = 0; i <= nums[3]+1; i++){
							database.addCoachSeatToFlight(specs, nums);
						}
					
						database.addFlightInfo(specs, nums);
						flightNum += 1;
						System.out.println("Great Success my friend! FLightnum is now " + flightNum);
			}
					
		}
		catch (SQLException e){
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


	public static String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
		System.out.println("this.Username = " + currentUser);
		}
		
	}
	
	
	
	

