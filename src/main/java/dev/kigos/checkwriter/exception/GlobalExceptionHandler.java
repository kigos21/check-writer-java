package dev.kigos.checkwriter.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.kigos.checkwriter.dto.response.ErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleValidationException(
      MethodArgumentNotValidException exception) {

    log.error(exception.getMessage());

    Map<String, List<String>> fieldErrorMap = new HashMap<>();
    exception.getBindingResult().getFieldErrors().forEach(error -> {
      String fieldName = error.getField();
      String message = error.getDefaultMessage();

      List<String> currentFieldErrors = fieldErrorMap.getOrDefault(fieldName, new ArrayList<>());
      currentFieldErrors.add(message);

      fieldErrorMap.put(fieldName, currentFieldErrors);
    });

    ErrorResponse errorResponse = new ErrorResponse("Validation failed", fieldErrorMap);
    return ResponseEntity.badRequest().body(errorResponse);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<ErrorResponse> handleMissingRequestBodyException(
      HttpMessageNotReadableException exception) {

    log.error(exception.getMessage());
    ErrorResponse errorResponse = new ErrorResponse("Request body is required but was not provided");
    return ResponseEntity.badRequest().body(errorResponse);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException exception) {

    log.error(exception.getMessage());
    ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }

  @ExceptionHandler(EntityInUseException.class)
  public ResponseEntity<ErrorResponse> handleEntityInUseException(EntityInUseException exception) {

    log.error(exception.getMessage());
    ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
    return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
  }
}
