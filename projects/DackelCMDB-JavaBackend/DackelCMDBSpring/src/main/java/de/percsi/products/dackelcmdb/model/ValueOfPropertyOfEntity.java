package de.percsi.products.dackelcmdb.model;

import de.percsi.products.dackelcmdb.model.literal.*;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ValueOfPropertyOfEntity<T extends ValueType> {

  private T value;

}
