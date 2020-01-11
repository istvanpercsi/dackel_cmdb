package de.percsi.products.dackelcmdb.persistence.model.base;

public enum TypeOfPropertyOfEntityEnum {
  STRING(ColumnNameOfTypeOfPropertyOfEntityConst.STRING),
  NUMBER(ColumnNameOfTypeOfPropertyOfEntityConst.NUMBER),
  SECURE(ColumnNameOfTypeOfPropertyOfEntityConst.SECURE),
  DATE(ColumnNameOfTypeOfPropertyOfEntityConst.DATE),
  ENTITY(ColumnNameOfTypeOfPropertyOfEntityConst.ENTITY);

  private String column;

  TypeOfPropertyOfEntityEnum(String column) {
    this.column = column;
  }

  public String getColumn() {
    return this.column;
  }


}
