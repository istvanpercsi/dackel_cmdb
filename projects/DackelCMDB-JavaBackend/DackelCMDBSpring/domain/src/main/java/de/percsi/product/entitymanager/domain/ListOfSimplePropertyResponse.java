package de.percsi.product.entitymanager.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.vavr.collection.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * ListOfSimplePropertyResponse
 */
@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ListOfSimplePropertyResponse   {

  @JsonProperty("properties")
  @Builder.Default
  List<SimplePropertyResponse> properties = null;

}
