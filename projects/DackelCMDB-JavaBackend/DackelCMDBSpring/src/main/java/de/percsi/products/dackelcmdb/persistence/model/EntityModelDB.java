package de.percsi.products.dackelcmdb.persistence.model;

import de.percsi.products.dackelcmdb.persistence.model.base.BaseWithUserDateDeletedFlagAndNameModelDB;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "entities")

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
public class EntityModelDB extends BaseWithUserDateDeletedFlagAndNameModelDB implements Serializable {

    @ManyToOne
    @JoinColumn(name = "type_of_entity_id", nullable = false)
    TypeOfEntityModelDB typeOfEntity;

}
