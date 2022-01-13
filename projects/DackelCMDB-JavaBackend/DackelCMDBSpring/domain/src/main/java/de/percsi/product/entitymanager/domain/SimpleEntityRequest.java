package de.percsi.product.entitymanager.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * SimpleEntityRequest
 */
@Value
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class SimpleEntityRequest   {

  @JsonProperty("name")
  @Builder.Default
  String name = null;

}
