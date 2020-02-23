package de.percsi.products.dackelcmdb.persistence_alt.model;

import de.percsi.products.dackelcmdb.persistence_alt.model.base.BaseWithUserDateDeletedFlagAndNameModelDB;
import de.percsi.products.dackelcmdb.persistence_alt.model.base.TablesConst;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = TablesConst.ENTITIES)

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
public class EntityModelDB extends BaseWithUserDateDeletedFlagAndNameModelDB implements Serializable {

    @ManyToOne
    @JoinColumn(name = "type_of_entity_id", nullable = false)
    private TypeOfEntityModelDB typeOfEntity;

    @OneToMany(mappedBy = "entity", fetch = FetchType.LAZY)
    private Set<ValueOfPropertyOfEntityModelDB> valueOfPropertyOfEntityModelDBS;

}
