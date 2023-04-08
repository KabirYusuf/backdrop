package com.kyaa.backdrop.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ApiResponse> userNotFoundException(UserException userException,
                                                             HttpServletRequest httpServletRequest){
        ApiResponse apiResponse = ApiResponse.builder()
                .message(userException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .path(httpServletRequest.getRequestURI())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .zonedDateTime(ZonedDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ApiResponse> ioException(IOException ioException,
                                                             HttpServletRequest httpServletRequest){
        ApiResponse apiResponse = ApiResponse.builder()
                .message(ioException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .path(httpServletRequest.getRequestURI())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .zonedDateTime(ZonedDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
