package com.exflyer.oddi.app.annotaions;

import com.exflyer.oddi.app.enums.CrudOperation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MenuCheckApi {

  String menuCode();

  CrudOperation operation();

}
