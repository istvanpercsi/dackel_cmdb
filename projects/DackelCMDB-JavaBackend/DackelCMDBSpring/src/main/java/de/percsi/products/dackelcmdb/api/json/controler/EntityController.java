package de.percsi.products.dackelcmdb.api.json.controler;

import de.percsi.products.dackelcmdb.api.json.model.EntityModelJson;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/entities")
public class EntityController {

//    @RequestMapping(value = "/getEntityById/{id}")
//    public EntityModelJson getEntityById(@PathVariable(name = "id") long id) {
//        EntityModelJson e = EntityModelJson.builder()
//                .id(id)
//                .type("DatabaseConnection")
//                .name("Test")
//                .systemName("test")
//                .build();
//        return e;
//    }

}
