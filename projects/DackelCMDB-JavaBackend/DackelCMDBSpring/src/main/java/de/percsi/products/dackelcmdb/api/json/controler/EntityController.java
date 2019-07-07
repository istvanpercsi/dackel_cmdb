package de.percsi.products.dackelcmdb.api.json.controler;

import de.percsi.products.dackelcmdb.api.json.model.EntityJsonModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/entities")
public class EntityController {

    @RequestMapping(value = "/getEntityById/{id}")
    public EntityJsonModel getEntityById(@PathVariable(name = "id") long id) {
        EntityJsonModel e = EntityJsonModel.builder()
                .id(id)
                .type("DatabaseConnection")
                .name("Test")
                .systemName("test")
                .build();
        return e;
    }

}
