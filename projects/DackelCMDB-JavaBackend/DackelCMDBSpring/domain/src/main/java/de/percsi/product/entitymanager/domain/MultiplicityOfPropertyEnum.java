package de.percsi.product.entitymanager.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets multiplicityOfProperty
 */
public enum MultiplicityOfPropertyEnum {
  SINGLE("SINGLE"),
    MULTI("MULTI");

  private final String value;

  MultiplicityOfPropertyEnum(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static MultiplicityOfPropertyEnum fromValue(String text) {
    for (MultiplicityOfPropertyEnum b : MultiplicityOfPropertyEnum.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
