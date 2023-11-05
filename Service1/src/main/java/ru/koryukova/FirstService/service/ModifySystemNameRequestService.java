package ru.koryukova.FirstService.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ru.koryukova.FirstService.model.Request;
import ru.koryukova.FirstService.model.Systems;

public class ModifySystemNameRequestService implements ModifyRequestService {

  @Override
  public void modify(Request request) {
    request.setSystemName(Systems.SE1);

    HttpEntity<Request> httpEntity = new HttpEntity<>(request);

    new RestTemplate().exchange("http://localhost:8084/feedback",
        HttpMethod.POST,
        httpEntity,
        new ParameterizedTypeReference<>() {
        });
  }
}
