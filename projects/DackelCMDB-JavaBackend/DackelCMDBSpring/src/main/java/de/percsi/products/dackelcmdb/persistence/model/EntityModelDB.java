package de.percsi.products.dackelcmdb.persistence.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "entities")

@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@Getter
public class EntityModelDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    long id;
    @ManyToOne
    @JoinColumn(name = "type_of_entity_id", nullable = false)
    TypeOfEntityModelDB typeOfEntity;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "system_name", nullable = false)
    private String systemName;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "modification_date")
    private Date modificationDate;
    @Column(name = "create_user")
    private String createUser;
    @Column(name = "modification_user")
    private String modificationUser;

}
