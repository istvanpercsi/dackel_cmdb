package de.percsi.products.dackelcmdb.persistence.model;

import de.percsi.products.dackelcmdb.persistence.model.base.BaseWithUserDateAndDeletedFlagModelDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "values_string")
public class ValueStringModelDB extends BaseWithUserDateAndDeletedFlagModelDB {

    @Column(name = "value")
    private String value;
}
