package ru.koryukova.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.koryukova.MySecondTestAppSpringBoot.model.Request;


@Service
public interface ModifyRequestService {
    void modify(Request request);
}
