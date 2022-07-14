package com.studentsecurity.app.studentRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentsecurity.app.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
