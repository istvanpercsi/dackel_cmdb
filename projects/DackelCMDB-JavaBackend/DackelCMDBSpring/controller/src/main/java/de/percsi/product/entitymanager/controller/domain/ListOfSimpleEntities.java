package de.percsi.product.entitymanager.controller.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.vavr.collection.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * ListOfSimpleEntities
 */
@Value
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class ListOfSimpleEntities   {

  @JsonProperty("entities")
  @Builder.Default
  List<SimpleEntityResponse> entities = null;

}
