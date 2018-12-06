package com.ipark.rest.webservices.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "parking")
public class Parking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * @TableGenerator(name="Parking_Gen", table = "IPARK_GEN",
	 * pkColumnName="GEN_NAME",
	 * valueColumnName="GEN_VAL",pkColumnValue="Parking_Gen",initialValue=100,
	 * allocationSize=1)
	 */ @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "parking_code", nullable = false)
	private String parkingCode;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vehicle_cat_id", nullable = false)
	private VehicleCategory vehicleCategory;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id", nullable = false)
	private Vehicle vehicle;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rate_id", nullable = false)
	private Rate rate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "slot_id", nullable = false)
	private Slots slot;

	@Column(name = "in_time", nullable = false)
	private String inTime;

	@Column(name = "out_time")
	private String outTime;

	@Column(name = "total_time")
	private Long totalTime;
	@Column(name = "earned_amount")
	private String earnedAmount;

	@Column(name = "paid_status")
	private int paidStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParkingCode() {
		return parkingCode;
	}

	public void setParkingCode(String parkingCode) {
		this.parkingCode = parkingCode;
	}

	public VehicleCategory getVehicleCategory() {
		return vehicleCategory;
	}

	public void setVehicleCategory(VehicleCategory vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	public Rate getRate() {
		return rate;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}

	public Slots getSlot() {
		return slot;
	}

	public void setSlot(Slots slot) {
		this.slot = slot;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public Long getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Long totalTime) {
		this.totalTime = totalTime;
	}

	public String getEarnedAmount() {
		return earnedAmount;
	}

	public void setEarnedAmount(String earnedAmount) {
		this.earnedAmount = earnedAmount;
	}

	public int getPaidStatus() {
		return paidStatus;
	}

	public void setPaidStatus(int paidStatus) {
		this.paidStatus = paidStatus;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
