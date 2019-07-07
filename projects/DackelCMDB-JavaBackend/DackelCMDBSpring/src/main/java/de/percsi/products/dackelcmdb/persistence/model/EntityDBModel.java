package de.percsi.products.dackelcmdb.persistence.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@Getter
@Builder
public class EntityDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @ManyToOne
    @JoinColumn(name = "typeOfEntity", nullable = false)
    TypeOfEntityDBModel typeOfEntity;
    @NotNull
    private String name;
    @NotNull
    private String systemName;
    private Date createDate;
    private Date modificationDate;
    private String createUser;
    private String modificationUser;


}
