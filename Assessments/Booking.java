package com.lpu.HotelManagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="booking_details")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	@Column (nullable=false)
	private String customerName;
	private String roomType;
	private int stayDays;
	private double totalAmount;
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getStayDays() {
		return stayDays;
	}
	public void setStayDays(int stayDays) {
		this.stayDays = stayDays;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public void calculateTotalAmt() {
		int price=0;
		if(roomType.equalsIgnoreCase("Standard")) 
			price=2000;
		else if(roomType.equalsIgnoreCase("Deluxe"))
			price=3500;
		else if(roomType.equalsIgnoreCase("Suite"))
			price=5000;
			
		else 
			throw new IllegalArgumentException("invalid room type");
		
		totalAmount=price*getStayDays();
		
	}
	

}
