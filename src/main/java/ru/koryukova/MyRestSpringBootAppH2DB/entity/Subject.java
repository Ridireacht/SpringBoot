package ru.koryukova.MyRestSpringBootAppH2DB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "SUBJECTS")
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "lecturer")
  private String lecturer;

  @Column(name = "faculty")
  private String faculty;


  public Subject() {

  }

  public Subject(String name, String lecturer, String faculty) {
    this.name = name;
    this.lecturer = lecturer;
    this.faculty = faculty;
  }
}
