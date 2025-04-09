package com.myArchitecture.Architecture.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myArchitecture.Architecture.Model.Student;
import com.myArchitecture.Architecture.Repositiory.StudentRepository;

@Service
public class StudentServiceImpl implements StudentServices {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

}
