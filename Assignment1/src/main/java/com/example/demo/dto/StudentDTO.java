package com.example.demo.dto;

public class StudentDTO {
	
	private long id;
	private String student;
	private String branch;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", student=" + student + ", branch=" + branch + "]";
	}
	
	

}
