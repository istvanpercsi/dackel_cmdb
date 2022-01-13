package de.percsi.product.entitymanager.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * ExtendedPropertyResponse
 */
@Value
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class ExtendedPropertyResponse   {
  @JsonProperty("id")
  @Builder.Default
  UUID id = null;

  @JsonProperty("name")
  @Builder.Default
  String name = null;

  @JsonProperty("type")
  @Builder.Default
  TypeOfProperty type = null;

  @JsonProperty("multiplicity")
  @Builder.Default
  MultiplicityOfPropertyEnum multiplicity = null;

  @JsonProperty("format")
  @Builder.Default
  String format = null;

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
