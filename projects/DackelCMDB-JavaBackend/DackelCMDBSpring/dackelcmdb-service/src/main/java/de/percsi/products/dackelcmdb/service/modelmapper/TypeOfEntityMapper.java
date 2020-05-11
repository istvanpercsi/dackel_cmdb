package de.percsi.products.dackelcmdb.service.modelmapper;

import de.percsi.products.dackelcmdb.persistence.EntityDataModelDB;
import de.percsi.products.dackelcmdb.service.model.TypeOfEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {PrimitivesOptionMapper.class})
public interface TypeOfEntityMapper {

  @Mappings({
      @Mapping(target = "id", source = "id")
  })
  TypeOfEntity mapDbToService(EntityDataModelDB entityDataModelDB);

}
