package ru.koryukova.FirstService.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.koryukova.FirstService.exception.ValidationFailedException;


@Service
public interface ValidationService {

  void isValid(BindingResult bindingResult) throws ValidationFailedException;
}
