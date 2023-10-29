package com.railways.service;

import java.util.List;

import com.railways.pojo.Booking;

public interface BookingService {
	
	public List<Booking> getBookingList();
	public String getTrainListByAvailability(int train_no);
	public String getTrainListByQuota(String quota, int train_no);
	public String add(Booking platform);
	public String update(int id,Booking platform);
//	public String delete(int customerid);
}
