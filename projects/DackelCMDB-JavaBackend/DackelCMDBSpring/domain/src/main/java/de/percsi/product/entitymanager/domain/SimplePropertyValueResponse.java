package de.percsi.product.entitymanager.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;
import java.util.UUID;

/**
 * SimplePropertyValueResponse
 */
@Value
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class SimplePropertyValueResponse   {

  @JsonProperty("id")
  @Builder.Default
  UUID id = null;

  @JsonProperty("property")
  @Builder.Default
  SimplePropertyResponse property = null;

  @JsonProperty("value")
  @Builder.Default
  String value = null;

}
