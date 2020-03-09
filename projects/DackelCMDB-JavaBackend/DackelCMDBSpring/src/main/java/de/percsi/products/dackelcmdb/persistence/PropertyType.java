package de.percsi.products.dackelcmdb.persistence;

public enum  PropertyType {

  TEXT("str"),
  NUMBER("num"),
  SECRET("sec"),
  DATETIME("dti"),
  ENTITY("ent");

  private String type;

  PropertyType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return this.type;
  }

}
