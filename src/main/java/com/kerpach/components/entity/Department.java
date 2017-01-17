package com.kerpach.components.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
