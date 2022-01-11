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
 * SimpleEntityResponse
 */
@Value
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class SimpleEntityResponse   {
  @JsonProperty("id")
  @Builder.Default
  UUID id = null;

  @JsonProperty("name")
  @Builder.Default
  String name = null;

}
