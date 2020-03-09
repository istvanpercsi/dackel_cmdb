package de.percsi.products.dackelcmdb.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PropertyValueOfEntity {

  PropertyOfEntity property;

  ValueOfPropertyOfEntity value;

  public String getValue() {
    return "";
  }


}
