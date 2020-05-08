package de.percsi.products.dackelcmdb.api.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;
import lombok.experimental.SuperBuilder;


@Value
@SuperBuilder
public class ValueOfPropertyOfEntityModelJson extends BaseModelJson {

  @JsonProperty(
      value = "value",
      required = false
  )
  @ApiModelProperty(value = "Value of Property")
  private String value;

}
