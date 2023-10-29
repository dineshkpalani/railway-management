package com.railways.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.railways.pojo.Booking;
import com.railways.pojo.Train;
import com.railways.service.BookingService;

@RestController
@RequestMapping("/booking")//handles base request
public class BookingController {
	
	@Autowired// object create & inject
	private BookingService service;
	
	@GetMapping("/list")
	public List<Booking> listBooking() {
		System.out.println("Booking Controller");
		return service.getBookingList();
	}
	
	@GetMapping("/seat_availability/{train_no}")
	public String listBookingByAvailability(@PathVariable int train_no) {
		System.out.println("Booking list by Seat Availability = "+train_no);
		return service.getTrainListByAvailability(train_no);
	}
	
	@GetMapping("/seat_availability/{quota}/{train_no}")
	public String listBookingByQuota(@PathVariable String quota, @PathVariable int train_no) {
		System.out.println("Booking list by Seat Availability = "+train_no);
		return service.getTrainListByQuota(quota, train_no);
	}
	
	@PostMapping("")
	public String add(@RequestBody Booking platform) {
		return service.add(platform);
	}

	@PutMapping("/update/{id}")//update
	public String update(@PathVariable int id,@RequestBody Booking platform) {
		return service.update(id,platform);
	}
	
//	@DeleteMapping("/delete/{id}")//delete
//	public String delete(@PathVariable int id) {
//		return service.delete(id);
//	}
	
}
