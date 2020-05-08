package de.percsi.products.dackelcmdb.service.modelmapper;

import io.vavr.control.Option;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrimitivesOptionMapper {

  default Option<Long> longToOptionLong (Long value) {
    return Option.of(value);
  }

}
