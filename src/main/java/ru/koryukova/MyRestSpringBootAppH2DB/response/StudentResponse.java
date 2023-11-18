package ru.koryukova.MyRestSpringBootAppH2DB.response;

import ru.koryukova.MyRestSpringBootAppH2DB.entity.Student;

public class StudentResponse {
    private Student student;
    private boolean success;

  public StudentResponse(Student student, boolean success) {
    this.student = student;
    this.success = success;
  }
}
