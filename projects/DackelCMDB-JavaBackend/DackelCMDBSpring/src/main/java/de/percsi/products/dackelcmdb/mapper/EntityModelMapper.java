package de.percsi.products.dackelcmdb.mapper;

import de.percsi.products.dackelcmdb.api.json.model.EntityModelJson;
import de.percsi.products.dackelcmdb.api.json.model.PropertyAndValueOfEntityModelJson;
import de.percsi.products.dackelcmdb.api.json.model.PropertyOfEntityModelJson;
import de.percsi.products.dackelcmdb.api.json.model.ValueOfPropertyOfEntityModelJson;
import de.percsi.products.dackelcmdb.persistence.model.ValueOfPropertyOfEntityModelDB;
import de.percsi.products.dackelcmdb.persistence.model.EntityModelDB;
import de.percsi.products.dackelcmdb.persistence.model.base.TypeOfPropertyOfEntityEnum;
import io.vavr.collection.HashSet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Set;


@Mapper(uses = TypeOfEntityModelMapper.class)
public interface EntityModelMapper {

  EntityModelMapper MAPPER = Mappers.getMapper(EntityModelMapper.class);

  EntityModelDB mapJsonToDb(EntityModelJson entityModelJson);

  @Mappings({
      @Mapping(target = "propertyAndValueOfEntityModelJson", ignore = true)
  })
  EntityModelJson mapDbToJsonWithoutProperties(EntityModelDB entityModelDB);

  @Mappings({
      @Mapping(source = "entityModelDB.getValueOfPropertyOfEntityModelDBS", target = "propertyAndValueOfEntityModelJson", qualifiedByName = "propertyValueGenerator")
  })
  EntityModelJson mapDbToJsonWithProperties(EntityModelDB entityModelDB);

  @Named("propertyValueGenerator")
  default List<PropertyAndValueOfEntityModelJson> propertyValueGenerator(Set<ValueOfPropertyOfEntityModelDB> valueOfPropertyOfEntityModelDBS) {
    return HashSet.ofAll(valueOfPropertyOfEntityModelDBS).map(e-> PropertyAndValueOfEntityModelJson.builder()
        .propertyOfEntityModelJson(PropertyOfEntityModelJson.builder()
            .id(e.getProperty().getId())
            .name(e.getProperty().getName())
            .systemName(e.getProperty().getSystemName())
            .build())
        .valueOfPropertyOfEntityModelJson(ValueOfPropertyOfEntityModelJson.builder()
            .id(e.getId())
            .value(getValue(e.getProperty().getType(), e))
            .build())
        .build()).toJavaList();
  }

  default String getValue(TypeOfPropertyOfEntityEnum type, ValueOfPropertyOfEntityModelDB valueOfPropertyOfEntityModelDB) {
    switch (type) {
      case STRING:
        return valueOfPropertyOfEntityModelDB.getValueSTR();
      default:
        throw new NotImplementedException();
    }
  }


}
