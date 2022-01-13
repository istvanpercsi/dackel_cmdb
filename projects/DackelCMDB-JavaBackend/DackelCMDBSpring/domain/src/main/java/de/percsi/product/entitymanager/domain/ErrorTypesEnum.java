package de.percsi.product.entitymanager.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets errorTypesEnum
 */
public enum ErrorTypesEnum {
  BUSINESS("BUSINESS"),
    TECHNICAL("TECHNICAL"),
    INTERNAL("INTERNAL");

  private final String value;

  ErrorTypesEnum(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ErrorTypesEnum fromValue(String text) {
    for (ErrorTypesEnum b : ErrorTypesEnum.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
