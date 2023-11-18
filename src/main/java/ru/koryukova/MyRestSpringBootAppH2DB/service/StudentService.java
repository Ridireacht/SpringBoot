package ru.koryukova.MyRestSpringBootAppH2DB.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.koryukova.MyRestSpringBootAppH2DB.entity.Student;

@Service
public interface StudentService {

  List<Student> getAllStudents();

  Student getStudent(int id);

  Student saveStudent(Student student);

  void deleteStudent(int id);
}
