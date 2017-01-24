package com.kerpach.components.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Workers")
//@Audited
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
	
	
	
	@OneToOne(mappedBy = "worker", cascade = CascadeType.ALL)
	@JoinColumn(name = "id_position")
	@JsonManagedReference
	private Position position;
	
	@ManyToOne
	@JoinColumn(name="id_department")
	@JsonBackReference
	private Department department;

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Worker(){}
	
	public Worker(String fnameWorker,String snameWorker,String tnameWorker, Date dateBirth){
		this.fnameWorker = fnameWorker;
		this.snameWorker = snameWorker;
		this.tnameWorker = tnameWorker;
		this.dateBirth = dateBirth;
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

}
