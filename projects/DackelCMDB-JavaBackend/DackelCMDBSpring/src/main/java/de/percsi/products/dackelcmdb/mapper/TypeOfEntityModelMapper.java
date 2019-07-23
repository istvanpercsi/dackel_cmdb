package de.percsi.products.dackelcmdb.mapper;

import de.percsi.products.dackelcmdb.api.json.model.EntityModelJson;
import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJson;
import de.percsi.products.dackelcmdb.persistence.model.EntityModelDB;
import de.percsi.products.dackelcmdb.persistence.model.TypeOfEntityModelDB;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TypeOfEntityModelMapper  {
    TypeOfEntityModelMapper MAPPER=Mappers.getMapper(TypeOfEntityModelMapper.class);

    TypeOfEntityModelDB mapJsonToDB(EntityModelJson entityModelJson);

    TypeOfEntityModelJson mapDBToJson(EntityModelDB entityModelDB);
}
