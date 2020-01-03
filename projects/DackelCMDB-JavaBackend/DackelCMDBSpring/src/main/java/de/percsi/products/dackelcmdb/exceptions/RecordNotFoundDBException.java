package de.percsi.products.dackelcmdb.exceptions;

import de.percsi.products.dackelcmdb.api.json.messages.OperationalMessage;

public class RecordNotFoundDBException extends StructuredRuntimeException {

    public RecordNotFoundDBException(OperationalMessage message) {
        super(message);
    }

}
