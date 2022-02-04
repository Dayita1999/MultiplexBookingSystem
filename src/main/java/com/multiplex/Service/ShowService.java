package com.multiplex.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.Model.Show;
import com.multiplex.Repository.MovieDAO;
import com.multiplex.Repository.ShowDAO;

@Service
public class ShowService implements IShowService{
	
	@Autowired
	private ShowDAO showDAO;
	
	@Autowired
	private MovieDAO movieDAO;

	public ShowService() {
		
	}
	@Override
	public Show addShowDetails(Long movieid, Show show) {
		return showDAO.save(show);

	}
	
}
	  
	  //This method is used to add the show details for a specific movie. A movie can have many shows related to it 
	 // so the movieid first specified whose show is to be added.
	
	