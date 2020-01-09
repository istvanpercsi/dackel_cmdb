package de.percsi.products.dackelcmdb.mapper;

import de.percsi.products.dackelcmdb.api.json.controler.EntityController;
import de.percsi.products.dackelcmdb.api.json.model.EntityModelJson;
import de.percsi.products.dackelcmdb.persistence.model.ConnectorOfEntityPropertyValueModelDB;
import de.percsi.products.dackelcmdb.persistence.model.EntityModelDB;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = TypeOfEntityModelMapper.class)
public interface EntityModelMapper {

  EntityModelMapper MAPPER = Mappers.getMapper(EntityModelMapper.class);

  EntityModelDB mapJsonToDb(EntityModelJson entityModelJson);

  @Mappings({
      @Mapping(target = "propertyAndValueOfEntityModelJson", ignore = true)
  })
  EntityModelJson mapDbToJson(EntityModelDB entityModelDB);

  EntityModelJson mapDbToJson(ConnectorOfEntityPropertyValueModelDB connectorOfEntityPropertyValueModelDB);

}
