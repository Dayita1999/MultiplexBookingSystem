package com.multiplex.Model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="booking")
public class Booking implements Serializable {
	@Id
    @GeneratedValue(generator = "booking_seq")
	@SequenceGenerator(name="booking_seq",sequenceName = "booking_seq",allocationSize = 1)
	@Column(name="bookingid")
	private long bookingId;
	
	@Column(name = "bookeddate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "dd-MM-yyyy HH:mm:ss")
	@NotNull
    private Calendar createdDate;
	
	 
	@Column(name="showdate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="Please provide show Date.")
	private String showdate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hallid")
	//@JsonIgnore
    private Hall hall;
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "seattypeid")
	//@JsonIgnore
	private List<SeatType> seattype;
	 
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "showid")
	//@JsonIgnore
    private Show show;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	//@JsonIgnore
	private User user;
	


	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public List<SeatType> getSeattype() {
		return seattype;
	}

	public void setSeattype(List<SeatType> seattype) {
		this.seattype = seattype;
	}

	public String getShowdate() {
		return showdate;
	}

	public void setShowdate(String showdate) {
		this.showdate = showdate;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}