package ru.koryukova.MyRestSpringBootAppH2DB.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.koryukova.MyRestSpringBootAppH2DB.entity.Student;
import ru.koryukova.MyRestSpringBootAppH2DB.service.StudentService;

@RestController
@RequestMapping("/api")
public class MyController {

  @Autowired
  private StudentService studentService;

  @GetMapping("/students")
  public List<Student> showAllStudents() {
    List<Student> allStudents = studentService.getAllStudents();
    return allStudents;
  }

  @GetMapping("/students/{id}")
  public Student getStudent(@PathVariable("id") int id) {
    return studentService.getStudent(id);
  }

  @PostMapping("/students")
  public Student saveStudent(@RequestBody Student student) {
    return studentService.saveStudent(student);
  }

  @PutMapping("/students")
  public Student updateStudent(@RequestBody Student student) {
    studentService.saveStudent(student);
    return student;
  }

  @DeleteMapping("/students/{id}")
  public void deleteStudent(@PathVariable("id") int id) {
    studentService.deleteStudent(id);
  }
}
