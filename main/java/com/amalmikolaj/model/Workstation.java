package com.amalmikolaj.model;

import java.util.Date;

public class Workstation {
	
	private int id;
	private String brand;
	private String model;
	private String tag;
	private String studentName;
	private String studentSurname;
	private String course;
	private boolean cheque;
	private String returnComment;
	private Date dateOfBorrow;
	
	public Workstation() {
		
	}
	
	public Workstation(int id, String brand, String model, String tag, String studentName, String studentSurname, String course, Date dateOfBorrow, boolean cheque, String returnComment) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.tag = tag;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.course = course;
		this.cheque = cheque;
		this.returnComment = returnComment;
		this.dateOfBorrow = dateOfBorrow;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSurname() {
		return studentSurname;
	}

	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public boolean isCheque() {
		return cheque;
	}

	public void setCheque(boolean cheque) {
		this.cheque = cheque;
	}

	public String getReturnComment() {
		return returnComment;
	}

	public void setReturnComment(String returnComment) {
		this.returnComment = returnComment;
	}

	public Date getDateOfBorrow() {
		return dateOfBorrow;
	}

	public void setDateOfBorrow(Date dateOfBorrow) {
		this.dateOfBorrow = dateOfBorrow;
	}

	@Override
	public String toString() {
		return "\nWorkstation [id=" + id + ", brand=" + brand + ", model=" + model + ", tag=" + tag + ", studentName="
				+ studentName + ", studentSurname=" + studentSurname + ", course=" + course + ", cheque=" + cheque
				+ ", returnComment=" + returnComment + ", dateOfBorrow=" + dateOfBorrow + "]";
	}
	
}
