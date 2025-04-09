package com.myArchitecture.Architecture.Repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myArchitecture.Architecture.Model.Student;

//repository/StudentRepository.java
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
