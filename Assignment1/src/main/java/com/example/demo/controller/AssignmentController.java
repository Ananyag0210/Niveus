package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDTO;
import com.example.demo.service.AssignmentService;
import com.example.demo.util.Response;
import com.example.demo.util.ServiceResponse;

@RestController  
@RequestMapping(path = "/api/student")
public class AssignmentController {

	@Autowired  
	AssignmentService assignmentService;  
	
	@GetMapping("/getStudent")  
	private ResponseEntity<Response> getStudent()   
	{  
		try {
				Response response;
				ServiceResponse<List<StudentDTO>> serivceResponse = assignmentService.getStudent();
				
				if(serivceResponse.getStatus() == HttpStatus.OK)
				{
					response = new Response(serivceResponse.getStatus(),serivceResponse.getMessage(),serivceResponse.getT());
					return new ResponseEntity<>(response,serivceResponse.getStatus());
				}
				else {
					response = new Response(serivceResponse.getStatus(),serivceResponse.getMessage(),serivceResponse.getT());
					return new ResponseEntity<>(response,serivceResponse.getStatus());
				}
		} 
		catch (Exception e) {
			System.out.println("GET STUDENT | EXCEPTION | "+e);
			return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}  
	
	@DeleteMapping("/deleteStudent")  
	private ResponseEntity<Response> deleteBook(@RequestParam("studentId") Long studentId)   
	{  
		try {
				Response response;
				ServiceResponse<StudentDTO> serivceResponse = assignmentService.deleteStudent(studentId);	
				
				if(serivceResponse.getStatus() == HttpStatus.OK)
				{
					response = new Response(serivceResponse.getStatus(),serivceResponse.getMessage(),serivceResponse.getT());
					return new ResponseEntity<>(response,serivceResponse.getStatus());
				}
				else {
					response = new Response(serivceResponse.getStatus(),serivceResponse.getMessage(),serivceResponse.getT());
					return new ResponseEntity<>(response,serivceResponse.getStatus());
				}
				
		} catch (Exception e) {
			System.out.println("DELETE BOOKS | EXCEPTION | "+e);
			return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}  
	
	@PostMapping("/addStudent")  
	private ResponseEntity<Response> addStudent(@RequestBody StudentDTO students)   
	{  
		try {
				Response response;
				ServiceResponse<StudentDTO> serivceResponse = assignmentService.addStudent(students);	 
				if(serivceResponse.getStatus() == HttpStatus.CREATED)
				{
					response = new Response(serivceResponse.getStatus(),serivceResponse.getMessage(),serivceResponse.getT());
					return new ResponseEntity<>(response,serivceResponse.getStatus());
				}
				else {
					response = new Response(serivceResponse.getStatus(),serivceResponse.getMessage(),serivceResponse.getT());
					return new ResponseEntity<>(response,serivceResponse.getStatus());
				}
				
		} catch (Exception e) {
			System.out.println("ADD STUDENT | EXCEPTION | "+e);
			return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}  
	
	
	@PutMapping("/updateStudent")  
	private ResponseEntity<Response> update(@RequestBody StudentDTO students)   
	{  
		try {
				Response response;
				ServiceResponse<StudentDTO> serivceResponse = assignmentService.updateStudent(students); 
				if(serivceResponse.getStatus() == HttpStatus.OK)
				{
					response = new Response(serivceResponse.getStatus(),serivceResponse.getMessage(),serivceResponse.getT());
					return new ResponseEntity<>(response,serivceResponse.getStatus());
				}
				else {
					response = new Response(serivceResponse.getStatus(),serivceResponse.getMessage(),serivceResponse.getT());
					return new ResponseEntity<>(response,serivceResponse.getStatus());
				}
				
		} catch (Exception e) {
			System.out.println("UPDATE STUDENTS | EXCEPTION | "+e);
			return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 
		 
	}  

}
