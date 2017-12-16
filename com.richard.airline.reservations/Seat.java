package com.richard.airline.reservations1;

public class Seat {
	
	public Integer flightID;
	public String seatClass;
	public Integer seatID;
	public Double seatPrice;
	
	public Double getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(Double seatPrice) {
		this.seatPrice = seatPrice;
	}
	public Integer getSeatID() {
		return seatID;
	}
	public void setSeatID(Integer seatID) {
		this.seatID = seatID;
	}
	public Integer getFlightID() {
		return flightID;
	}
	public void setFlightID(Integer flightID) {
		this.flightID = flightID;
	}
	public String getSeatClass() {
		return seatClass;
	}
	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
	
	public String getStringSeatPrice(){
		return seatPrice.toString();
	}
	
	public String getStringSeatID(){
		return seatID.toString();
	}
	
}
