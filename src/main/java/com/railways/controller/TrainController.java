package com.railways.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.railways.pojo.Train;
import com.railways.service.TrainService;

@RestController
@RequestMapping("/train")//handles base request
public class TrainController {
	
	@Autowired// object create & inject
	private TrainService service;
	
	@GetMapping("/list")
	public List<Train> listTrain() {
		System.out.println("Trains Controller");
		return service.getTrainList();
	}
	
	@GetMapping("/listByNo/{train_no}")//read
	public Train listTrainByNo(@PathVariable int train_no) {
		System.out.println("Train list by number = "+train_no);
		return service.getTrainListByNo(train_no);
	}
	
	@GetMapping("/listBySRC/{source}")//read
	public List<Train> listTrainBySRC(@PathVariable String source) {
		System.out.println("Train list by Source = "+source);
		return service.getTrainListBySRC(source);
	}	
	
	@GetMapping("/listByDes/{destination}")//read
	public List<Train> listTrainByDes(@PathVariable String destination) {
		System.out.println("Train list by Destination = "+destination);
		return service.getTrainListByDes(destination);
	}
	
	@GetMapping("/list/{source}/{destination}")//read
	public List<Train> listTrainBySRCDes(@PathVariable String source, @PathVariable String destination) {
		System.out.println("Train list by Source and Destination = "+source+destination);
		return service.getTrainListBySRCDes(source,destination);
	}
	
	@PostMapping("/add")//create
//	RequestBody used in Post/Put
	public String add(@RequestBody Train platform) {
		return service.add(platform);
	}

//	@PutMapping("/update/{id}")//update
//	public String update(@PathVariable int id,@RequestBody Customers bill) {
//		return service.update(id,bill);
//	}
	
//	@DeleteMapping("/delete/{id}")//delete
//	public String delete(@PathVariable int id) {
//		return service.delete(id);
//	}
	
}
