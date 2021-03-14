package com.example.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud.constant.Gender;
import com.example.cloud.entity.Student;
import com.example.cloud.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public List<Student> findAll() {
		return studentService.findByGender(Gender.MALE);
	}
	
	@GetMapping("/{studentId}")
	public Student getById(@PathVariable long studentId) {
		return studentService.findById(studentId);
	}
}
