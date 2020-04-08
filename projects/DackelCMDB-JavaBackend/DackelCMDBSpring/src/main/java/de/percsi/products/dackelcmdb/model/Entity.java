package de.percsi.products.dackelcmdb.model;

import io.vavr.collection.Set;
import io.vavr.control.Option;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class Entity {

  @Builder.Default
  Option<Long> id = Option.none();

  String name;

  String systemName;

  LocalDateTime createDateTime;

  LocalDateTime modifyDateTime;

  String createUser;

  String modifyUser;

  Set<PropertyValueOfEntity> propertyValueSet;

}
