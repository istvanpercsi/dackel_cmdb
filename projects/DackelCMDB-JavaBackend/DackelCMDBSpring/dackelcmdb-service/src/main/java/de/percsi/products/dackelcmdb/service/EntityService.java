package de.percsi.products.dackelcmdb.service;

import de.percsi.products.dackelcmdb.service.model.Entity;
import io.vavr.control.Option;

import java.util.List;

public interface EntityService {

  Entity createEntity(Entity entityModelJson);

  Option<Entity> readEntity(Long id);

  Option<Entity> readEntityWithProperties(Long id);

  Entity updateEntity(Entity entity);

  void deleteEntity(Long id);

  List<Entity> readAllEntity();

}
