package de.percsi.products.dackelcmdb.persistence.model;

import de.percsi.products.dackelcmdb.persistence.model.base.BaseModelDB;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = Tables.CONNECTOR_OF_ENTITY_PROPERTY_VALUE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
public class ConnectorOfEntityPropertyValueModelDB extends BaseModelDB implements Serializable {

    @ManyToOne
    @JoinColumn(name = "entity_id")
    private EntityModelDB entity;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private PropertyOfEntityModelDB property;

    @ManyToOne
    @JoinColumn(name = "value_string_id", nullable = true)
    private ValueStringModelDB valueString;

    @ManyToOne
    @JoinColumn(name = "value_number_id", nullable = true)
    private ValueNumberModelDB valueNumber;

}
