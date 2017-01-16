package com.kerpach.components.entity;

import java.io.Serializable;
import java.sql.Date;

public class Worker implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String fnameWorker;
	private String snameWorker;
	private String tnameWorker;
	private Date dateBirth;
	private Integer idPosition;
	private Integer idDepartment;
	
	public Worker(){}
	
	public Worker(String fnameWorker,String snameWorker,String tnameWorker, Date dateBirth,  Integer idPosition,Integer idDepartment){
		this.fnameWorker = fnameWorker;
		this.snameWorker = snameWorker;
		this.tnameWorker = tnameWorker;
		this.dateBirth = dateBirth;
		this.idPosition = idPosition;
		this.idDepartment = idDepartment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFnameWorker() {
		return fnameWorker;
	}

	public void setFnameWorker(String fnameWorker) {
		this.fnameWorker = fnameWorker;
	}

	public String getSnameWorker() {
		return snameWorker;
	}

	public void setSnameWorker(String snameWorker) {
		this.snameWorker = snameWorker;
	}

	public String getTnameWorker() {
		return tnameWorker;
	}

	public void setTnameWorker(String tnameWorker) {
		this.tnameWorker = tnameWorker;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Integer getIdPosition() {
		return idPosition;
	}

	public void setIdPosition(Integer idPosition) {
		this.idPosition = idPosition;
	}

	public Integer getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(Integer idDepartment) {
		this.idDepartment = idDepartment;
	}

	

}