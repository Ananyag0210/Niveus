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

//	@Test
//	void contextLoads() {
//	}
	@Autowired
	StudentRepo studentRepo;
	
	@Test
	@Order(1)
	void addStudent()
	{
		Student student = new Student();
		student.setBranch("Electronics");
		student.setStudentName("Sita");
		studentRepo.save(student);
		
		Assertions.assertThat(student.getId());
	}
	
	@Test
	@Order(2)
	void getStudentTest() {
		List<Student> students = studentRepo.findAll();
		Assertions.assertThat(students.size()).isGreaterThan(0);
		
	}
	
	@Test
	@Order(3)
	@Rollback(value = false)
	void updateStudent()
	{
		Student student = studentRepo.findById(10L).orElse(null);
		student.setBranch("Machine Learning");
		Student updatedStudent = studentRepo.save(student);
		
		Assertions.assertThat(updatedStudent.getBranch()).isEqualTo("Machine Learning");
	}
	
	@Test
	@Order(4)
	void deleteStudent()
	{
		Student student = studentRepo.findById(17L).orElse(null);
		if(student != null)
		{
			studentRepo.deleteById(17L);	
		}
		Assertions.assertThat(student.getId()).isEqualTo(17L);
	}
}
