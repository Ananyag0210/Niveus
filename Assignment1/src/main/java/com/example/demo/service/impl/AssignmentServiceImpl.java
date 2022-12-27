package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.AssignmentService;
import com.example.demo.util.ServiceResponse;

@Component
public class AssignmentServiceImpl implements AssignmentService{
	
	@Autowired  
	StudentRepo studentRepository;

	@Override
	public ServiceResponse<StudentDTO> addStudent(StudentDTO student) {
		try {
				Student studentData = new Student();
				studentData.setStudent(student.getStudent());
				studentData.setBranch(student.getBranch());
				
				Student students = studentRepository.save(studentData);  
				
				student.setId(students.getId());
				student.setBranch(students.getBranch());
				student.setStudent(students.getStudent());
				return new ServiceResponse<>(HttpStatus.CREATED,"Added successfully", student);
			
		} catch (Exception e) {
			System.out.println("ADD STUDENT | EXCEPTION FOUND | "+e.getMessage());
			return new ServiceResponse<>(HttpStatus.INTERNAL_SERVER_ERROR,"Error Occurred", null);
		}
		
	} 


	@Override
	public ServiceResponse<StudentDTO> updateStudent(StudentDTO student) {
		try {
				Student studentData = new Student();
				studentData.setId(student.getId());
				studentData.setStudent(student.getStudent());
				studentData.setBranch(student.getBranch());
			
				Student students = studentRepository.save(studentData); 
				
				return new ServiceResponse<>(HttpStatus.CREATED,"Update successfully", student);
			
		} catch (Exception e) {
			System.out.println("UPDATE STUDENT | EXCEPTION FOUND | "+ e.getMessage());
			return new ServiceResponse<>(HttpStatus.INTERNAL_SERVER_ERROR,"Error Occurred", null);
		}
	} 
	
	
	@Override
	public ServiceResponse<List<StudentDTO>> getStudent() {
		try {

			List<StudentDTO> students = new ArrayList<>();  
			studentRepository.findAll().forEach((studentsData) -> {

			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setId(studentsData.getId());
			studentDTO.setBranch(studentsData.getBranch());
			studentDTO.setStudent(studentsData.getStudent());
			students.add(studentDTO);
			});
			return new ServiceResponse<>(HttpStatus.OK,"Student Details", students);
				
		} 
		catch (Exception e) {
			System.out.println("GET STUDENT | EXCEPTION FOUND | "+ e.getMessage());
			return new ServiceResponse<>(HttpStatus.INTERNAL_SERVER_ERROR,"Error Occurred", null);
		}	
	}


	@Override
	public ServiceResponse<StudentDTO> deleteStudent(Long id) {
		try {
				StudentDTO studentDTO = new StudentDTO();
				Student students = studentRepository.findById(id).orElse(null);
				
				if(students != null)
				{
					studentDTO.setId(students.getId());
					studentDTO.setBranch(students.getBranch());
					studentDTO.setStudent(students.getStudent());
					
					studentRepository.deleteById(id);
					
					return new ServiceResponse<>(HttpStatus.OK,"Student Deleted Successfully", studentDTO);
				}
				else
				{
					return new ServiceResponse<>(HttpStatus.BAD_REQUEST,"Invalid Id", null);
				}
				
		} catch (Exception e) {
			System.out.println("DELETE STUDENT | EXCEPTION FOUND | "+ e.getMessage());
			return new ServiceResponse<>(HttpStatus.INTERNAL_SERVER_ERROR,"Error Occurred", null);
		}
		 
		
	}




}
