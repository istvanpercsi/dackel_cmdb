package de.percsi.products.dackelcmdb.service.model;

import de.percsi.products.dackelcmdb.service.model.literal.ValueType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ValueOfPropertyOfEntity<T extends ValueType> {

  private T value;

}
