package de.percsi.products.dackelcmdb.exceptions;

import de.percsi.products.dackelcmdb.api.json.messages.OperationalMessage;

public class RecordAlreadyExistsDBException extends StructuredRuntimeException {

    public RecordAlreadyExistsDBException(OperationalMessage message) {
        super(message);
    }

}
