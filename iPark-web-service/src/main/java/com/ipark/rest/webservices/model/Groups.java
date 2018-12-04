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
@Table(name = "u_groups")
public class Groups implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * @TableGenerator(name="Groups_Gen", table = "IPARK_GEN",
	 * pkColumnName="GEN_NAME",
	 * valueColumnName="GEN_VAL",pkColumnValue="Groups_Gen",initialValue=100,
	 * allocationSize=1)
	 */ @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "group_name", nullable = false)
	private String groupName;

	@Column(name = "permission", nullable = false)
	private String permission;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}
