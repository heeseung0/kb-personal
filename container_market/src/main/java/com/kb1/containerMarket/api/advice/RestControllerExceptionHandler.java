package com.kb1.containerMarket.api.advice;

import com.kb1.containerMarket.dto.CMRespDto;
import com.kb1.containerMarket.exception.CustomValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> validationErrorException(CustomValidationException e){
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(),e.getErrorMap()));
    }
}
