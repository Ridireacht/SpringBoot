package ru.koryukova.SecondService.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.koryukova.SecondService.exception.ValidationFailedException;


@Service
public interface ValidationService {

  void isValid(BindingResult bindingResult) throws ValidationFailedException;
}
