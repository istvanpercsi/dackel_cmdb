package de.percsi.products.dackelcmdb.service.modelmapper;

import org.mapstruct.Mapper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Mapper(componentModel = "spring")
public interface DateTimeMapper {

  default LocalDateTime dateToLocalDateTime(Date date) {
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
  }

  default Date localDateTimeToDate(LocalDateTime localDateTime) {
    return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
  }

}
