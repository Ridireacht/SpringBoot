package ru.koryukova.SecondService.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.koryukova.SecondService.model.Response;
import ru.koryukova.SecondService.util.DateTimeUtil;

@Service
@Qualifier("ModifySystemTimeResponseService")
public class ModifySystemTimeResponseService implements ModifyResponseService {

  @Override
  public Response modify(Response response) {
    response.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));

    return response;
  }
}
