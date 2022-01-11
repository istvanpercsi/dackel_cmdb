package de.percsi.product.entitymanager.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * SimplePropertyValueRequest
 */
@Value
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class SimplePropertyValueRequest   {

  @JsonProperty("value")
  @Builder.Default
  String value = null;

}
