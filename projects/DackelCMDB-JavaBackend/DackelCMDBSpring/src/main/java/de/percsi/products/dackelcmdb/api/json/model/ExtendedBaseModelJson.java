package de.percsi.products.dackelcmdb.api.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@SuperBuilder
public class ExtendedBaseModelJson extends BaseModelJson {

    @JsonProperty(
            value = "name",
            required = true,
            access = JsonProperty.Access.READ_WRITE
    )
    @JsonPropertyDescription(value = "Name of record (Name of entity, name of type of entity, name of property")
    private String name;

    @JsonProperty(
            value = "systemName",
            required = true,
            access = JsonProperty.Access.READ_WRITE
    )
    @JsonPropertyDescription(value = "System name of record (System name of entity, system name of type of entity, system " +
            "name of property")
    private String systemName;

}
