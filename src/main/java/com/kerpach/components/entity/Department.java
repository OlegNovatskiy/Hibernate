package com.kerpach.components.entity;

import java.io.Serializable;
import java.sql.Date;

public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titleDepartmnet;
	private Date dateCreate;

	public Department() {
	}

	public Department(String titleDepartmnet, Date dateCreate) {
		this.titleDepartmnet = titleDepartmnet;
		this.dateCreate = dateCreate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitleDepartmnet() {
		return titleDepartmnet;
	}

	public void setTitleDepartmnet(String titleDepartmnet) {
		this.titleDepartmnet = titleDepartmnet;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

}
