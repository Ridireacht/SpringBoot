package ru.koryukova.FirstService.service;

import org.springframework.stereotype.Service;
import ru.koryukova.FirstService.model.Request;


@Service
public interface ModifyRequestService {
    void modify(Request request);
}
