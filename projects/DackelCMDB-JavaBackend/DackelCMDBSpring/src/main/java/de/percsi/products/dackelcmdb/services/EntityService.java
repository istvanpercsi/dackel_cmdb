package de.percsi.products.dackelcmdb.services;

import de.percsi.products.dackelcmdb.api.json.model.EntityModelJson;

import java.util.List;

public interface EntityService {

  void createEntity(EntityModelJson entityModelJson);

  EntityModelJson readEntity(Long id);

  EntityModelJson readEntityWithProperties(Long id);

  void updateEntity(EntityModelJson entityModelJson);

  void deleteEntity(Long id);

  List<EntityModelJson> readAllEntity();

}
