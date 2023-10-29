package com.railways.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.railways.entity.Train;

@Repository//to fetch from DB
public interface TrainRepo extends CrudRepository<Train, Integer>{	
	
	//select * from ebser where name=?
	public Train findByTrainNo(int train_no);
	public List<Train> findBySource(String source);
	public List<Train> findByDestination(String destination);
	public List<Train> findBySourceAndDestination(String source, String destination);
	//select * from ebser where name=? and bill_amt=?
//	public List<Customers> findByNameAndBillamt(String customername, String contactname, String address, String city, String postalcode, String country);
	
}
