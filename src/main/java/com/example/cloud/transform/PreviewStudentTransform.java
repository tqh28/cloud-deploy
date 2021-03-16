package com.example.cloud.transform;

import com.example.cloud.dto.PreviewStudentDTO;
import com.example.cloud.entity.Student;

public class PreviewStudentTransform {

	public PreviewStudentDTO apply(Student core) {
		PreviewStudentDTO dto = new PreviewStudentDTO();
		dto.setId(core.getId());
		dto.setName(core.getName());
		dto.setGender(core.getGender());

		return dto;
	}
}
