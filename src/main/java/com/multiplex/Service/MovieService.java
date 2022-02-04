package com.multiplex.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.Model.Movie;
import com.multiplex.Repository.MovieDAO;

@Service
public class MovieService implements IMovieService {
	
	@Autowired
	private MovieDAO movieDAO;

	public MovieService() {
		
	}
	@Override
	public Movie addMovieDetails(Movie movie)  {
		//Optional<Movie> optionalMovie = movieDAO.findById(movie.getId());
		
		return movieDAO.save(movie);		
	}
}
