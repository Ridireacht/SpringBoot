package ru.koryukova.FirstService.service;

import org.springframework.stereotype.Service;
import ru.koryukova.FirstService.model.Response;


@Service
public interface ModifyResponseService {

  Response modify(Response response);
}
