package de.percsi.product.entitymanager.controller.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * ExtendedEntityResponse
 */

@Value
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class ExtendedEntityResponse   {

  @JsonProperty("id")
  @Builder.Default
  UUID id = null;

  @JsonProperty("name")
  @Builder.Default
  String name = null;

  @JsonProperty("createDate")
  @Builder.Default
  OffsetDateTime createDate = null;

  @JsonProperty("modifyDate")
  @Builder.Default
  OffsetDateTime modifyDate = null;

  @JsonProperty("creator")
  @Builder.Default
  String creator = null;

  @JsonProperty("modifier")
  @Builder.Default
  String modifier = null;

}
