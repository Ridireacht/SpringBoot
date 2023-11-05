package ru.koryukova.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.koryukova.MySecondTestAppSpringBoot.model.Response;


@Service
public interface ModifyResponseService {

  Response modify(Response response);
}
