package com.toandd.project.thanhdat.common.exception;

import com.toandd.project.thanhdat.common.dto.ResponseDTO;
import com.toandd.project.thanhdat.common.util.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GiraBusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDTO> handleGlobalException(GiraBusinessException giraBusinessException) {
            return ResponseUtils.error(giraBusinessException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        return ResponseUtils.error(methodArgumentNotValidException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpMessageNotWritableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(HttpMessageNotWritableException httpMessageNotWritableException) {
        return ResponseUtils.error(httpMessageNotWritableException, HttpStatus.BAD_REQUEST);
    }
}
