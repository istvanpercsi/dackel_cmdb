package de.percsi.products.dackelcmdb.api.json.controler;

import de.percsi.products.dackelcmdb.api.json.messages.Message;
import de.percsi.products.dackelcmdb.api.json.messages.MessageClassesEnum;
import de.percsi.products.dackelcmdb.exceptions.RecordNotFoundDBException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RecordNotFoundDBException.class})
    protected ResponseEntity<Object> handleRecordNotFoundDBException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, Message.builder()
                .messageText(ex.getMessage())
                .messageClass(MessageClassesEnum.ERROR)
                .messageId(1001)
                .build(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
