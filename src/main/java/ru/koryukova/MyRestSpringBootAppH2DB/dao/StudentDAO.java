package ru.koryukova.MyRestSpringBootAppH2DB.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO {

  List<Student> getAllStudents();

  Student saveStudent(Student student);

  Student getStudent(int id);

  void deleteStudent(int id);
}
