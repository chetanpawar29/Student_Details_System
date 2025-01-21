package com.chetan.entities;

import javax.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Student_Details")
@Component
public class Student {
	
	@Id
	private int stdId;
	private String stdName;
	private String stdCity;
	
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdCity() {
		return stdCity;
	}
	public void setStdCity(String stdCity) {
		this.stdCity = stdCity;
	}
	
	public Student(int stdId, String stdName, String stdCity) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdCity = stdCity;
	}
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
