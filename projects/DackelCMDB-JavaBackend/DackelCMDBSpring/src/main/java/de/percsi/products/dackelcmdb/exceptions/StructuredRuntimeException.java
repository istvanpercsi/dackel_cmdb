package de.percsi.products.dackelcmdb.exceptions;

import de.percsi.products.dackelcmdb.api.json.messages.OperationalMessage;

public class StructuredRuntimeException extends RuntimeException {

    private final OperationalMessage message;

    StructuredRuntimeException(OperationalMessage message) {
        this.message = message;
    }

    public OperationalMessage getOPMessage() {
        return this.message;
    }

}
