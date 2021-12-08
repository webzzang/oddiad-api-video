package com.exflyer.oddi.app.enums;

public enum CrudOperation {
  CREATE("create"),
  READ("read"),
  UPDATE("update"),
  DELETE("delete");

  private String value;

  CrudOperation(String value) {
    this.value = value;
  }
}
