package com.polasek.restwebapp.word;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WordNotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler(WordNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String WordNotFoundHandler(WordNotFoundException ex) {
	    return ex.getMessage();
	  }
}
