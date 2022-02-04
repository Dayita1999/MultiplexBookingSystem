package com.multiplex.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.multiplex.Model.Hall;
import com.multiplex.Service.IHallService;

@RestController
@RequestMapping("/hall")
public class HallController {

	public HallController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	IHallService hallService;
	
	
	
	@PostMapping("/addhalldetails")
public ResponseEntity<Hall> addHallDetails(@Validated @RequestBody Hall hall) {
		
		System.out.println(hall);
		Hall h = hallService.addHallDetails(hall);
		return new ResponseEntity<Hall>(h,HttpStatus.OK);
}
}