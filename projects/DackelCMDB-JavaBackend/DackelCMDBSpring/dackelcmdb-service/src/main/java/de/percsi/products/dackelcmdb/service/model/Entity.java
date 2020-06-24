package de.percsi.products.dackelcmdb.service.model;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import io.vavr.control.Option;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Value
@Builder
public class Entity {

  @Builder.Default
  @NotNull("'id' cannot be null, use Option.none() instead.")
  Option<Long> id = Option.none();

  TypeOfEntity typeOfEntity;

  String name;

  String systemName;

  LocalDateTime createDateTime;

  LocalDateTime modifyDateTime;

  String createUser;

  String modifyUser;

  Set<PropertyValueOfEntity> propertyValueSet = HashSet.empty();

}
