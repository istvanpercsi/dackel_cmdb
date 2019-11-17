package de.percsi.products.dackelcmdb.persistence.model.base;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
public class BaseWithUserDateDeletedFlagAndNameModelDB extends BaseWithUserDateAndDeletedFlagModelDB implements Serializable {

    @Column(name = "name")
    private String name;
    @Column(name = "system_name")
    private String systemName;

}
