package ru.koryukova.MySecondTestAppSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Systems {
  ERP("Enterprise Resource Planning"),
  CRM ("Customer Relationship Management"),
  WMS ("Warehouse Management System");

  private final String fullName;

  Systems(String fullName) {
    this.fullName = fullName;
  }

  @JsonValue
  public String getName() {
    return fullName;
  }

  @Override
  public String toString() {
    return fullName;
  }
}
