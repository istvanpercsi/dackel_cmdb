package de.percsi.products.dackelcmdb.persistence;

import io.vavr.collection.List;

public enum EntityDataType {

  ENTITY(Constants.ENTITY),
  TYPE_OF_ENTITY(Constants.TYPE_OF_ENTITY),
  PROPERTY(Constants.PROPERTY);

  private String dataType;

  EntityDataType(String dataType) {
    this.dataType = dataType;
  }

  @Override
  public String toString() {
    return this.dataType;
  }

  public static class Constants {
    public static final String ENTITY = "entity";
    public static final String TYPE_OF_ENTITY = "type_of_entity";
    public static final String PROPERTY = "property";
  }
}
