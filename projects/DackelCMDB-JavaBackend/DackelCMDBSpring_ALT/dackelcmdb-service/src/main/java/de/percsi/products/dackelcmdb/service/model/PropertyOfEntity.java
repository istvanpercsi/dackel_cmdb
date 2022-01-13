package de.percsi.products.dackelcmdb.service.model;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PropertyOfEntity {

  Long id;

  String name;

  String systemName;

  //TODO: other fields

}
