package ru.koryukova.MyRestSpringBootAppH2DB.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.koryukova.MyRestSpringBootAppH2DB.entity.Student;
import ru.koryukova.MyRestSpringBootAppH2DB.response.StudentResponse;

@Service
public interface StudentService {

  List<Student> getAllStudents();

  Student getStudent(int id);

  StudentResponse saveStudent(Student student);

  void deleteStudent(int id);
}
