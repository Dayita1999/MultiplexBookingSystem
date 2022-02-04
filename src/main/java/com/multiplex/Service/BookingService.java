package com.multiplex.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.Exceptions.UserNotFoundException;
import com.multiplex.Model.Booking;
import com.multiplex.Repository.BookingDAO;
import com.multiplex.Repository.HallDAO;
import com.multiplex.Repository.MovieDAO;
import com.multiplex.Repository.SeatTypeDAO;
import com.multiplex.Repository.ShowDAO;
import com.multiplex.Repository.UserDAO;

@Service
public class BookingService implements IBookingService{

	@Autowired
	private MovieDAO movieDAO;
	@Autowired
	private ShowDAO showDAO;
	@Autowired
	private HallDAO hallDAO;
	@Autowired 
	private SeatTypeDAO seattypeDAO; 
	@Autowired 
	private UserDAO userDAO;
	@Autowired
	private BookingDAO bookingDAO;
	@Autowired
	HallService hallService;
	
	public BookingService() {
		
	}
	@Override
	public Map<String,Boolean> addBookingDetails(Long movieid,Long showid,Long hallid,Long seattypeid, Booking booking,long userid, int count) throws UserNotFoundException {
		Map<String,Boolean> response = new HashMap<>();
		{
		
		if(!userDAO.existsById(userid)) {
			throw new UserNotFoundException("Sorry the user with user id: "+userid+"is not found..!! Please register yourself or login");
		}
	

		bookingDAO.save(booking);
		return response;
	}
}
}