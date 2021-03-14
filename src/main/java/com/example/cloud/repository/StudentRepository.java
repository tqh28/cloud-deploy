package com.example.cloud.repository;

import java.util.List;

import com.example.cloud.constant.Gender;
import com.example.cloud.entity.Student;

public interface StudentRepository {

	List<Student> findAll();

	Student findById(long id);

	List<Student> findByGender(Gender gender);
}
