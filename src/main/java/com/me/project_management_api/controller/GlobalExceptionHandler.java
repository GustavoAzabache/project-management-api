package com.me.project_management_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.me.project_management_api.exception.CustomErrorResponse;
import com.me.project_management_api.exception.ProjectNotFoundException;
import com.me.project_management_api.exception.UrlProjectAlreadyUsedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handlerProjectNotFound(ProjectNotFoundException ex) {
        CustomErrorResponse error = new CustomErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "No encontrado",
                ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UrlProjectAlreadyUsedException.class)
    public ResponseEntity<CustomErrorResponse> handlerUrlAlreadyUsed(UrlProjectAlreadyUsedException ex) {
        CustomErrorResponse error = new CustomErrorResponse(
                HttpStatus.CONFLICT.value(),
                "Conflicto de URL",
                ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorResponse> handlerValidationsErrors(MethodArgumentNotValidException ex) {
        CustomErrorResponse error = new CustomErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "SOLICITUD INCORRECTA",
                ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
