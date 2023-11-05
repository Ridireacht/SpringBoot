package ru.koryukova.SecondService.service;

import org.springframework.stereotype.Service;
import ru.koryukova.SecondService.model.Response;


@Service
public interface ModifyResponseService {

  Response modify(Response response);
}
