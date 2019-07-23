package de.percsi.products.dackelcmdb.api.json.model;

import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class EntityModelJson {

    private long id;
    private String type;
    private String name;
    private String systemName;
    private Date createDate;
    private Date modificationDate;
    private String createUser;
    private String modificationUser;



}
