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
    @Column(name = "id")
    private long id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="system_name", nullable = false)
    private String systemName;
    @Column(name="create_date")
    private Date createDate;
    @Column(name = "modification_date")
    private Date modificationDate;
    @Column(name = "create_user")
    private String createUser;
    @Column(name = "modification_user")
    private String modificationUser;

    @OneToMany(mappedBy = "typeOfEntity", fetch = FetchType.LAZY)
    private Set<EntityDBModel> entities;

}
