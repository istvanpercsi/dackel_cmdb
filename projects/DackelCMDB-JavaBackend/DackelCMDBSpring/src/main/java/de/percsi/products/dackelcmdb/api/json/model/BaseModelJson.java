package de.percsi.products.dackelcmdb.api.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@SuperBuilder
public class BaseModelJson {

    @JsonProperty(
            value = "id",
            required = false
    )
    @ApiModelProperty(value = "Id of record")
    private Long id;

    @JsonProperty(
            value = "createDate",
            required = false,
            access = JsonProperty.Access.READ_ONLY
    )
    @ApiModelProperty(
            value = "Create date of record",
            readOnly = true
    )
    private Date createDate;

    @JsonProperty(
            value = "modificationDate",
            required = false,
            access = JsonProperty.Access.READ_ONLY
    )
    @ApiModelProperty(
            value = "Modification date of record. If it is equal with createDate then the record has " +
            "been created but not modified.",
            readOnly = true,
            required = false
    )
    private Date modificationDate;

    @JsonProperty(
            value = "createUser",
            required = false,
            access = JsonProperty.Access.READ_ONLY
    )
    @ApiModelProperty(
            value = "Name of create user",
            readOnly = true
    )
    private String createUser;

    @JsonProperty(
            value = "modificationUser",
            required = false,
            access = JsonProperty.Access.READ_ONLY
    )
    @ApiModelProperty(
            value = "Name of modification user",
            readOnly = true
    )
    private String modificationUser;

    @JsonProperty(
            value = "_links",
            required = true,
            access = JsonProperty.Access.READ_ONLY
    )
    @ApiModelProperty(readOnly = true)
    private List<LinksModelJson> _links;
}
