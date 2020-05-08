package de.percsi.products.dackelcmdb.mapper;

import de.percsi.products.dackelcmdb.persistence_alt.model.PropertyOfEntityModelDB;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpMethod;

import java.util.Arrays;
import java.util.List;

@Mapper
public interface PropertyOfEntityMapper {

//  PropertyOfEntityMapper MAPPER = Mappers.getMapper(PropertyOfEntityMapper.class);
//
//  @Mappings({
//      @Mapping(target = "createDate", source = "createDate", dateFormat = "yyyy-MM-dd HH:mm:ss"),
//      @Mapping(target = "modificationDate", source = "modificationDate", dateFormat = "yyyy-MM-dd HH:mm:ss"),
//      @Mapping(target = "_links", source = "propertyOfEntityModelDB", qualifiedByName = "linksMapper")
//  })
//  PropertyOfEntityModelJson mapDbToJson(PropertyOfEntityModelDB propertyOfEntityModelDB);
//
//  @Named("linksMapper")
//  default List<LinksModelJson> linksMapper(PropertyOfEntityModelDB propertyOfEntityModelDB) {
//    return Arrays.asList(LinksModelJson.builder().text("Edit").path("/properties/" + propertyOfEntityModelDB.getId()).httpMethod(HttpMethod.PATCH.name()).build(),
//        LinksModelJson.builder().text("Delete").path("/properties/" + propertyOfEntityModelDB.getId()).httpMethod(HttpMethod.DELETE.name()).build()
//    );
//  }

}
