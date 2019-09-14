package de.percsi.products.dackelcmdb.api.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;
import java.util.HashMap;
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
    @JsonPropertyDescription(value = "Id of record")
    private Long id;

    @JsonProperty(
            value = "createDate",
            required = false,
            access = JsonProperty.Access.READ_ONLY
    )
    @JsonPropertyDescription(value = "Create date of record")
    private Date createDate;

    @JsonProperty(
            value = "modificationDate",
            required = false,
            access = JsonProperty.Access.READ_ONLY
    )
    @JsonPropertyDescription(value = "Modification date of record. If it is equal with createDate then the record has " +
            "been created but not modified.")
    private Date modificationDate;

    @JsonProperty(
            value = "createUser",
            required = false,
            access = JsonProperty.Access.READ_ONLY
    )
    @JsonPropertyDescription(value = "Name of create user")
    private String createUser;

    @JsonProperty(
            value = "modificationUser",
            required = false,
            access = JsonProperty.Access.READ_ONLY
    )
    @JsonPropertyDescription(value = "Name of modification user")
    private String modificationUser;

    @JsonProperty(
            value = "_links",
            required = true,
            access = JsonProperty.Access.READ_ONLY
    )

    @Builder.Default
    private Map<String, String> _links = new HashMap<>();
}
