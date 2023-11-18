package ru.koryukova.MyRestSpringBootAppH2DB.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.koryukova.MyRestSpringBootAppH2DB.entity.Subject;

@Slf4j
@Repository
public class SubjectDAOImpl implements SubjectDAO {

  @Autowired
  private EntityManager entityManager;

  @Override
  public List<Subject> getAllSubjects() {
    Query query = entityManager.createQuery("from Subject");
    List<Subject> allSubjects = query.getResultList();
    log.info("getAllSubjects: " + allSubjects);
    return allSubjects;
  }

  @Override
  public Subject saveSubject(Subject subject) {
    return entityManager.merge(subject);
  }

  @Override
  public Subject getSubject(int id) {
    return entityManager.find(Subject.class, id);
  }

  @Override
  public void deleteSubject(int id) {
    Query query = entityManager.createQuery("delete from Subject"
        + " where id =:subjectId");

    query.setParameter("subjectId", id);
    query.executeUpdate();
  }
}
