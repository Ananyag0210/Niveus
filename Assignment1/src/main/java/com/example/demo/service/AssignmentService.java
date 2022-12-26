package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;

@Service
public interface AssignmentService {

	public StudentDTO addStudent(Student student);
	public StudentDTO updateStudent(Student student);
	public StudentDTO deletestudent(Long id);
	public List<Student> getStudent();
	
	
}
