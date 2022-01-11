package de.percsi.product.entitymanager.controller.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets typeOfProperty
 */
public enum TypeOfProperty {
  STRING("STRING"),
    SECRET("SECRET"),
    TEXT("TEXT"),
    NUMBER("NUMBER");

  private final String value;

  TypeOfProperty(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static TypeOfProperty fromValue(String text) {
    for (TypeOfProperty b : TypeOfProperty.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
