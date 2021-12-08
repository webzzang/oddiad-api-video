package com.exflyer.oddi.app.exceptions;


import com.exflyer.oddi.app.enums.ApiResponseCodes;
import lombok.Getter;

public class ApiException extends Exception {

  @Getter
  private ApiResponseCodes apiResponseCodes;


  public ApiException(ApiResponseCodes code){
    this.apiResponseCodes = code;
  }

}
