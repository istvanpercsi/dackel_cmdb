package de.percsi.products.dackelcmdb.api.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@SuperBuilder
public class EntityModelJson extends ExtendedBaseModelJson {

    @JsonProperty(
            value = "typeOfEntity",
            required = true,
            access = JsonProperty.Access.READ_WRITE
    )
    @JsonPropertyDescription(value = "Type of entity.")
    private TypeOfEntityModelJson typeOfEntity;

}
