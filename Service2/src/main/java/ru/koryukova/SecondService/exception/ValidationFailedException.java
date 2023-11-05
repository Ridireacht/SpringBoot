package ru.koryukova.SecondService.exception;

public class ValidationFailedException extends Exception {

  public ValidationFailedException(String message) {
    super(message);
  }
}
