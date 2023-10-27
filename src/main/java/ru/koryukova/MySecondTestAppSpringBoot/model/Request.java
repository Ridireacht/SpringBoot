package ru.koryukova.MySecondTestAppSpringBoot.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

  @NotBlank(message = "uid must not be blank")
  private String uid;

  @NotBlank(message = "operationUid must not be blank")
  private String operationUid;

  private String systemName;

  @NotBlank(message = "systemTime must not be blank")
  private String systemTime;

  private String source;

  @Min(value = 1, message = "communicationId must be at least 1")
  @Max(value = 100000, message = "communicationId must be at most 100000")
  private int communicationId;

  private int templateId;
  private int productCode;
  private int smsCode;
}
