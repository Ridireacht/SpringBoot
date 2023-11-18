package ru.koryukova.MyRestSpringBootAppH2DB.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.koryukova.MyRestSpringBootAppH2DB.dao.SubjectDAO;
import ru.koryukova.MyRestSpringBootAppH2DB.entity.Subject;
import ru.koryukova.MyRestSpringBootAppH2DB.response.SubjectResponse;

@Service
public class SubjectServiceImpl implements SubjectService {

  @Autowired
  private SubjectDAO subjectDAO;

  @Override
  @Transactional
  public List<Subject> getAllSubjects() {
    return subjectDAO.getAllSubjects();
  }

  @Override
  @Transactional
  public Subject getSubject(int id) {
    return subjectDAO.getSubject(id);
  }

  @Override
  @Transactional
  public SubjectResponse saveSubject(Subject subject) {
    Subject savedSubject = subjectDAO.saveSubject(subject);

    if (savedSubject != null) {
      return new SubjectResponse(savedSubject, true);
    }

    else
      return new SubjectResponse(new Subject(), false);
  }

  @Override
  @Transactional
  public void deleteSubject(int id) {
    subjectDAO.deleteSubject(id);
  }
}
