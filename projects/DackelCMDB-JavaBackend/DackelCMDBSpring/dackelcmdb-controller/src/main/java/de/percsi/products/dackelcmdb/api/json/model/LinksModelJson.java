package de.percsi.products.dackelcmdb.api.json.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class LinksModelJson {

  String text;
  String path;
  String httpMethod;

}
