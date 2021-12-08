package com.exflyer.oddi.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@Slf4j
public class OddiAdAppApiApiApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {

    SpringApplication.run(OddiAdAppApiApiApplication.class, args);
    log.info("start!! oddi app api");
  }

}
