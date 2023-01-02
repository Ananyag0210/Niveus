package com.example.demo.dto;

public class StudentDTO {
	
	private long id;
	private String studentName;
	private String branch;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", studentName=" + studentName + ", branch=" + branch + "]";
	}
	


}
