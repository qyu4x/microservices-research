package com.qirara.rest.nekoservice.nekoservice.exception;

import com.qirara.rest.nekoservice.nekoservice.payload.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CentralizedErrorHandling {

    public ResponseEntity<ErrorResponse<List<String>>> handleValidationError(MethodArgumentNotValidException exception) {
        List<String> validationErrors = exception.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());

        ErrorResponse<List<String>> errorResponse = new ErrorResponse<>(
                exception.getStatusCode().value(),
                exception.getStatusCode().toString(),
                validationErrors
        );

        return ResponseEntity.status(exception.getStatusCode()).body(errorResponse);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse<String>> handleAllException(Exception exception) {
        ErrorResponse<String> errorResponse = new ErrorResponse<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponse<String>> handleDataNotFound(DataNotFoundException exception) {
        ErrorResponse<String> errorResponse = new ErrorResponse<>(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
