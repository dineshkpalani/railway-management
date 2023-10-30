package com.railways.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
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

//	public Train(int id, int train_no, String source, String destination) {
//		super();
//		this.id = id;
//		this.train_no = train_no;
//		this.source = source;
//		this.destination = destination;
//	}

	// cloud changes
	// cloud2

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "train_no")
	private int trainNo;
	
	@Column(name  = "quota")
	private String quota;
	
	@Column(name = "booked_seats")
	private int bookedseats;

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
		return id + "  " + trainNo + "  " + quota + " " + bookedseats ;
	}

}
