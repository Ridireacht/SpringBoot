package ru.koryukova.FirstService.controller;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.koryukova.FirstService.exception.UnsupportedCodeException;
import ru.koryukova.FirstService.exception.ValidationFailedException;
import ru.koryukova.FirstService.model.Codes;
import ru.koryukova.FirstService.model.ErrorCodes;
import ru.koryukova.FirstService.model.ErrorMessages;
import ru.koryukova.FirstService.model.Request;
import ru.koryukova.FirstService.model.Response;
import ru.koryukova.FirstService.service.ModifyRequestService;
import ru.koryukova.FirstService.service.ModifyResponseService;
import ru.koryukova.FirstService.service.ValidationService;
import ru.koryukova.FirstService.util.DateTimeUtil;


@Slf4j
@RestController
public class MyController {

  private final ValidationService validationService;

  private final ModifyResponseService modifyResponseService;

  private final ModifyRequestService modifyRequestService;

  @Autowired
  public MyController(ValidationService validationService,
      @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
      ModifyRequestService modifyRequestService) {
    this.validationService = validationService;
    this.modifyResponseService = modifyResponseService;
    this.modifyRequestService = modifyRequestService;
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


    modifyResponseService.modify(response);
    modifyRequestService.modify(request);

    return new ResponseEntity<>(modifyResponseService.modify(response), HttpStatus.OK);
  }
}
