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
				studentData.setStudentName(student.getStudentName());
				studentData.setBranch(student.getBranch());
				
				Student students = studentRepository.save(studentData);  
				
				student.setId(students.getId());
				student.setBranch(students.getBranch());
				student.setStudentName(students.getStudentName());
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
				studentData.setStudentName(student.getStudentName());
				studentData.setBranch(student.getBranch());
				studentRepository.save(studentData); 
				
				return new ServiceResponse<>(HttpStatus.CREATED,"Update successfully", student);
			
		} catch (Exception e) {
			System.out.println("UPDATE STUDENT | EXCEPTION FOUND | "+ e.getMessage());
			return new ServiceResponse<>(HttpStatus.INTERNAL_SERVER_ERROR,"Error Occurred", null);
		}
	} 
	
	
	@Override
	public ServiceResponse<List<StudentDTO>> getStudentByType(String type,String name){
		try {

			List<StudentDTO> students = new ArrayList<>();  
			
//			studentRepository.findAll().forEach((studentsData) -> {
//			StudentDTO studentDTO = new StudentDTO();
//			studentDTO.setId(studentsData.getId());
//			studentDTO.setBranch(studentsData.getBranch());
//			studentDTO.setStudent(studentsData.getStudent());
//			System.out.println("GET STUDENT BY TYPE | STUDENT ID | "+studentsData.getId()+ " | STUDENT NAME | "+studentsData.getStudent()+" | STUDENT BRANCH | "+studentsData.getBranch());	
//			});
//			return new ServiceResponse<>(HttpStatus.OK,"Student Details", students);
				
			
			if(type.equalsIgnoreCase("STUDENT"))
			{
				studentRepository.findByStudentContainingIgnoreCase(name).forEach(studentsData -> 
				{
					StudentDTO studentDTO = new StudentDTO();
					studentDTO.setId(studentsData.getId());
					studentDTO.setBranch(studentsData.getBranch());
					studentDTO.setStudentName(studentsData.getStudentName());
					students.add(studentDTO);
				});
				
			}
			else if(type.equalsIgnoreCase("BRANCH"))
			{
				studentRepository.findByBranchContainingIgnoreCase(name).forEach(studentsData ->
				{
					StudentDTO studentDTO = new StudentDTO();
					studentDTO.setId(studentsData.getId());
					studentDTO.setBranch(studentsData.getBranch());
					studentDTO.setStudentName(studentsData.getStudentName());
					students.add(studentDTO);
				});
			}
			return new ServiceResponse<>(HttpStatus.OK,"Students Detail", students);
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
					studentDTO.setStudentName(students.getStudentName());
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
