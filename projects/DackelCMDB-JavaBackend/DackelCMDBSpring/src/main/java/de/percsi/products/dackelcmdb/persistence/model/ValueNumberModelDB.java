package de.percsi.products.dackelcmdb.persistence.model;

import de.percsi.products.dackelcmdb.persistence.model.base.BaseWithUserDateAndDeletedFlagModelDB;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "values_number")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
public class ValueNumberModelDB extends BaseWithUserDateAndDeletedFlagModelDB implements Serializable {

    @Column(name = "value")
    private Double value;
}
