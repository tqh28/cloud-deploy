package com.example.cloud.service;

import java.util.List;

import com.example.cloud.constant.Gender;
import com.example.cloud.entity.Student;

public interface StudentService {

	List<Student> findAll();

	Student findById(long id);
	
	List<Student> findByGender(Gender gender);
}
