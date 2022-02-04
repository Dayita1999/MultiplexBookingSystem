package com.multiplex.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.Model.SeatType;
import com.multiplex.Service.ISeatTypeService;

@RestController
@RequestMapping("/seattype")
public class SeatTypeController {

	public SeatTypeController() {
	}
	
	@Autowired
	private ISeatTypeService seattypeService;
	
	@PostMapping("/hall/{hallid}/seattype")
	public ResponseEntity<SeatType> addSeatTypeDetails
	(@PathVariable("hallid")Long hallid,@RequestBody SeatType seattype){
		
		System.out.println(seattype);
		SeatType s = seattypeService.addSeatTypeDetails(hallid, seattype);
		return new ResponseEntity<SeatType>(s,HttpStatus.OK);
}
}