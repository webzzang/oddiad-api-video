package com.exflyer.oddi.app.exceptions;

import com.exflyer.oddi.app.enums.ApiResponseCodes;
import java.io.IOException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception 이 발생 할 경우 캐칭해서 응답을 만들어 주는 클래스 ControllerAdvice 를 이용하여 구현함.
 *
 * 프로젝트 성격에 따라 다르지만 본 소스는 http.status.ok(200) 고정 response body 에서 code 와 message 를 응답함
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class ApiExceptionAdvice {

  @ExceptionHandler(value = {ApiException.class})
  @ResponseStatus(HttpStatus.OK)
  public Object handleEpisodeAuthException(ApiException e) {
    return new ExceptionResponse(e.getApiResponseCodes());
  }

  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler(value = {NullPointerException.class})
  public Object handleNPE(NullPointerException e) {
    e.printStackTrace();
    return new ExceptionResponse(ApiResponseCodes.INTERNAL);
  }

  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler(value = {IOException.class})
  public Object handleIOException(IOException e) {
    return new ExceptionResponse(ApiResponseCodes.INTERNAL);
  }


  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler(value = {NoSuchFieldError.class})
  public Object handleNoSuchFieldError(NoSuchFieldError e) {
    return new ExceptionResponse(ApiResponseCodes.INTERNAL);
  }

  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler(value = {HttpMessageNotReadableException.class})
  public Object handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
    return new ExceptionResponse(ApiResponseCodes.BAD_REQUEST);
  }

  private class ExceptionResponse {

    @Getter
    private String code;

    @Getter
    private String message;

    public ExceptionResponse(String code, String message) {
      this.code = code;
      this.message = message;
    }

    public ExceptionResponse(ApiResponseCodes apiResponseCodes) {
      this.code = apiResponseCodes.getCode();
      this.message = apiResponseCodes.getMessage();
    }
  }
}
