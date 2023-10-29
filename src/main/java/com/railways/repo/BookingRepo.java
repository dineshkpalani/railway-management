package com.railways.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.railways.entity.Booking;

@Repository//to fetch from DB
public interface BookingRepo extends CrudRepository<Booking, Integer>{	
	
	//select * from ebser where name=?
	public List<Booking> findAll();
	public List<Booking> findByTrainNo(int trainno);
	public List<Booking> findByTrainNoAndQuota(int trainno, String quota);
	public List<Booking> findByQuotaAndTrainNo(String quota, int trainno);
//	@Query("select sum(bookedseats) from Booking where trainNo = ?1 and quota = ?2")
//	public Integer TotalBookedSeats(Integer trainno, String quota);
//	public List<Booking> findByAvailability(int train_no);
//	public List<Train> findBySourceAndDestination(String source, String destination);
	//select * from ebser where name=? and bill_amt=?
//	public List<Customers> findByNameAndBillamt(String customername, String contactname, String address, String city, String postalcode, String country);
	
}
