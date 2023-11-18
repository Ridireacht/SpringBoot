package ru.koryukova.MyRestSpringBootAppH2DB.dao;

import java.util.List;
import ru.koryukova.MyRestSpringBootAppH2DB.entity.Subject;

public interface SubjectDAO {
  List<Subject> getAllSubjects();

  Subject saveSubject(Subject subject);

  Subject getSubject(int id);

  void deleteSubject(int id);
}
