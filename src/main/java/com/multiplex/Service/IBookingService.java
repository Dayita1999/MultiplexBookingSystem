package com.multiplex.Service;

import java.util.Map;

import com.multiplex.Exceptions.UserNotFoundException;
import com.multiplex.Model.Booking;

public interface IBookingService {
	public Map<String,Boolean> addBookingDetails(Long movieid,Long showid,Long hallid,Long seattypeid, Booking booking, long userid, int count) throws UserNotFoundException;
}
