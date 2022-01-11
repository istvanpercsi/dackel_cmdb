package de.percsi.product.entitymanager.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.vavr.collection.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * ListOfSimplePropertyValueResponse
 */
@Value
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class ListOfSimplePropertyValueResponse   {

  @JsonProperty("properties")
  @Builder.Default
  List<SimplePropertyValueResponse> properties = null;

}
