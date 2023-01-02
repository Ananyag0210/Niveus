package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
	
	List<Student> findByStudentContainingIgnoreCase(String studentName);
	List<Student> findByBranchContainingIgnoreCase(String branchName);

}
