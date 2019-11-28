package de.percsi.products.dackelcmdb.persistence.model.base;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
public class BaseModelDB implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;



}
