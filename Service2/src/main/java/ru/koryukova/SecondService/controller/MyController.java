package ru.koryukova.SecondService.controller;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.koryukova.SecondService.exception.UnsupportedCodeException;
import ru.koryukova.SecondService.exception.ValidationFailedException;
import ru.koryukova.SecondService.model.Codes;
import ru.koryukova.SecondService.model.ErrorCodes;
import ru.koryukova.SecondService.model.ErrorMessages;
import ru.koryukova.SecondService.model.Request;
import ru.koryukova.SecondService.model.Response;
import ru.koryukova.SecondService.service.ValidationService;
import ru.koryukova.SecondService.util.DateTimeUtil;


@Slf4j
@RestController
public class MyController {

  private final ValidationService validationService;

  @Autowired
  public MyController(ValidationService validationService) {
    this.validationService = validationService;
  }

  @PostMapping(value = "/feedback")
  public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {

    log.info("request: {}", request);

    Response response = Response.builder()
        .uid(request.getUid())
        .operationUid(request.getOperationUid())
        .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
        .code(Codes.SUCCESS)
        .errorCode(ErrorCodes.EMPTY)
        .errorMessage(ErrorMessages.EMPTY)
        .build();

    log.info("initial response: {}", response);

    try {
      if (response.getUid().equals("123"))
        throw new UnsupportedCodeException("uid must not be 123!");
    }

    catch (UnsupportedCodeException e) {
      log.error("Unsupported exception happened");

      response.setCode(Codes.FAILED);
      response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
      response.setErrorMessage(ErrorMessages.UNKNOWN);

      log.info("error detected, response modified: {}", response);

      return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }


    try {
      validationService.isValid(bindingResult);
    }

    catch (ValidationFailedException e) {
      log.error("Validation exception happened.");

      List<FieldError> errors = bindingResult.getFieldErrors();
      for (FieldError error : errors) {
        String fieldName = error.getField();
        String errorMessage = error.getDefaultMessage();
        log.error("Field: " + fieldName + ", error: " + errorMessage);
      }

      response.setCode(Codes.FAILED);
      response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
      response.setErrorMessage(ErrorMessages.VALIDATION);

      log.info("error detected, response modified: {}", response);

      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    catch (Exception e) {
      log.error("Unknown exception happened");

      response.setCode(Codes.FAILED);
      response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
      response.setErrorMessage(ErrorMessages.UNKNOWN);

      log.info("error detected, response modified: {}", response);

      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
