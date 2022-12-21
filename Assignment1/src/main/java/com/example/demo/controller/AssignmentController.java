package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.AssignmentService;

@RestController  
@RequestMapping(path = "/api/student")
public class AssignmentController {

	@Autowired  
	AssignmentService assignmentService;  
	
	@GetMapping("/get_student")  
	private List<Student> getAllBooks()   
	{  
		try {
				return assignmentService.getStudent();	
		} 
		catch (Exception e) {
			System.out.println("GET STUDENT | EXCEPTION | "+e);
			return null;
		}		
	}  
	
	@DeleteMapping("/delete_student")  
	private String deleteBook(@RequestParam("studentId") Long studentId)   
	{  
		try {
			 return	assignmentService.deletestudent(studentId);	
		} catch (Exception e) {
			System.out.println("DELETE BOOKS | EXCEPTION | "+e);
			return null;
		}
		
	}  
	
	@PostMapping("/add_student")  
	private String addStudent(@RequestBody Student students)   
	{  
		try {
				return assignmentService.addStudent(students);	 
				
		} catch (Exception e) {
			System.out.println("ADD STUDENT | EXCEPTION | "+e);
			return null;
		}
		
	}  
	
	
	@PutMapping("/update_student")  
	private String update(@RequestBody Student students)   
	{  
		try {
			return assignmentService.updateStudent(students); 
			
		} catch (Exception e) {
			System.out.println("UPDATE STUDENTS | EXCEPTION | "+e);
			return null;
		}
	 
		 
	}  

}
