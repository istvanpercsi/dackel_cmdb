package de.percsi.products.dackelcmdb.persistence.model;

import de.percsi.products.dackelcmdb.persistence.model.base.BaseWithUserDateDeletedFlagAndNameModelDB;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = Tables.PROPERTIES_OF_ENTITIES)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
public class PropertyOfEntityModelDB extends BaseWithUserDateDeletedFlagAndNameModelDB implements Serializable {

    @Column(name = "type")
    private TypeOfPropertyOfEntityEnumDB type;

}
