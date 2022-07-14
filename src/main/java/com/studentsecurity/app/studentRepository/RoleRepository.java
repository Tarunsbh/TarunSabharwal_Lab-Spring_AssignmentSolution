package com.studentsecurity.app.studentRepository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.studentsecurity.app.entity.Roles;


@Repository
public interface RoleRepository extends JpaRepository<Roles,Integer> {
   
}
