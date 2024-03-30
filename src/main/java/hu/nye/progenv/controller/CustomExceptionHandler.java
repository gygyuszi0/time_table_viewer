package hu.nye.progenv.controller;

import hu.nye.progenv.CustomExceptions.LessonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Nem található a kersett óra")
    @ExceptionHandler(LessonNotFoundException.class)
    public void lessonNotFoundExceptionHandler(){}

}
