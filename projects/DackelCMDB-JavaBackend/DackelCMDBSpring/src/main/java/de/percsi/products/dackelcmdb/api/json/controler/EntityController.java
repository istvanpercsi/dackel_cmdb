package de.percsi.products.dackelcmdb.api.json.controler;

import de.percsi.products.dackelcmdb.api.json.model.EntityModelJson;
import de.percsi.products.dackelcmdb.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/entities")
public class EntityController {

  private EntityService entityService;

  @Autowired
  EntityController(EntityService entityService) {
    this.entityService = entityService;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public EntityModelJson getEntityById(@PathVariable(name = "id") long id) {
    EntityModelJson e = entityService.readEntityWithProperties(id);
    return e;
  }

}
