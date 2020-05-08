package de.percsi.products.dackelcmdb.persistence_alt.model.base;

import org.hibernate.mapping.Any;

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

  public Any getColumn(String s){return null;}


}
