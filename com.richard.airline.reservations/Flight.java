package com.richard.airline.reservations1;

import java.sql.ResultSet;

public class Flight {

	public Integer flightID;
	public String flightName;
	public String departTime;
	public String arrivalTime;
	public String departDate;
	public String originCity;
	public String destinationCity;
	public Integer seatQuantity;
	public String originCountry;
	public Database dataBaseConncter;
	
	public ResultSet getSeatsFromFlight(){
		return Database.getSeatsFromFlight(flightID);
	}
	
	
	public String getFlightName() {
		return flightName;
	}


	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}


	public String getDepartTime() {
		return departTime;
	}


	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}


	public String getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public String getDepartDate() {
		return departDate;
	}


	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}


	public String getOriginCity() {
		return originCity;
	}


	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}


	public String getDestinationCity() {
		return destinationCity;
	}


	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}


	public Integer getSeatQuantity() {
		return seatQuantity;
	}


	public void setSeatQuantity(Integer seatQuantity) {
		this.seatQuantity = seatQuantity;
	}


	public String getOriginCountry() {
		return originCountry;
	}


	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}


	public void setFlightID(Integer flightNum){
		this.flightID = flightNum;
	}
	
	public Integer getFlightID(){
		return flightID;
	}
	
}
