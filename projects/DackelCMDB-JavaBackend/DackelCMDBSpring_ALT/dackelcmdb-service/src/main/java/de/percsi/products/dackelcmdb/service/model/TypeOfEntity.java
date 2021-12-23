package de.percsi.products.dackelcmdb.service.model;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import io.vavr.control.Option;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class TypeOfEntity {
  
  Option<Long> id;

  String name;

  String systemName;

  LocalDateTime createDateTime;

  LocalDateTime modifyDateTime;

  String createUser;

  String modifyUser;

  @Builder.Default
  Set<Entity> entitySet = HashSet.empty();

}
