package ru.koryukova.FirstService.exception;

public class ValidationFailedException extends Exception {

  public ValidationFailedException(String message) {
    super(message);
  }
}
