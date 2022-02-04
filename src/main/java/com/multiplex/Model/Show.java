package com.multiplex.Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="shows")
public class Show implements Serializable {

	public Show() {
	}
	
	

	@Id
	@GeneratedValue(generator = "show_seq")
	@SequenceGenerator(name="show_seq",sequenceName = "show_seq",allocationSize = 1)
	@Column(name="ShowId")
	private long id;
	
	@Column(name="SlotNo")
	@NotNull(message="Please Enter slotNo Id")	
	@Min(value = 1, message = "ID can't be zero or null")
	private long slotNo;
	
	@Column(name="ToDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="Please provide show toDate.")
	private String toDate;
	
	@Column(name="FromDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="Please provide show fromDate.")
	private String fromDate;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "MovieId")
	private Movie movie;
	
	
	 @OneToOne(mappedBy = "show",cascade = CascadeType.ALL)
	 @JsonIgnore
	 private Hall hall;
	   
	   
	 
	 
	 
	
	public Movie getMovie() {
		return movie;
	}

	

	public Hall getHall() {
		return hall;
	}



	public void setHall(Hall hall) {
		this.hall = hall;
	}



	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(long slotNo) {
		this.slotNo = slotNo;
	}

	public @NotNull String getToDate() {
		return toDate;
	}

	public void setToDate(@NotNull String toDate) {
		this.toDate = toDate;
	}

	public @NotNull String getFromDate() {
		return fromDate;
	}

	public void setFromDate(@NotNull String fromDate) {
		this.fromDate = fromDate;
	}
	@Override
	public String toString() {
		return "Show [showid=" + id + ", slotNo=" + slotNo + ", toDate=" + toDate + ", fromDate=" + fromDate + "]";
	}

}