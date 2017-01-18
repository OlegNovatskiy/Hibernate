package com.kerpach.components.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "Departments")
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "title")
	private String titleDepartmnet;
	@Column(name = "date_create")
	private Date dateCreate;
/*
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Worker", fetch = FetchType.LAZY)
	private List workers;
	
	public List getWorkers() {
		return workers;
	}

	public void setWorkers(List workers) {
		this.workers = workers;
	}
*/
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
