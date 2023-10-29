package com.railways.pojo;

public class Booking {

	public Booking() {
	}

	public Booking(int id, int train_no,String quota, int booked_seats) {
		super();
		this.id = id;
		this.trainNo = train_no;
		this.quota = quota;
		this.bookedseats = booked_seats;
	}
	
		int id;
		int trainNo;
		String quota;
		int bookedseats;

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int train_no) {
		this.trainNo = train_no;
	}
	
	public String getQuota() {
		return quota;
	}

	public void setQuota(String quota) {
		this.quota = quota;
	}

	public int getBookedseats() {
		return bookedseats;
	}

	public void setBookedseats(int bookedseats) {
		this.bookedseats = bookedseats;
	}

	public String toString() {
		return id + "  " + trainNo + "  " + quota + "  " + bookedseats ;
	}

}
