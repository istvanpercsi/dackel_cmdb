package de.percsi.products.dackelcmdb.persistence_alt.model;

import de.percsi.products.dackelcmdb.persistence_alt.model.base.BaseWithUserDateDeletedFlagAndNameModelDB;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "types_of_entity")

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
public class TypeOfEntityModelDB extends BaseWithUserDateDeletedFlagAndNameModelDB implements Serializable{

    @OneToMany(mappedBy = "typeOfEntity", fetch = FetchType.LAZY)
    private Set<EntityModelDB> entities;

}
