package de.percsi.products.dackelcmdb.model;

import de.percsi.products.dackelcmdb.model.literal.ValueType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PropertyValueOfEntity<T extends ValueType> {

  PropertyOfEntity property;

  ValueOfPropertyOfEntity<T> value;

}
