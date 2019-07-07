package de.percsi.products.dackelcmdb.api.json.model;


import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class TypeOfEntityJsonModel {

    private long id;
    private String name;
    private String systemName;
    private Date createDate;
    private Date modificationDate;
    private String createUser;
    private String modificationUser;


}
