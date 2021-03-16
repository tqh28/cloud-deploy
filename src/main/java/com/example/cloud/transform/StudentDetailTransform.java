package com.example.cloud.transform;

import java.text.DateFormat;

import com.example.cloud.dto.StudentDetailDTO;
import com.example.cloud.entity.Student;

public class StudentDetailTransform {

	private DateFormat dateFormat;

	public StudentDetailTransform(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	public StudentDetailDTO apply(Student core) {
		StudentDetailDTO dto = new StudentDetailDTO();
		dto.setId(core.getId());
		dto.setName(core.getName());
		dto.setGender(core.getGender());
		dto.setIdentityNumber(core.getIdentityNumber());
		dto.setDob(dateFormat.format(core.getDob()));

		return dto;
	}
}
