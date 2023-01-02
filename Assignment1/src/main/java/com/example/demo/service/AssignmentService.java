package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.util.ServiceResponse;

@Service
public interface AssignmentService {

	public ServiceResponse<StudentDTO> addStudent(StudentDTO student);
	public ServiceResponse<StudentDTO> updateStudent(StudentDTO student);
	
	public ServiceResponse<StudentDTO> deleteStudent(Long id);
	public ServiceResponse<List<StudentDTO>> getStudentByType(String type,String name);
	
	
}
