package de.percsi.products.dackelcmdb.exceptions;

import de.percsi.products.dackelcmdb.api.json.messages.OperationalMessage;
import org.springframework.http.HttpStatus;

public class StructuredRuntimeException extends RuntimeException {

    private final OperationalMessage message;

    private final HttpStatus httpStatus;

    private StructuredRuntimeException(OperationalMessage message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public static StructuredRuntimeException of(OperationalMessage message) {
      return StructuredRuntimeException.of(message,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static StructuredRuntimeException of(OperationalMessage message, HttpStatus httpStatus) {
      return new StructuredRuntimeException(message,httpStatus);
    }

    public OperationalMessage getOPMessage() {
        return this.message;
    }

}
