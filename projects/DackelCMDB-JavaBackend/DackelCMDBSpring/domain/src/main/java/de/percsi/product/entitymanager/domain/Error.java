package de.percsi.product.entitymanager.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * Error
 */
@Value
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class Error {

  @JsonProperty("errorType")
  @Builder.Default
  ErrorTypesEnum errorType = null;

  @JsonProperty("code")
  @Builder.Default
  String code = null;

  @JsonProperty("message")
  @Builder.Default
  String message = null;

}
