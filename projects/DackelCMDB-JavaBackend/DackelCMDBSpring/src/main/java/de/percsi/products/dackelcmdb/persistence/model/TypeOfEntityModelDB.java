package de.percsi.products.dackelcmdb.persistence.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "types_of_entity")

@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@Getter
public class TypeOfEntityModelDB implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
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
    @Column(name = "deleted")
    @Builder.Default
    private Boolean deleted = false;

    @OneToMany(mappedBy = "typeOfEntity", fetch = FetchType.LAZY)
    private Set<EntityModelDB> entities;

}
