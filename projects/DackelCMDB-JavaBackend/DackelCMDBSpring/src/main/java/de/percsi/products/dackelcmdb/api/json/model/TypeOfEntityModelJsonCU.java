package de.percsi.products.dackelcmdb.api.json.model;


import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class TypeOfEntityModelJsonCU {

    @Builder.Default
    private Long id = Long.valueOf(0);
    private String name;
    private String systemName;
    //private List<> _links;

}
