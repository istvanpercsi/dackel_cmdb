package de.percsi.product.entitymanager.controller.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

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
