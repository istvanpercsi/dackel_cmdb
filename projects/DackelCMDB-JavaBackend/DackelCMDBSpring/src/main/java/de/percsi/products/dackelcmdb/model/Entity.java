package de.percsi.products.dackelcmdb.model;

import io.vavr.collection.Set;
import io.vavr.control.Option;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Value
@Builder
public class Entity {

  Option<Long> id;

  String name;

  String systemName;

  LocalDateTime createDateTime;

  LocalDateTime modifyDateTime;

  String createUser;

  String modifyUser;

  Set<PropertyValueOfEntity> propertyValueSet;

}
