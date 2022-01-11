package de.percsi.product.entitymanager.controller.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * ExtendedPropertyValueResponse
 */
@Value
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class ExtendedPropertyValueResponse   {
  @JsonProperty("id")
  @Builder.Default
  UUID id = null;

  @JsonProperty("property")
  @Builder.Default
  SimplePropertyResponse property = null;

  @JsonProperty("value")
  @Builder.Default
  String value = null;

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
