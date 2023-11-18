package ru.koryukova.MyRestSpringBootAppH2DB.service;

import java.util.List;
import ru.koryukova.MyRestSpringBootAppH2DB.entity.Subject;
import ru.koryukova.MyRestSpringBootAppH2DB.response.SubjectResponse;

public interface SubjectService {
  List<Subject> getAllSubjects();

  Subject getSubject(int id);

  SubjectResponse saveSubject(Subject subject);

  void deleteSubject(int id);
}
