package com.multiplex.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="hall")
public class Hall implements Serializable {

	public Hall() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name="hallid")
	@NotNull(message="Please Enter Hall Id")	
	@Min(value = 1, message = "ID can't be zero or null")
	private long id;
	
	@Column(name="halldesc")
	@NotNull(message="Please Enter Hall Description")
	@NotEmpty(message="Please Enter Hall Description. Hall Description can not be blank.")
	private String halldesc;
	
	@Column(name="totalcapacity")
	@NotNull(message="Please Enter totalcapacity")
	@Min(value = 1, message = "capacity can't be zero or null")
	@Max(value = 250, message = "capacity can't exceed more than 250")
	private int totalcapacity;
	
	@Column(name="availableSeats")
	@NotNull(message="Please Enter seatcount")
	@Max(value = 250, message = "available Seats can't be more than totalcapacity")
	private int availableSeats;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "Show")
	private Show show;
	
	@OneToMany(mappedBy="hall",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<SeatType> seattype;

	

	public List<SeatType> getSeattype() {
		return seattype;
	}

	public void setSeattype(List<SeatType> seattype) {
		this.seattype = seattype;
	}

	public long getHallid() {
		return id;
	}

	public void setHallid(long hallid) {
		this.id = hallid;
	}

	public String getHalldesc() {
		return halldesc;
	}

	public void setHalldesc(String halldesc) {
		this.halldesc = halldesc;
	}

	public int getTotalcapacity() {
		return totalcapacity;
	}

	public void setTotalcapacity(int totalcapacity) {
		this.totalcapacity = totalcapacity;
	}

	
	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}
	@Override
	public String toString() {
		return "Hall [hallid=" + id + ", halldesc=" + halldesc + ", totalcapacity=" + totalcapacity + "]";
	}

	
}