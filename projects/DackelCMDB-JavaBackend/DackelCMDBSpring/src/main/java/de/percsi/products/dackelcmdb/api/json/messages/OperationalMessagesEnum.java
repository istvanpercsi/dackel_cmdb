package de.percsi.products.dackelcmdb.api.json.messages;

public enum OperationalMessagesEnum {
    RECORD_SAVED(OperationalMessage.builder()
            .messageId(100)
            .messageClass(OperationalMessageTypesEnum.INFO)
            .messageText("Record saved.")
            .build()),

    RECORD_UPDATED(OperationalMessage.builder()
            .messageId(101)
            .messageClass(OperationalMessageTypesEnum.INFO)
            .messageText("Record updated.")
            .build()),

    RECORD_DELETED(OperationalMessage.builder()
            .messageId(102)
            .messageClass(OperationalMessageTypesEnum.INFO)
            .messageText("Record deleted.")
            .build()),

    RECORD_NOT_FOUND (OperationalMessage.builder()
            .messageId(1000)
            .messageClass(OperationalMessageTypesEnum.ERROR)
            .messageText("Record not found.")
            .build()),

    RECORD_ALREADY_EXISTS(OperationalMessage.builder()
            .messageId(1001)
            .messageClass(OperationalMessageTypesEnum.ERROR)
            .messageText("Record already exists.")
            .build());

    private final OperationalMessage OPERATIONAL_MESSAGE;

    OperationalMessagesEnum(OperationalMessage operational_message) {
        OPERATIONAL_MESSAGE = operational_message;
    }

    public OperationalMessage getMessage() {
        return this.getMessage(null);
    }

    public OperationalMessage getMessage(String messageText) {
        OperationalMessage operationalMessage = this.OPERATIONAL_MESSAGE;
        if (messageText != null) {
            operationalMessage.setMessageText(messageText);
        }
        return operationalMessage;
    }



}
