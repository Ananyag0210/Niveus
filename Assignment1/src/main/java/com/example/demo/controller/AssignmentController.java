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
	public ResponseEntity<Response> getStudent(@RequestParam("type")String type,@RequestParam("name")String name)   
	{  
		try {
				Response response;
				ServiceResponse<List<StudentDTO>> serviceResponse = assignmentService.getStudentByType(type,name);
				
				if(serviceResponse.getStatus() == HttpStatus.OK){
					response = new Response(serviceResponse.getStatus(),serviceResponse.getMessage(),serviceResponse.getT());
					return new ResponseEntity<>(response,serviceResponse.getStatus());
				} else {
					response = new Response(serviceResponse.getStatus(),serviceResponse.getMessage(),serviceResponse.getT());
					return new ResponseEntity<>(response,serviceResponse.getStatus());
				}
		} 
		catch (Exception e) {
			System.out.println("GET STUDENT | EXCEPTION | "+e);
			return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}  
	
	@DeleteMapping("/deleteStudent")  
	public ResponseEntity<Response> deleteBook(@RequestParam("studentId") Long studentId)   
	{  
		try {
				Response response;
				ServiceResponse<StudentDTO> serviceResponse = assignmentService.deleteStudent(studentId);	
				
				if(serviceResponse.getStatus() == HttpStatus.OK){
					response = new Response(serviceResponse.getStatus(),serviceResponse.getMessage(),serviceResponse.getT());
					return new ResponseEntity<>(response,serviceResponse.getStatus());
				} else {
					response = new Response(serviceResponse.getStatus(),serviceResponse.getMessage(),serviceResponse.getT());
					return new ResponseEntity<>(response,serviceResponse.getStatus());
				}
				
		} catch (Exception e) {
			System.out.println("DELETE BOOKS | EXCEPTION | "+e);
			return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}  
	
	@PostMapping("/addStudent")  
	public ResponseEntity<Response> addStudent(@RequestBody StudentDTO students)   
	{  
		try {
				Response response;
				ServiceResponse<StudentDTO> serviceResponse = assignmentService.addStudent(students);	 
				if(serviceResponse.getStatus() == HttpStatus.CREATED){
					response = new Response(serviceResponse.getStatus(),serviceResponse.getMessage(),serviceResponse.getT());
					return new ResponseEntity<>(response,serviceResponse.getStatus());
				} else {
					response = new Response(serviceResponse.getStatus(),serviceResponse.getMessage(),serviceResponse.getT());
					return new ResponseEntity<>(response,serviceResponse.getStatus());
				}
				
		} catch (Exception e) {
			System.out.println("ADD STUDENT | EXCEPTION | "+e);
			return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}  
	
	
	@PutMapping("/updateStudent")  
	public ResponseEntity<Response> update(@RequestBody StudentDTO students)   
	{  
		try {
				Response response;
				ServiceResponse<StudentDTO> serviceResponse = assignmentService.updateStudent(students); 
				if(serviceResponse.getStatus() == HttpStatus.OK) {
					response = new Response(serviceResponse.getStatus(),serviceResponse.getMessage(),serviceResponse.getT());
					return new ResponseEntity<>(response,serviceResponse.getStatus());
				} else {
					response = new Response(serviceResponse.getStatus(),serviceResponse.getMessage(),serviceResponse.getT());
					return new ResponseEntity<>(response,serviceResponse.getStatus());
				}
				
		} catch (Exception e) {
			System.out.println("UPDATE STUDENTS | EXCEPTION | "+e);
			return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 
		 
	}  

}
