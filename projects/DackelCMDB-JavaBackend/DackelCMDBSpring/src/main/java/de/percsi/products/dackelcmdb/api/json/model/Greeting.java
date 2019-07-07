package de.percsi.products.dackelcmdb.api.json.model;

import lombok.Builder;
import lombok.Data;

@Data
public class Greeting {

    private final long id;
    private final String content;

}
