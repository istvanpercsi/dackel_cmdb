package de.percsi.products.dackelcmdb.api.json.model;


import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class TypeOfEntityModelJson {

    private Long id;
    private String name;
    private String systemName;
    //private List<> _links;

}
