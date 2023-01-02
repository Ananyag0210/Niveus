package com.example.demo;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;

@SpringBootTest
class Assignment1ApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	StudentRepo studentRepo;
	
	@Test
	@Order(1)
	public void addStudent()
	{
		Student student = new Student();
		student.setBranch("Electronics");
		student.setStudent("Ram");
		studentRepo.save(student);
		
		Assertions.assertThat(student.getId());
	}
	
	@Test
	@Order(2)
	public void getStudentTest() {
		List<Student> students = studentRepo.findAll();
		Assertions.assertThat(students.size()).isEqualTo(1L);
		
	}
	
	@Test
	@Order(3)
	@Rollback(value = false)
	public void updateStudent()
	{
		Student student = studentRepo.findById(7L).orElse(null);
		student.setBranch("Machine Learning");
		Student updatedStudent = studentRepo.save(student);
		
		Assertions.assertThat(updatedStudent.getBranch()).isEqualTo("Machine Learning");
	}
	
	@Test
	@Order(4)
	public void deleteStudent()
	{
		Student student = studentRepo.findById(14L).orElse(null);
		if(student != null)
		{
			studentRepo.deleteById(14L);	
		}
		Assertions.assertThat(student.getId()).isEqualTo(14L);
	}
}
