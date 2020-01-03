package de.percsi.products.dackelcmdb.api.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class PropertyAndValueOfEntityModelJson {

  @JsonProperty(
      value = "propertyOfEntity",
      required = false,
      access = JsonProperty.Access.READ_ONLY
  )
  @JsonPropertyDescription(value = "Property Of Entity.")
  private PropertyOfEntityModelJson propertyOfEntityModelJson;

  @JsonProperty(
      value = "valueOfPropertyOfEntity",
      required = false,
      access = JsonProperty.Access.READ_ONLY
  )
  @JsonPropertyDescription(value = "Value of Property of Entity")
  private ValueOfPropertyOfEntityModelJson valueOfPropertyOfEntityModelJson;
}
