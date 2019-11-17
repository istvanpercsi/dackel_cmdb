package de.percsi.products.dackelcmdb.persistence.model;

import de.percsi.products.dackelcmdb.persistence.model.base.BaseWithUserDateDeletedFlagAndNameModelDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "properties")
public class PropertyOfEntityModelDB extends BaseWithUserDateDeletedFlagAndNameModelDB implements Serializable {

    @Column(name = "type")
    private TypeOfPropertyOfEntityEnumDB type;

}
