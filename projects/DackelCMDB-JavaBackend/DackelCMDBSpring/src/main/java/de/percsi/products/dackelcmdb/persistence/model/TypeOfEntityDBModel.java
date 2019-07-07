package de.percsi.products.dackelcmdb.persistence.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@Getter
@Builder
public class TypeOfEntityDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String systemName;
    private Date createDate;
    private Date modificationDate;
    private String createUser;
    private String modificationUser;

    @OneToMany(mappedBy = "typeOfEntity", fetch = FetchType.LAZY)
    private Set<EntityDBModel> entities;

}
