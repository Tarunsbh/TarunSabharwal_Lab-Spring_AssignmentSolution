package com.studentsecurity.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentsecurity.app.entity.Student;
import com.studentsecurity.app.studentRepository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	public StudentRepository sdata;

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		List<Student> Students = sdata.findAll();
		return Students;
	}

	@Override
	public Student findById(int sId) {
		// TODO Auto-generated method stub
		Optional<Student> student;
		student = sdata.findById(sId);
		return student.get();
	}

	@Override
	public void save(Student sStudent) {
		// TODO Auto-generated method stub
		sdata.save(sStudent);
	}

	@Override
	public void deleteById(int sId) {
		// TODO Auto-generated method stub
		sdata.deleteById(sId);
	}

}
