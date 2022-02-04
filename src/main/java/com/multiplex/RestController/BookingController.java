package com.multiplex.RestController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.Exceptions.UserNotFoundException;
import com.multiplex.Model.Booking;
import com.multiplex.Model.User;
import com.multiplex.Service.IBookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	public BookingController() {
	}
	
	@Autowired
	private IBookingService bookingService;
	@PostMapping("/movie/{movieid}/show/{showid}/hall/{hallid}/seattype/{seattypeid}/booking")
	public Map<String,Boolean> addBookingDetails(@PathVariable("movieid") Long movieid,@PathVariable("showid") Long showid,
			@PathVariable("hallid") Long hallid, @PathVariable("seattypeid") Long seattypeid,@RequestBody Booking booking,@RequestParam(name="userid") Long userid,
			@RequestParam(name="count") int count) throws UserNotFoundException{
		
		return bookingService.addBookingDetails(movieid, showid, hallid, seattypeid, booking, userid, count);
	
		}
}