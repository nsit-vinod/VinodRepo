package com.ipark.rest.webservices.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="rate")
public class Rate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*@TableGenerator(name="Rate_Gen", table = "IPARK_GEN", pkColumnName="GEN_NAME", 
			valueColumnName="GEN_VAL",pkColumnValue="Rate_Gen",initialValue=100,allocationSize=1)
*/	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="rate_name", nullable=false)
	private String rateName;
	
	@OneToOne
	@JoinColumn(name="vechile_cat_id", nullable=false)
	private VehicleCategory vehicleCategory;
	
	@Column(name="type", nullable=false)
	private int type;
	@Column(name="rate", nullable=false)
	private String rate;
	
	@Column(name="active", nullable=false)
	private int active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRateName() {
		return rateName;
	}

	public void setRateName(String rateName) {
		this.rateName = rateName;
	}

	public VehicleCategory getVehicleCategory() {
		return vehicleCategory;
	}

	public void setVehicleCategory(VehicleCategory vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
	
}
