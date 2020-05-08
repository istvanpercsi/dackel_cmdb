package de.percsi.products.dackelcmdb.persistence_alt.model;

import de.percsi.products.dackelcmdb.persistence_alt.model.base.BaseWithUserDateDeletedFlagAndNameModelDB;
import de.percsi.products.dackelcmdb.persistence_alt.model.base.TablesConst;
import de.percsi.products.dackelcmdb.persistence_alt.model.base.TypeOfPropertyOfEntityEnum;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = TablesConst.PROPERTIES_OF_ENTITIES)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
public class PropertyOfEntityModelDB extends BaseWithUserDateDeletedFlagAndNameModelDB implements Serializable {

    @Column(name = "type")
    private TypeOfPropertyOfEntityEnum type;

}
