package com.multiplex.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.Exceptions.UserAlreadyExistsException;
import com.multiplex.Model.Movie;
import com.multiplex.Model.User;
import com.multiplex.Service.IMovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private IMovieService movieService;
	
	@PostMapping
public ResponseEntity<Movie> addMovieDetails(@Validated @RequestBody Movie movie){
		
		System.out.println(movie);
		Movie m = movieService.addMovieDetails(movie);
		return new ResponseEntity<Movie>(m,HttpStatus.OK);
	}
}