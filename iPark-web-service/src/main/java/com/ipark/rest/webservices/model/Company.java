package com.ipark.rest.webservices.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="company")
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*@TableGenerator(name="Company_Gen", table = "IPARK_GEN", pkColumnName="GEN_NAME", 
			valueColumnName="GEN_VAL",pkColumnValue="Company_Gen",initialValue=100,allocationSize=1)
*/	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="name",nullable=false)
	private String name;
	@Column(name="address",nullable=false)
	private String address;
	@Column(name="message",nullable=false)
	private String message;
	@Column(name="currency",nullable=false)
	private String currency;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
