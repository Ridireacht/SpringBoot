package ru.koryukova.MyRestSpringBootAppH2DB.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.koryukova.MyRestSpringBootAppH2DB.entity.Student;
import ru.koryukova.MyRestSpringBootAppH2DB.response.StudentResponse;
import ru.koryukova.MyRestSpringBootAppH2DB.service.StudentService;

@RestController
@RequestMapping("/api")
public class MyController {

  @Autowired
  private StudentService studentService;

  @GetMapping("/students")
  public List<StudentResponse> showAllStudents() {
    List<Student> allStudents = studentService.getAllStudents();

    return allStudents.stream()
        .map(student -> new StudentResponse(student, true))
        .collect(Collectors.toList());
  }

  @GetMapping("/students/{id}")
  public StudentResponse getStudent(@PathVariable("id") int id) {
    Student student = studentService.getStudent(id);
    return new StudentResponse(student, true);
  }

  @PostMapping("/students")
  public StudentResponse saveStudent(@RequestBody Student student) {
    return studentService.saveStudent(student);
  }

  @PutMapping("/students")
  public StudentResponse updateStudent(@RequestBody Student student) {
    return studentService.saveStudent(student);
  }

  @DeleteMapping("/students/{id}")
  public void deleteStudent(@PathVariable("id") int id) {
    studentService.deleteStudent(id);
  }
}
