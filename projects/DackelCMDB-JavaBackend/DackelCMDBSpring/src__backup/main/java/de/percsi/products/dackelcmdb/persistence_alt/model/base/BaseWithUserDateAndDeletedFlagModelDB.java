package de.percsi.products.dackelcmdb.persistence_alt.model.base;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
public class BaseWithUserDateAndDeletedFlagModelDB extends BaseModelDB implements Serializable {

    @Column(name="create_date", updatable = false)
    private Date createDate;
    @Column(name = "modification_date")
    private Date modificationDate;
    @Column(name = "create_user", updatable = false)
    private String createUser;
    @Column(name = "modification_user")
    private String modificationUser;
    @Column(name = "deleted")
    private Boolean deleted = false;
}
