package com.railways.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railways.pojo.Train;
import com.railways.repo.TrainRepo;
import com.railways.service.TrainService;

@Service
// business logic
public class TrainServiceImpl implements TrainService {
	
//	@Autowired
//	private railwaysDao dao;
	
	@Autowired
	private TrainRepo repo;

	public List<Train> getTrainList() {
		System.out.println("TrainList - Service Implementation");
		Iterable<com.railways.entity.Train> entites = repo.findAll();//retreives all the data
		List<Train> pojos = new ArrayList<>();
		for(com.railways.entity.Train platform : entites) {
			pojos.add(new Train(platform.getID(),platform.getTrainNo(),platform.getSource(),platform.getDestination(),platform.getGen(),platform.getTaq(),platform.getLad(),platform.getTotalSeats()));
		}
		return pojos;
	}

	@Override
	public Train getTrainListByNo(int train_no) {
		// TODO Auto-generated method stub
		com.railways.entity.Train entites = repo.findByTrainNo(train_no);//retreives all the data
		return new Train(entites.getID(),entites.getTrainNo(),entites.getSource(),entites.getDestination(),entites.getGen(),entites.getTaq(),entites.getLad(),entites.getTotalSeats());
	}
	
	@Override
	public List<Train> getTrainListBySRC(String source) {
		// TODO Auto-generated method stub
		Iterable<com.railways.entity.Train> entites = repo.findBySource(source);//retreives all the data
		List<Train> pojos = new ArrayList<>();
		for(com.railways.entity.Train platform : entites) {
			pojos.add(new Train(platform.getID(),platform.getTrainNo(),platform.getSource(),platform.getDestination(),platform.getGen(),platform.getTaq(),platform.getLad(),platform.getTotalSeats()));
		}
		return pojos;
	}
	
	@Override
	public List<Train> getTrainListByDes(String destination) {
		// TODO Auto-generated method stub
		Iterable<com.railways.entity.Train> entites = repo.findByDestination(destination);//retreives all the data
		List<Train> pojos = new ArrayList<>();
		for(com.railways.entity.Train platform : entites) {
			pojos.add(new Train(platform.getID(),platform.getTrainNo(),platform.getSource(),platform.getDestination(),platform.getGen(),platform.getTaq(),platform.getLad(),platform.getTotalSeats()));
		}
		return pojos;
	}
	
	@Override
	public List<Train> getTrainListBySRCDes(String source, String destination) {
		// TODO Auto-generated method stub
		Iterable<com.railways.entity.Train> entites = repo.findBySourceAndDestination(source,destination);//retreives all the data
		List<Train> pojos = new ArrayList<>();
		for(com.railways.entity.Train platform : entites) {
			pojos.add(new Train(platform.getID(),platform.getTrainNo(),platform.getSource(),platform.getDestination(),platform.getGen(),platform.getTaq(),platform.getLad(),platform.getTotalSeats()));
		}
		//changes check
		return pojos;
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
	public String add(Train platform) {
		com.railways.entity.Train entity = new com.railways.entity.Train(platform.getID(),platform.getTrainNo(),platform.getSource(),platform.getDestination(),platform.getGen(),platform.getTaq(),platform.getLad(),platform.getTotalSeats());
		repo.save(entity);
		String res = "";
		if(entity.getID()>0) {
			res = "Bill saved successfully & id is "+entity.getID();
		}else {
			res = "Error saving bill";
		}
		return res;
	}



}
