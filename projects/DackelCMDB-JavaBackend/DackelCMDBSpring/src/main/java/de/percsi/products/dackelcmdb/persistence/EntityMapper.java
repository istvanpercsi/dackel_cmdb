package de.percsi.products.dackelcmdb.persistence;

import de.percsi.products.dackelcmdb.model.Entity;
import io.vavr.control.Option;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Mapper
interface EntityMapper {

  EntityMapper MAPPER = Mappers.getMapper(EntityMapper.class);



  @Mappings({
      @Mapping(source = "id", target = "id", qualifiedByName = "optionIdToId"),
      @Mapping(source = "name", target = "displayName"),
      @Mapping(source = "systemName", target = "systemName"),
      @Mapping(target = "type", defaultValue = EntityDataType.Constants.ENTITY),
      @Mapping(target = "metaData", ignore = true)
  })
  EntityDataModelDB mapInternalToDb(Entity entity);

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
      @Mapping(target = "propertyValueSet", ignore = true)
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
//  EntityModelDB mapJsonToDb(EntityModelJson entityModelJson);
//
//  @Mappings({
//      @Mapping(target = "propertyAndValueOfEntityModelJson", ignore = true)
//  })
//  EntityModelJson mapDbToJsonWithoutProperties(EntityModelDB entityModelDB);
//
//  @Mappings({
//      @Mapping(source = "entityModelDB.valueOfPropertyOfEntityModelDBS", target = "propertyAndValueOfEntityModelJson", qualifiedByName = "propertyValueGenerator")
//  })
//  EntityModelJson mapDbToJsonWithProperties(EntityModelDB entityModelDB);
//
//  @Named("propertyValueGenerator")
//  default List<PropertyAndValueOfEntityModelJson> propertyValueGenerator(Set<ValueOfPropertyOfEntityModelDB> valueOfPropertyOfEntityModelDBS) {
//    //TODO - mapper for Property and for value
//    return HashSet.ofAll(valueOfPropertyOfEntityModelDBS).map(e-> PropertyAndValueOfEntityModelJson.builder()
//        .propertyOfEntityModelJson(PropertyOfEntityMapper.MAPPER.mapDbToJson(e.getProperty()))
//        .valueOfPropertyOfEntityModelJson(ValueOfPropertyOfEntityMapper.MAPPER.mapDbToJson(e,e.getProperty().getType()))
//        .build()).toJavaList();
//  }




}
