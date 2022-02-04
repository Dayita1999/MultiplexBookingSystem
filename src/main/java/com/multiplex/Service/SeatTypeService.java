package com.multiplex.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.Model.SeatType;
import com.multiplex.Repository.HallDAO;
import com.multiplex.Repository.SeatTypeDAO;

@Service
public class SeatTypeService implements ISeatTypeService {

	public SeatTypeService() {
		
	}
	
	@Autowired
	private SeatTypeDAO seattypeDAO;
	@Autowired
	private HallDAO hallDAO;
	
	//This method is used to add the details of a specific seat type that is assigned to a particular hall id.
	//It takes the object of Seat type as input and saves it in the DB.
	@Override
	public SeatType addSeatTypeDetails(Long hallid, SeatType seattype) {
		return seattypeDAO.save(seattype);
	}
	
}
	

	
	
	