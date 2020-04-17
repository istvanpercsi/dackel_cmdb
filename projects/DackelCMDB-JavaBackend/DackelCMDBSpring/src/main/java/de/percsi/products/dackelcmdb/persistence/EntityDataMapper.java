package de.percsi.products.dackelcmdb.persistence;

import de.percsi.products.dackelcmdb.model.Entity;
import io.vavr.control.Option;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Mapper(componentModel = "spring")
interface EntityDataMapper {

  @Mappings({
      @Mapping(source = "entity.id", target = "id", qualifiedByName = "optionIdToId"),
      @Mapping(source = "entity.name", target = "displayName"),
      @Mapping(source = "entity.systemName", target = "systemName"),
      @Mapping(source = "entityDataType", target = "type"),
      @Mapping(source = "entity.createUser", target = "metaData.createUser"),
      @Mapping(source = "entity.createDateTime", target = "metaData.createDate"),
      @Mapping(source = "entity.modifyUser", target = "metaData.modifyUser"),
      @Mapping(source = "entity.modifyDateTime", target = "metaData.modifyDate"),
      @Mapping(source = "entity.id", target = "metaData.id", qualifiedByName = "optionIdToId")
  })
  EntityDataModelDB mapInternalToDb(Entity entity, EntityDataType entityDataType);

  @Named("optionIdToId")
  default Long optionIdToId(Option<Long> id) {
    return id.getOrNull();
  }

  @Mappings({
      @Mapping(source = "id", target = "id", qualifiedByName = "idToOptionId"),
      @Mapping(source = "displayName", target = "name"),
      @Mapping(source = "systemName", target = "systemName"),
      @Mapping(source = "metaData.createUser", target = "createUser"),
      @Mapping(source = "metaData.createDate", target = "createDateTime", qualifiedByName = "dateToLocalDateTime"),
      @Mapping(source = "metaData.modifyUser", target = "modifyUser"),
      @Mapping(source = "metaData.modifyDate", target = "modifyDateTime", qualifiedByName = "dateToLocalDateTime"),
      //@Mapping(target = "propertyValueSet", ignore = true)
  })
  Entity mapDBtoInternal(EntityDataModelDB entityDataModelDB);

  @Named("idToOptionId")
  default Option<Long> idToOptionId(Long id) {
    return Option.of(id);
  }

  @Named("dateToLocalDateTime")
  default LocalDateTime dateToLocalDateTime(Date date) {
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
  }

}
