
 package com.promising.controller;
 
 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice; import
 org.springframework.web.bind.annotation.ExceptionHandler;

import com.promising.aop.LogAspect;
 
 @ControllerAdvice 
 public class ExceptionController {
	 Logger logger =  LoggerFactory.getLogger(ExceptionController.class);
 @ExceptionHandler(Exception.class) 
 public String exception(Exception e) { 
	 logger.info(e.getMessage());
	e.printStackTrace();
	 return "/error"; 
	 }
}
