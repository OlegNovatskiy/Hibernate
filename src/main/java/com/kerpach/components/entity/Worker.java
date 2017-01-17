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
@Table(name="Workers")
public class Worker implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "fname")
	private String fnameWorker;
	@Column(name = "sname")
	private String snameWorker;
	@Column(name = "tname")
	private String tnameWorker;
	@Column(name = "date_birth")
	private Date dateBirth;
	@Column(name = "id_position")
	private Integer idPosition;
	@Column(name = "id_department")
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
