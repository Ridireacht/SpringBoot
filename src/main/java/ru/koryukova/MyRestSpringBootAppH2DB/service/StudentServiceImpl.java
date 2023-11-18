package ru.koryukova.MyRestSpringBootAppH2DB.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.koryukova.MyRestSpringBootAppH2DB.dao.StudentDAO;
import ru.koryukova.MyRestSpringBootAppH2DB.entity.Student;
import ru.koryukova.MyRestSpringBootAppH2DB.response.StudentResponse;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentDAO studentDAO;

  @Override
  @Transactional
  public List<Student> getAllStudents() {
    return studentDAO.getAllStudents();
  }

  @Override
  @Transactional
  public Student getStudent(int id) {
    return studentDAO.getStudent(id);
  }

  @Override
  @Transactional
  public StudentResponse saveStudent(Student student) {
    Student savedStudent = studentDAO.saveStudent(student);

    if (savedStudent != null) {
      return new StudentResponse(savedStudent, true);
    }

    else
      return new StudentResponse(new Student(), false);
  }

  @Override
  @Transactional
  public void deleteStudent(int id) {
    studentDAO.deleteStudent(id);
  }
}
