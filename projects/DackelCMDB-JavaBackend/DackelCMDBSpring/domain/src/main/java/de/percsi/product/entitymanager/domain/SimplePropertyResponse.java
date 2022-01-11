package de.percsi.product.entitymanager.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

/**
 * SimplePropertyResponse
 */

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class SimplePropertyResponse   {
  @JsonProperty("id")
  @Builder.Default
  UUID id = null;

  @JsonProperty("name")
  @Builder.Default
  String name = null;

}
