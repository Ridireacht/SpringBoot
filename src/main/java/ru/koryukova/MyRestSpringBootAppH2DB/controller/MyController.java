package ru.koryukova.MyRestSpringBootAppH2DB.controller;

import java.util.List;
import java.util.stream.Collectors;
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
import ru.koryukova.MyRestSpringBootAppH2DB.entity.Subject;
import ru.koryukova.MyRestSpringBootAppH2DB.response.StudentResponse;
import ru.koryukova.MyRestSpringBootAppH2DB.response.SubjectResponse;
import ru.koryukova.MyRestSpringBootAppH2DB.service.StudentService;
import ru.koryukova.MyRestSpringBootAppH2DB.service.SubjectService;

@RestController
@RequestMapping("/api")
public class MyController {

  @Autowired
  private StudentService studentService;

  @Autowired
  private SubjectService subjectService;

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



  @GetMapping("/subjects")
  public List<SubjectResponse> showAllSubjects() {
    List<Subject> allSubjects = subjectService.getAllSubjects();

    return allSubjects.stream()
        .map(subject -> new SubjectResponse(subject, true))
        .collect(Collectors.toList());
  }

  @GetMapping("/subjects/{id}")
  public SubjectResponse getSubject(@PathVariable("id") int id) {
    Subject subject = subjectService.getSubject(id);
    return new SubjectResponse(subject, true);
  }

  @PostMapping("/subjects")
  public SubjectResponse saveSubject(@RequestBody Subject subject) {
    return subjectService.saveSubject(subject);
  }

  @PutMapping("/subjects")
  public SubjectResponse updateSubject(@RequestBody Subject subject) {
    return subjectService.saveSubject(subject);
  }

  @DeleteMapping("/subjects/{id}")
  public void deleteSubject(@PathVariable("id") int id) {
    subjectService.deleteSubject(id);
  }
}
