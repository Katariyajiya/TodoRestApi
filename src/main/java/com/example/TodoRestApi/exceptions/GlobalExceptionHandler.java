package com.example.TodoRestApi.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> nullPointerException(NullPointerException ex){
        logger.info("Get null pointer exception from GlobalException Handler");
        return new ResponseEntity<>("NullPointer Exception caught "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> ResourceNotFoundException(ResourceNotFoundException ex){
         logger.error("Error : {}",ex.getMessage());
         ExceptionResponse response = new ExceptionResponse();
         response.setMessage(ex.getMessage());
         response.setSuccess(false);
         response.setStatus(HttpStatus.NOT_FOUND);
         return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
