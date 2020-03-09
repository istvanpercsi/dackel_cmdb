package de.percsi.products.dackelcmdb.model;

import io.vavr.control.Option;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ValueOfPropertyOfEntity {

  private Option<Double> number = Option.none();

  private Option<String> text = Option.none();

  //TODO: define secret class
  private Option<String> secret = Option.none();

  private Option<Entity> entity = Option.none();


}
