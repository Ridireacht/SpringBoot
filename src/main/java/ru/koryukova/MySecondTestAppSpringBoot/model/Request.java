package ru.koryukova.MySecondTestAppSpringBoot.model;

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

  @NotBlank
  private String uid;

  @NotBlank
  private String operationUid;

  private String systemName;

  @NotBlank
  private String systemTime;

  private String source;

  @NotBlank
  private int communicationId;

  private int templateId;
  private int productCode;
  private int smsCode;
}
