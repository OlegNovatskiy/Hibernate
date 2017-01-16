package com.kerpach.components.entity.request;

import java.io.Serializable;
import java.sql.Date;

public class WorkerRequest implements Serializable{

private static final long serialVersionUID = 1L;
	
	private String fnameWorker;
	private String snameWorker;
	private String tnameWorker;
	private Date dateBirth;
	private Integer idPosition;
	private Integer idDepartment;

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
