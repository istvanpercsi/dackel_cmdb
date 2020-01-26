package de.percsi.products.dackelcmdb.mapper;

import de.percsi.products.dackelcmdb.api.json.model.ValueOfPropertyOfEntityModelJson;
import de.percsi.products.dackelcmdb.persistence.model.ValueOfPropertyOfEntityModelDB;
import de.percsi.products.dackelcmdb.persistence.model.base.TypeOfPropertyOfEntityEnum;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;

@Mapper
public interface ValueOfPropertyOfEntityMapper {

  ValueOfPropertyOfEntityMapper MAPPER = Mappers.getMapper(ValueOfPropertyOfEntityMapper.class);

  @Mappings({
      @Mapping(target = "value", source = "valueOfPropertyOfEntityModelDB", qualifiedByName = "getValue")
  })
  ValueOfPropertyOfEntityModelJson mapDbToJson(ValueOfPropertyOfEntityModelDB valueOfPropertyOfEntityModelDB, @Context TypeOfPropertyOfEntityEnum typeOfPropertyOfEntityEnum);

  @Named("getValue")
  default String getValue(@Context TypeOfPropertyOfEntityEnum type, ValueOfPropertyOfEntityModelDB valueOfPropertyOfEntityModelDB) {
    switch (type) {
      case STRING:
        return valueOfPropertyOfEntityModelDB.getValueSTR();
      case DATE:
        return valueOfPropertyOfEntityModelDB.getValueDAT().toString();
      case NUMBER:
        return valueOfPropertyOfEntityModelDB.getValueNUM().toString();
      case SECURE:
        return valueOfPropertyOfEntityModelDB.getValueSEC();
      case ENTITY:
        return valueOfPropertyOfEntityModelDB.getValueENT().toString();
      default:
        throw new NotImplementedException();
    }
  }
}
