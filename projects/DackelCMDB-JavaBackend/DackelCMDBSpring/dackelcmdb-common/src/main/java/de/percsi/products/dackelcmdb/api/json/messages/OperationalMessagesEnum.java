package de.percsi.products.dackelcmdb.api.json.messages;

public enum OperationalMessagesEnum {

    TEST_ENUM_MESSAGE(OperationalMessage.builder()
            .messageId(0)
            .messageClass(OperationalMessageTypesEnum.INFO)
            .messageText("This is a message, with parameter1:%s, parameter2:%s, parameter3:%s")
            .build()),

    RECORD_SAVED(OperationalMessage.builder()
            .messageId(1001)
            .messageClass(OperationalMessageTypesEnum.INFO)
            .messageText("Record saved.")
            .build()),

    RECORD_UPDATED(OperationalMessage.builder()
            .messageId(1002)
            .messageClass(OperationalMessageTypesEnum.INFO)
            .messageText("Record updated.")
            .build()),

    RECORD_DELETED(OperationalMessage.builder()
            .messageId(1003)
            .messageClass(OperationalMessageTypesEnum.INFO)
            .messageText("Record deleted.")
            .build()),

    RECORD_ALREADY_EXISTS_TABLE_ID(OperationalMessage.builder()
            .messageId(1101)
            .messageClass(OperationalMessageTypesEnum.ERROR)
            .messageText("Record is already exist in table: '%s' with id: '%s'.")
            .build()),

    RECORD_ALREADY_EXISTS_TABLE_SYSTEMNAME(OperationalMessage.builder()
            .messageId(1102)
            .messageClass(OperationalMessageTypesEnum.ERROR)
            .messageText("Record is already exist in table: '%s' with system_name: '%s'.")
            .build()),

    RECORD_NOT_FOUND_TABLE_ID (OperationalMessage.builder()
            .messageId(1103)
            .messageClass(OperationalMessageTypesEnum.WARN)
            .messageText("Record cannot be found in table: '%s' with Id '%s'.")
            .build());


    private final OperationalMessage OPERATIONAL_MESSAGE;

    OperationalMessagesEnum(OperationalMessage operational_message) {
        OPERATIONAL_MESSAGE = operational_message;
    }

    public OperationalMessage getMessage(String... args) {
        return OperationalMessage.builder()
                .messageId(this.OPERATIONAL_MESSAGE.getMessageId())
                .messageClass(this.OPERATIONAL_MESSAGE.getMessageClass())
                .messageText(String.format(this.OPERATIONAL_MESSAGE.getMessageText(),args))
                .build();
    }



}
