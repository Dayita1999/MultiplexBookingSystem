package com.multiplex.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.Model.Hall;
import com.multiplex.Repository.HallDAO;
import com.multiplex.Repository.MovieDAO;
import com.multiplex.Repository.ShowDAO;

@Service
public class HallService implements IHallService {
	
	@Autowired
	private HallDAO hallDAO;
	
	@Autowired
	private ShowDAO showDAO;
	
	@Autowired
	private MovieDAO movieDAO;
	
	
	//This method is used to add halls that are yet to be assigned any show.
	public HallService()  {
	}
	@Override
	public Hall addHallDetails(Hall hall){
		//Optional<Hall> optionalHall =  hallRepository.findById(hall.getHallid());
        
        return hallDAO.save(hall);
	}
}
