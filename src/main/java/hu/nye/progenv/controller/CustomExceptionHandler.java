package hu.nye.progenv.controller;

import hu.nye.progenv.CustomExceptions.LessonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Catch Exceptions.
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    /**
     * Catch LessonNotFoundException.
     */
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Nem található a kersett óra")
    @ExceptionHandler(LessonNotFoundException.class)
    public void lessonNotFoundExceptionHandler(){}

}
