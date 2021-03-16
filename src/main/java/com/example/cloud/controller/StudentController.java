package com.example.cloud.controller;

import java.text.DateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud.dto.PreviewStudentDTO;
import com.example.cloud.dto.StudentDetailDTO;
import com.example.cloud.entity.Student;
import com.example.cloud.service.StudentService;
import com.example.cloud.transform.PreviewStudentTransform;
import com.example.cloud.transform.StudentDetailTransform;

@RestController
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;
	private DateFormat dateFormat;

	@Autowired
	public StudentController(StudentService studentService, DateFormat dateFormat) {
		this.studentService = studentService;
		this.dateFormat = dateFormat;
	}

	@GetMapping
	public List<PreviewStudentDTO> findAll() {
		List<Student> students = studentService.findAll();
		PreviewStudentTransform transform = new PreviewStudentTransform();
		List<PreviewStudentDTO> response = students.parallelStream().map(s -> transform.apply(s))
				.collect(Collectors.toList());
		return response;
	}

	@GetMapping("/{studentId}")
	public StudentDetailDTO getById(@PathVariable long studentId) {
		Student student = studentService.findById(studentId);
		StudentDetailTransform transform = new StudentDetailTransform(dateFormat);
		return transform.apply(student);
	}
}
