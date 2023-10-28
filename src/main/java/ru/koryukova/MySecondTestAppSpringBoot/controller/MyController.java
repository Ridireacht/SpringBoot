package ru.koryukova.MySecondTestAppSpringBoot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.koryukova.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.koryukova.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.koryukova.MySecondTestAppSpringBoot.model.Request;
import ru.koryukova.MySecondTestAppSpringBoot.model.Response;
import ru.koryukova.MySecondTestAppSpringBoot.service.ValidationService;
import ru.koryukova.MySecondTestAppSpringBoot.util.DateTimeUtil;


@RestController
public class MyController {

  private final ValidationService validationService;

  @Autowired
  public MyController(ValidationService validationService) {
    this.validationService = validationService;
  }

  @PostMapping(value = "/feedback")
  public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {

    Response response = Response.builder()
        .uid(request.getUid())
        .operationUid(request.getOperationUid())
        .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
        .code("success")
        .errorCode("")
        .errorMessage("")
        .build();

    try {
      if (response.getUid().equals("123"))
        throw new UnsupportedCodeException("uid must not be 123!");
    } catch (UnsupportedCodeException e) {
      response.setCode("failed");
      response.setErrorCode("UnsupportedCodeException");
      response.setErrorMessage("Ошибка - uid равен 123!");
      return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }


    try {
      validationService.isValid(bindingResult);
    } catch (ValidationFailedException e) {
      response.setCode("failed");
      response.setErrorCode("ValidationException");
      response.setErrorMessage("Ошибка валидации");
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
      response.setCode("failed");
      response.setErrorCode("UnknownException");
      response.setErrorMessage("Произошла непредвиденная ошибка");
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
