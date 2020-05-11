package de.percsi.products.dackelcmdb.service.modelmapper;

import de.percsi.products.dackelcmdb.persistence.EntityDataModelDB;
import de.percsi.products.dackelcmdb.service.model.Entity;

import org.mapstruct.*;


@Mapper(componentModel = "spring", uses = {PrimitivesOptionMapper.class, DateTimeMapper.class, TypeOfEntityMapper.class})
public interface EntityDataMapper {

  @Mappings({
      @Mapping(target = "id", source = "entity.id"),
      @Mapping(target = "name", source = "entity.displayName"),
      @Mapping(target = "systemName", source = "entity.systemName"),
      @Mapping(target = "modifyUser", source = "entity.metaData.modifyUser"),
      @Mapping(target = "createUser", source = "entity.metaData.createUser"),
      @Mapping(target = "createDateTime", source = "entity.metaData.createDate"),
      @Mapping(target = "modifyDateTime", source = "entity.metaData.modifyDate"),
      @Mapping(target = "typeOfEntity", source = "typeOfEntity")
  })
  Entity mapDbToService(EntityDataModelDB entity, EntityDataModelDB typeOfEntity );


}
