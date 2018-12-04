package com.ipark.rest.webservices.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*@TableGenerator(name="User_Gen", table = "IPARK_GEN", pkColumnName="GEN_NAME", 
			valueColumnName="GEN_VAL",pkColumnValue="User_Gen",initialValue=100,allocationSize=1)
	*/@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="username",nullable=false)
	private String userName;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="email",nullable=false)
	private String email;
	
	@Column(name="firstname",nullable=false)
	private String firstName;
	
	@Column(name="lastname",nullable=false)
	private String lastName;
	
	@Column(name="phone",nullable=false)
	private String phone;
	
	@Column(name="gender",nullable=false)
	private int gender;
	@Column(name="device_id")
	private String deviceId;
	
	@Column(name="arn")
	private String arn;
	
	@Column(name="isadmin")
	private int isAdmin;
	
	@OneToOne
	@JoinColumn(name="preferred_parking_area_id")
	private ParkingArea parkingArea;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getArn() {
		return arn;
	}

	public void setArn(String arn) {
		this.arn = arn;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public ParkingArea getParkingArea() {
		return parkingArea;
	}

	public void setParkingArea(ParkingArea parkingArea) {
		this.parkingArea = parkingArea;
	}
	
}
