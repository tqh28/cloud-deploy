package com.example.cloud.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cloud.constant.Gender;
import com.example.cloud.entity.Student;
import com.example.cloud.repository.StudentRepository;
import com.example.cloud.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(long id) {
		return studentRepository.findById(id);
	}

	@Override
	public List<Student> findByGender(Gender gender) {
		return studentRepository.findByGender(gender);
	}

}
