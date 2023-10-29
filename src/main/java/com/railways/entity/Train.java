package com.railways.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "train")
public class Train {

	public Train() {
	}

	public Train(int id, int train_no, String source, String destination,int gen, int taq, int lad, int totalseats) {
		super();
		this.id = id;
		this.trainNo = train_no;
		this.source = source;
		this.destination = destination;
		this.gen = gen;
		this.taq = taq;
		this.lad = lad;
		this.totalSeats = totalseats;
	}

//	public Train(int id, int train_no, String source, String destination) {
//		super();
//		this.id = id;
//		this.train_no = train_no;
//		this.source = source;
//		this.destination = destination;
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "train_no")
	private int trainNo;

	@Column(name = "source")
	private String source;

	@Column(name = "destination")
	private String destination;
	
	@Column(name = "general")
	private int gen;
	
	@Column(name = "tatkal")
	private int taq;
	
	@Column(name = "ladies")
	private int lad;
	
	@Column(name = "total_seats")
	private int totalSeats;

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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public int getGen() {
		return gen;
	}

	public void setGen(int gen) {
		this.gen = gen;
	}
	
	public int getTaq() {
		return taq;
	}

	public void setTaq(int taq) {
		this.taq = taq;
	}
	
	public int getLad() {
		return lad;
	}

	public void setLad(int lad) {
		this.lad = lad;
	}
	
	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalseats) {
		this.totalSeats = totalseats;
	}

	public String toString() {
		return id + "  " + trainNo + "  " + source + "  " + destination +" "+ gen + " " + taq + "  " + lad + "  "+ totalSeats;
	}

}
