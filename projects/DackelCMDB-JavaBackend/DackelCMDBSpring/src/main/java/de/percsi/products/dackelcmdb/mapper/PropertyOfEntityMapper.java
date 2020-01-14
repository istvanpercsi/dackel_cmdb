package de.percsi.products.dackelcmdb.mapper;

import de.percsi.products.dackelcmdb.api.json.model.LinksModelJson;
import de.percsi.products.dackelcmdb.api.json.model.PropertyOfEntityModelJson;
import de.percsi.products.dackelcmdb.persistence.model.PropertyOfEntityModelDB;
import io.vavr.Tuple;
import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Mapper
public interface PropertyOfEntityMapper {

  PropertyOfEntityMapper MAPPER = Mappers.getMapper(PropertyOfEntityMapper.class);

  @Mappings({
      @Mapping(target = "createDate", source = "createDate", dateFormat = "dd-MM-yyyy HH:mm:ss"),
      @Mapping(target = "modificationDate", source = "modificationDate", dateFormat = "yyyy-MM-dd HH:mm:ss"),
      @Mapping(target = "_links", source = "propertyOfEntityModelDB", qualifiedByName = "linksMapper")
  })
  PropertyOfEntityModelJson mapDbToJson(PropertyOfEntityModelDB propertyOfEntityModelDB);

  @Named("linksMapper")
  default List<LinksModelJson> linksMapper(PropertyOfEntityModelDB propertyOfEntityModelDB) {
    return Arrays.asList(LinksModelJson.builder().text("Edit").path("/properties/" + propertyOfEntityModelDB.getId()).httpMethod(HttpMethod.PATCH.name()).build());
  }

}
