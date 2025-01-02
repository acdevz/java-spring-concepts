package org.spring.s009springbootdemo.advices;

import org.spring.s009springbootdemo.exceptions.NotEnoughMoneyException;
import org.spring.s009springbootdemo.models.ErrorDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetail> handleNotEnoughMoneyException(NotEnoughMoneyException e) {
        return ResponseEntity.status(400).body(ErrorDetail.of(e.getMessage()));
    }
}
