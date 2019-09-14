package de.percsi.products.dackelcmdb.api.json.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@SuperBuilder
public class EntityModelJson extends ExtendedBaseModelJson {

    private String typeOfEntity;

}
