package ru.koryukova.MyRestSpringBootAppH2DB.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import ru.koryukova.MyRestSpringBootAppH2DB.entity.Student;

@Repository
public interface StudentDAO {

  List<Student> getAllStudents();

  Student saveStudent(Student student);

  Student getStudent(int id);

  void deleteStudent(int id);
}
