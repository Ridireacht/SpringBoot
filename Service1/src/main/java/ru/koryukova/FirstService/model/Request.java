package ru.koryukova.FirstService.model;

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

  // Уникальный идентификатор сообщения
  @NotBlank(message = "uid must not be blank")
  private String uid;

  // Уникальный идентификатор операции
  @NotBlank(message = "operationUid must not be blank")
  private String operationUid;

  // Имя системы отправителя
  private Systems systemName;

  // Время создания сообщения
  @NotBlank(message = "systemTime must not be blank")
  private String systemTime;

  // Наименование ресурса
  private String source;

  private String position;

  // Уникальный идентификатор коммуникации
  @Min(value = 1, message = "communicationId must be at least 1")
  @Max(value = 100000, message = "communicationId must be at most 100000")
  private int communicationId;

  // Уникальный идентификатор шаблона
  private int templateId;

  // Идентификатор продукта
  private int productCode;

  // Смс-код
  private int smsCode;

  private int salary;
  private int workDays;
  private double bonus;


  @Override
  public String toString() {
    return "{" +
        "uid ='" + uid + '\'' +
        ", operationUid='" + operationUid +'\'' +
        ", systemName='" + systemName +'\'' +
        ", systemTime='" + systemTime +'\'' +
        ", source='" + source +'\'' +
        ", position='" + position +'\'' +
        ", salary='" + salary +'\'' +
        ", bonus='" + bonus +'\'' +
        ", workDays='" + workDays +'\'' +
        ", communicationId=" + communicationId +
        ", templateId=" + templateId +
        ", productCode=" + productCode +
        ", smsCode=" + smsCode +
        '}';
  }
}
