package de.percsi.products.dackelcmdb.api.json.messages;

public enum MessagesEnum {
    RECORD_ALREADY_EXISTS_TABLE_ID
            ("Record is already exist in table: '%s' with id: '%s'."),
    RECORD_ALREADY_EXISTS_TABLE_SYSTEM_NAME
            ("Record is already exist in table: '%s' with system_name: '%s'."),
    RECORD_NOT_FOUND_TABLE_ID
            ("Record cannot be found in table: '%s' with Id '%s'."),
    RECORD_NOT_FOUND_TABLE_COLUMN_SEARCH_STRING
            ("Searched value: '%s cannot be found in column: '%s' of table: '%s'");

    private String MESSAGE;

    MessagesEnum(String message) { this.MESSAGE = message; }

    public String getMessage() { return this.MESSAGE; }
}
