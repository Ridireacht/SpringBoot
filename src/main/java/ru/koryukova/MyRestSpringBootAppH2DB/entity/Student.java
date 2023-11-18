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
@Table(name = "STUDENTS")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @Column(name = "faculty")
  private String faculty;

  @Column(name = "age")
  private int age;

  public Student() {

  }

  public Student(String name, String surname, String faculty, int age) {
    this.name = name;
    this.surname = surname;
    this.faculty = faculty;
    this.age = age;
  }
}
