package de.percsi.products.dackelcmdb.service.modelmapper;

import de.percsi.products.dackelcmdb.persistence.EntityDataModelDB;
import de.percsi.products.dackelcmdb.service.model.TypeOfEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {PrimitivesOptionMapper.class, DateTimeMapper.class})
public interface TypeOfEntityMapper {

  @Mappings({
      @Mapping(target = "id", source = "id"),
      @Mapping(target = "name", source = "displayName"),
      @Mapping(target = "systemName", source = "systemName"),
      @Mapping(target = "createDateTime", source = "metaData.createDate"),
      @Mapping(target = "createUser", source = "metaData.createUser"),
      @Mapping(target = "modifyDateTime", source = "metaData.modifyDate"),
      @Mapping(target = "modifyUser", source = "metaData.modifyUser"),
      @Mapping(target = "entitySet", ignore = true)
  })
  TypeOfEntity mapDbToService(EntityDataModelDB entityDataModelDB);

}
