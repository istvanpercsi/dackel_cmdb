package de.percsi.products.dackelcmdb.mapper;

import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJsonCU;
import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJsonR;
import de.percsi.products.dackelcmdb.persistence.model.TypeOfEntityModelDB;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TypeOfEntityModelMapper  {
    TypeOfEntityModelMapper MAPPER=Mappers.getMapper(TypeOfEntityModelMapper.class);

    TypeOfEntityModelDB mapJsonCUToDB(TypeOfEntityModelJsonCU typeOfEntityModelJsonCU);

    TypeOfEntityModelJsonR mapDBToJsonR(TypeOfEntityModelDB typeOfEntityModelDB);
}
