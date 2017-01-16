package com.kerpach.components.entity.request;

import java.io.Serializable;
import java.sql.Date;

public class DepartmentRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String titleDepartmnet;
	private Date dateCreate;

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
