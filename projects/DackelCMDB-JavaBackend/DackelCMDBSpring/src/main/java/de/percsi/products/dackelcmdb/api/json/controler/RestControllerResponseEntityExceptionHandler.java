package de.percsi.products.dackelcmdb.api.json.controler;

import de.percsi.products.dackelcmdb.api.json.messages.OperationalMessagesEnum;
import de.percsi.products.dackelcmdb.exceptions.RecordAlreadyExistsDBException;
import de.percsi.products.dackelcmdb.exceptions.RecordNotFoundDBException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestControllerResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RecordNotFoundDBException.class})
    protected ResponseEntity<Object> handleRecordNotFoundDBException(RecordNotFoundDBException ex, WebRequest request) {
        return handleExceptionInternal(ex,ex.getMessage(),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {RecordAlreadyExistsDBException.class})
    protected ResponseEntity<Object> handleRecordAlreadyExistsDBException(RecordAlreadyExistsDBException ex, WebRequest request) {
        return handleExceptionInternal(ex,ex.getMessage(),
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

}
