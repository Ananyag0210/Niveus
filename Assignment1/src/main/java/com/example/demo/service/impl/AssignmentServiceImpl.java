package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.AssignmentService;

@Component
public class AssignmentServiceImpl implements AssignmentService{
	
	@Autowired  
	StudentRepo studentRepository;

	@Override
	public String addStudent(Student student) {
		try {
			studentRepository.save(student);  
			return "saved!!";
			
		} catch (Exception e) {
			System.out.println("ADD STUDENT | EXCEPTION FOUND | "+e);
			return null;
		}
		
	} 


	@Override
	public String updateStudent(Student student) {
		try {
			studentRepository.save(student);  
			return "updated!!";
			
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
	public String deletestudent(Long id) {
		try {
			studentRepository.deleteById(id); 
			return "deleted!!";
		} catch (Exception e) {
			System.out.println("DELETE STUDENT | EXCEPTION FOUND | "+ e);
			return null;
		}
		 
		
	}




}
