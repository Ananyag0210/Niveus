package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;

@Service
public interface AssignmentService {

	public String addStudent(Student student);
	public String updateStudent(Student student);
	public String deletestudent(Long id);
	public List<Student> getStudent();
	
	
}
