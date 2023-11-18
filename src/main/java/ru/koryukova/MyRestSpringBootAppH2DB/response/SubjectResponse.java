package ru.koryukova.MyRestSpringBootAppH2DB.response;


import ru.koryukova.MyRestSpringBootAppH2DB.entity.Subject;

public class SubjectResponse {
  public Subject subject;
  public boolean success;

  public SubjectResponse(Subject subject, boolean success) {
    this.subject = subject;
    this.success = success;
  }
}
