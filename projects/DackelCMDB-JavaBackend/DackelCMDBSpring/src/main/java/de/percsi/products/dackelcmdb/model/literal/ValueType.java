package de.percsi.products.dackelcmdb.model.literal;


public class ValueType<T> {

  private T value;

  protected ValueType(T value) {
    this.value = value;
  }

  protected T getValue() {
    return value;
  }



}
