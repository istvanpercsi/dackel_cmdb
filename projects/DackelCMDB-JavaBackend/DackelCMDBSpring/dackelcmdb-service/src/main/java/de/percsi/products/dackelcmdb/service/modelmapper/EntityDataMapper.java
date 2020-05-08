package de.percsi.products.dackelcmdb.service.modelmapper;

import de.percsi.products.dackelcmdb.persistence.EntityDataModelDB;
import de.percsi.products.dackelcmdb.service.model.Entity;

import org.mapstruct.*;


@Mapper(componentModel = "spring", uses = {PrimitivesOptionMapper.class})
public interface EntityDataMapper {

  @Mappings({
      @Mapping(target = "id", source = "id"),
      @Mapping(target = "name", source = "displayName"),
      @Mapping(target = "systemName", source = "systemName"),
      @Mapping(target = "modifyUser", source = "metaData.modifyUser"),
      @Mapping(target = "createUser", source = "metaData.createUser"),
      @Mapping(target = "createDateTime", source = "metaData.createDate"),
      @Mapping(target = "modifyDateTime", source = "metaData.modifyDate"),
      @Mapping(target = "typeOfEntity", source = "type")
  })
  Entity mapDbToService(EntityDataModelDB entityDataModelDB);
//
//  @Mappings({
//      @Mapping(source = "entity.id", target = "id", qualifiedByName = "optionIdToId"),
//      @Mapping(source = "entity.name", target = "displayName"),
//      @Mapping(source = "entity.systemName", target = "systemName"),
//      @Mapping(source = "entityDataType", target = "type"),
//      @Mapping(source = "entity.createUser", target = "metaData.createUser"),
//      @Mapping(source = "entity.createDateTime", target = "metaData.createDate"),
//      @Mapping(source = "entity.modifyUser", target = "metaData.modifyUser"),
//      @Mapping(source = "entity.modifyDateTime", target = "metaData.modifyDate"),
//      @Mapping(source = "entity.id", target = "metaData.id", qualifiedByName = "optionIdToId")
//  })
//  Entity mapInternalToDb(EntityDataModelDB entity, EntityDataType entityDataType);
//
//  @Named("optionIdToId")
//  default Long optionIdToId(Option<Long> id) {
//    return id.getOrNull();
//  }
//
//  @Mappings({
//      @Mapping(source = "id", target = "id", qualifiedByName = "idToOptionId"),
//      @Mapping(source = "displayName", target = "name"),
//      @Mapping(source = "systemName", target = "systemName"),
//      @Mapping(source = "metaData.createUser", target = "createUser"),
//      @Mapping(source = "metaData.createDate", target = "createDateTime", qualifiedByName = "dateToLocalDateTime"),
//      @Mapping(source = "metaData.modifyUser", target = "modifyUser"),
//      @Mapping(source = "metaData.modifyDate", target = "modifyDateTime", qualifiedByName = "dateToLocalDateTime"),
//      //@Mapping(target = "propertyValueSet", ignore = true)
//  })
//  Entity mapDBtoInternal(EntityDataModelDB entityDataModelDB);
//
//  @Named("idToOptionId")
//  default Option<Long> idToOptionId(Long id) {
//    return Option.of(id);
//  }
//
//  @Named("dateToLocalDateTime")
//  default LocalDateTime dateToLocalDateTime(Date date) {
//    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//  }

}
