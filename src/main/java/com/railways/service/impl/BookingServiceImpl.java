package com.railways.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railways.pojo.Booking;
import com.railways.pojo.Train;
import com.railways.repo.BookingRepo;
import com.railways.repo.TrainRepo;
import com.railways.service.BookingService;

@Service
// business logic
public class BookingServiceImpl implements BookingService {
	
//	@Autowired
//	private CustomersDao dao;
	
	@Autowired
	private BookingRepo repo;
	
	@Autowired
	private TrainRepo trainrepo;
	
	public List<Booking> getBookingList() {
		System.out.println("Booking - Service Implementation");
		Iterable<com.railways.entity.Booking> entites = repo.findAll();//retreives all the data
		List<Booking> pojos = new ArrayList<>();
//		int ts
		for(com.railways.entity.Booking platform : entites) {
			pojos.add(new Booking(platform.getID(), platform.getTrainNo(),platform.getQuota(), platform.getBookedseats()));
		}
		return pojos;
	}
	
	public String getTrainListByAvailability(int train_no) {
		com.railways.entity.Train ts = trainrepo.findByTrainNo(train_no);
		List<com.railways.entity.Booking> bs = repo.findByTrainNo(train_no);
		int abks = 0;
		for(com.railways.entity.Booking a:bs) {
			abks+=a.getBookedseats();
		}
		String res = "";
		int b = ts.getTotalSeats()-abks;
		res = b+" Seats Available for this Train";
		return res;
	}
	
	public String getTrainListByQuota(String quota, int train_no) {
		com.railways.entity.Train ts = trainrepo.findByTrainNo(train_no);
		List<com.railways.entity.Booking> bs = repo.findByQuotaAndTrainNo(quota,train_no);
		int abks = 0;
		for(com.railways.entity.Booking a:bs) {
			abks+=a.getBookedseats();
		}
//		int abks = repo.TotalBookedSeats(train_no,quota);
		String res = "";
		if(quota.equals("GEN")) {
			int gen= ts.getGen()-abks;
			res = gen+" Seats Available in General Quota for this Train";
		}
		else if(quota.equals("TAQ")) {
			int taq = ts.getTaq()-abks;
			res = taq+" Seats Available in Tatkal Quota for this Train";
		}
		else if(quota.equals("LAD")) {
			int lad = ts.getLad()-abks;
			res = lad+" Seats Available in Ladies Quota for this Train";
		}
		return res;
	}
	

		
//	public List<Train> getTrainListByID(int id) {
//		System.out.println("TrainList - Service Implementation");
//		return null;
//	}
	
//	public List<EBBill> getEBList() {
//		System.out.println("StudentList - Service Implementation");
//		return dao.getEBList();
//	}
	
	@Override
	public String add(Booking platform) {
		com.railways.entity.Train obj = trainrepo.findByTrainNo(platform.getTrainNo());
		int ts = obj.getTotalSeats();
		if(platform.getQuota().equals("GEN")) {
			ts = obj.getGen();
		}
		else if(platform.getQuota().equals("TAQ")){
			ts = obj.getTaq();
		}
		else if (platform.getQuota().equals("LAD")) {
			ts = obj.getLad();
		}
		List<com.railways.entity.Booking> bs = repo.findByTrainNoAndQuota(platform.getTrainNo(), platform.getQuota());
		int abks = 0;
		for(com.railways.entity.Booking a:bs) {
			abks+=a.getBookedseats();
		}
		int cb = platform.getBookedseats();
		int a = cb+abks;
		String res = "";
		if(a<=ts) {
			int stleft = ts-a;
			System.out.println("Booked Successfully"+'\n'+"Seat Left = "+ stleft);
			com.railways.entity.Booking entity = new com.railways.entity.Booking(platform.getID(), platform.getTrainNo(),platform.getQuota(), platform.getBookedseats());
			repo.save(entity);
			res = "Booked Successfully " +'\n'+"Seat Left = "+ stleft;
		}
		else if(a>=ts) {
			int b = ts-abks;
			System.out.println("Seats not available"+'\n'+"Available Seats = "+b);
			res = "Seats not available"+'\n'+"Available Seats = "+b;
		}
		return res;
	}
	
	@Override
	public String update(int id, Booking platform) {
		com.railways.entity.Booking entity = new com.railways.entity.Booking(id,platform.getTrainNo(),platform.getQuota(), platform.getBookedseats());
		System.out.println("updating by id, "+entity);
		repo.save(entity);//update query
		String res = "";
		if(entity.getID()>0) {
			res = "Updated successfully & id is "+entity.getID();
		}else {
			res = "Error updating bill";
		}
		return res;
	}



}
