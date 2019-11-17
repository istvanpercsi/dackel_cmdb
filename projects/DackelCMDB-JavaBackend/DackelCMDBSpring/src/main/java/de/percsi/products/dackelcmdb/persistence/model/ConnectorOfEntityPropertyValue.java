package de.percsi.products.dackelcmdb.persistence.model;

import de.percsi.products.dackelcmdb.persistence.model.base.BaseModelDB;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ConnectorOfEntityPropertyValue extends BaseModelDB implements Serializable {

    @ManyToOne
    @JoinColumn(name = "entity_id")
    private EntityModelDB entity;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private PropertyOfEntityModelDB property;

    @ManyToOne
    @JoinColumn(name = "value_string_id", nullable = true)
    private ValueStringModelDB valueString;

}
