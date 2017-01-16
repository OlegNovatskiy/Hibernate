package com.kerpach.components.entity.request;

public class PositionRequest implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private String titlePosition;
	private String regCodPosition;
	private Float salaryPosition;

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
