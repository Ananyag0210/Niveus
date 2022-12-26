package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.AssignmentService;

@Component
public class AssignmentServiceImpl implements AssignmentService{
	
	@Autowired  
	StudentRepo studentRepository;

	@Override
	public StudentDTO addStudent(Student student) {
		try {
				Student students = studentRepository.save(student);  
				StudentDTO studentDTO = new StudentDTO();
				studentDTO.setId(students.getId());
				studentDTO.setBranch(students.getBranch());
				studentDTO.setStudent(students.getStudent());
				return studentDTO;
			
		} catch (Exception e) {
			System.out.println("ADD STUDENT | EXCEPTION FOUND | "+e);
			return null;
		}
		
	} 


	@Override
	public StudentDTO updateStudent(Student student) {
		try {
				Student students = studentRepository.save(student); 
				StudentDTO studentDTO = new StudentDTO();
				studentDTO.setId(students.getId());
				studentDTO.setBranch(students.getBranch());
				studentDTO.setStudent(students.getStudent());
				return studentDTO;
			
		} catch (Exception e) {
			System.out.println("UPDATE STUDENT | EXCEPTION FOUND | "+ e);
			return null;
		}
	} 
	
	
	@Override
	public List<Student> getStudent() {
		try {
				List<Student> students = new ArrayList<Student>();  
				studentRepository.findAll().forEach(students1 -> students.add(students1));  
				return students;
		} 
		catch (Exception e) {
			System.out.println("GET STUDENT | EXCEPTION FOUND | "+ e);
			return null;
		}	
	}


	@Override
	public StudentDTO deletestudent(Long id) {
		try {
				StudentDTO studentDTO = new StudentDTO();
				Student students = studentRepository.findById(id).orElse(null);
				studentDTO.setId(students.getId());
				studentDTO.setBranch(students.getBranch());
				studentDTO.setStudent(students.getStudent());
				
				studentRepository.deleteById(id); 
				return studentDTO;
			
				
		} catch (Exception e) {
			System.out.println("DELETE STUDENT | EXCEPTION FOUND | "+ e);
			return null;
		}
		 
		
	}




}
