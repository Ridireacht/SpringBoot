package ru.koryukova.MySecondTestAppSpringBoot.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.koryukova.MySecondTestAppSpringBoot.model.Response;


@Service
@Qualifier("ModifyOperationUidResponseService")
public class ModifyOperationUidResponseService implements ModifyResponseService {

  @Override
  public Response modify(Response response) {
    UUID uuid = UUID.randomUUID();

    response.setOperationUid(uuid.toString());

    return response;
  }
}
