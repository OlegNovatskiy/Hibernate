package com.kerpach.components.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model class for position
 */

@Entity
@Table(name = "Positions")
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "title")
	private String titlePosition;
	@Column(name = "registration_code")
	private String regCodPosition;
	@Column(name = "salary")
	private Float salaryPosition;

	public Position() {
	}

	public Position(String titlePosition, String regCodPosition, Float salaryPosition) {
		this.titlePosition = titlePosition;
		this.regCodPosition = regCodPosition;
		this.salaryPosition = salaryPosition;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitlePosition() {
		return titlePosition;
	}

	public void setTitlePosition(String titlePosition) {
		this.titlePosition = titlePosition;
	}

	public String getRegCodPosition() {
		return regCodPosition;
	}

	public void setRegCodPosition(String regCodPosition) {
		this.regCodPosition = regCodPosition;
	}

	public Float getSalaryPosition() {
		return salaryPosition;
	}

	public void setSalaryPosition(Float salaryPosition) {
		this.salaryPosition = salaryPosition;
	}

}
