package com.railways.service;

import java.util.List;

import com.railways.pojo.Train;

public interface TrainService {
	
	public List<Train> getTrainList();
	public Train getTrainListByNo(int train_no);
	public List<Train> getTrainListBySRC(String source);
	public List<Train> getTrainListByDes(String destination);
	public List<Train> getTrainListBySRCDes(String source, String destination);
	public String add(Train platform);
//	public String update(int customerid,Customers bill);
//	public String delete(int customerid);
}
