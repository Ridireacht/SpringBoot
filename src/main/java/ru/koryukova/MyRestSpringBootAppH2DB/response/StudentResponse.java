package ru.koryukova.MyRestSpringBootAppH2DB.response;

import ru.koryukova.MyRestSpringBootAppH2DB.entity.Student;

public class StudentResponse {
    public Student student;
    public boolean success;

  public StudentResponse(Student student, boolean success) {
    this.student = student;
    this.success = success;
  }
}
