package de.percsi.products.dackelcmdb.persistence;

public enum EntityDataType {

  ENTITY("entity"),
  TYPE_OF_ENTITY("type_of_entity"),
  PROPERTY("property");

  private String dataType;

  EntityDataType(String dataType) {
    this.dataType = dataType;
  }

  @Override
  public String toString() {
    return this.dataType;
  }
}
