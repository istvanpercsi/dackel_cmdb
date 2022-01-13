package de.percsi.product.entitymanager.controller;

import de.percsi.product.entitymanager.domain.Error;
import de.percsi.product.entitymanager.domain.ErrorTypesEnum;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class EntityManagerControllerAdvice extends ResponseEntityExceptionHandler {

  /**
   * Not Implemented Exception handling.
   */
  @ExceptionHandler(value = { NotImplementedException.class })
  protected ResponseEntity<Object> notImplementedMethod(RuntimeException ex, WebRequest request) {
    Error errorMessage = Error.builder()
        .code("00001")
        .errorType(ErrorTypesEnum.TECHNICAL)
        .message("Http request '" + request.getDescription(false) + "' reached a method which is not yet implemented: " + ex.getMessage())
        .build();
    return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), HttpStatus.NOT_IMPLEMENTED, request);
  }

}
