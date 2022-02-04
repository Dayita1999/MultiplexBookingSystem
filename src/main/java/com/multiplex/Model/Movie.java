package com.multiplex.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="movie")
public class Movie implements Serializable{
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="MovieId",updatable=false)
	//@NotNull(message="Please Enter Movie Id")	
	//@Min(value = 1, message = "ID can't be zero or null")
	private long id;
	
	@Column(name="moviename")
	//@NotNull(message="Please Enter Movie Name")
	//@NotEmpty(message="Please Enter Movie Name. Name can not be blank.")
	private String movieName;
	
	@Column(name="moviedesc")
	//@NotNull(message="Please Enter Movie Description")
	//@NotEmpty(message="Please Enter Movie Description. Description can not be blank.")
	private String movieDescription;
	
	@OneToMany(mappedBy = "movie", cascade = {CascadeType.ALL})
	 @JsonIgnore
	 private List<Show> show;
	 
	 

	/*public List<Show> getShow() {
		return show;
	}

	public void setShow(List<Show> show) {
		this.show = show;
	}*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", movieDescription=" + movieDescription + "]";
	}
	
	
	

	

}
