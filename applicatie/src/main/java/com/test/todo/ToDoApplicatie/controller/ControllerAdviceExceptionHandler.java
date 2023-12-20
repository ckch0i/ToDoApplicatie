package com.test.todo.ToDoApplicatie.controller;

import com.test.todo.ToDoApplicatie.model.FoutmeldingDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<FoutmeldingDTO> handleException(Exception exception){
        FoutmeldingDTO foutmeldingDTO = new FoutmeldingDTO("CODE-000", "Onbekende foutmelding");
        return new ResponseEntity<>(foutmeldingDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<FoutmeldingDTO> handleException(DataIntegrityViolationException exception){
        FoutmeldingDTO foutmeldingDTO = new FoutmeldingDTO("CODE-001", "User bestaat al, kies een andere username");
        return new ResponseEntity<>(foutmeldingDTO, HttpStatus.BAD_REQUEST);
    }
}
