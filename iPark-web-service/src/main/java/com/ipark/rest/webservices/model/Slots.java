package com.ipark.rest.webservices.model;

import java.io.Serializable;

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
@Table(name="slots")
public class Slots implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*@TableGenerator(name="Slots_Gen", table = "IPARK_GEN", pkColumnName="GEN_NAME", 
			valueColumnName="GEN_VAL",pkColumnValue="Slots_Gen",initialValue=100,allocationSize=1)
*/	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private Integer id;
	 
	 @Column(name="slot_name",nullable=false)
	 private String slotName;
	 
	 @Column(name="active",nullable=false)
	 private int active;
	 
	 @Column(name="availability_status",nullable=false)
	 private int availabilityStatus;

	 @Column(name="is_reserved_parking",nullable=false)
	 private int isReservedParking;
	 
	 @Column(name="is_visitor_parking")
	 private int isVisitorParking;
	 
	 @ManyToOne(fetch=FetchType.EAGER)
	 @JoinColumn(name="parking_area")
	 private ParkingArea parkingArea;
	 
	 @Column(name="is_small_parking")
	 private int isSmallParking;
	 
	 @Column(name="distance_from_building")
	 private int distanceFromBuilding;
	 
	 @Column(name="longitude")
	 private String longitude;
	 
	 @Column(name="latitude")
	 private String latitude;
	 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(int availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	public int getIsReservedParking() {
		return isReservedParking;
	}

	public void setIsReservedParking(int isReservedParking) {
		this.isReservedParking = isReservedParking;
	}

	public int getIsVisitorParking() {
		return isVisitorParking;
	}

	public void setIsVisitorParking(int isVisitorParking) {
		this.isVisitorParking = isVisitorParking;
	}

	public ParkingArea getParkingArea() {
		return parkingArea;
	}

	public void setParkingArea(ParkingArea parkingArea) {
		this.parkingArea = parkingArea;
	}

	public int getIsSmallParking() {
		return isSmallParking;
	}

	public void setIsSmallParking(int isSmallParking) {
		this.isSmallParking = isSmallParking;
	}

	public int getDistanceFromBuilding() {
		return distanceFromBuilding;
	}

	public void setDistanceFromBuilding(int distanceFromBuilding) {
		this.distanceFromBuilding = distanceFromBuilding;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	 
	 
	
}
