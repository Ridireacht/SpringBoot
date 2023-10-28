package ru.koryukova.MySecondTestAppSpringBoot.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.koryukova.MySecondTestAppSpringBoot.model.Response;
import ru.koryukova.MySecondTestAppSpringBoot.util.DateTimeUtil;

@Service
@Qualifier("ModifySystemTimeResponseService")
public class ModifySystemTimeResponseService implements ModifyResponseService {

  @Override
  public Response modify(Response response) {
    response.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));

    return response;
  }
}
