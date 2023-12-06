package com.example.testthymeleafapp.dao;

import com.example.testthymeleafapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
