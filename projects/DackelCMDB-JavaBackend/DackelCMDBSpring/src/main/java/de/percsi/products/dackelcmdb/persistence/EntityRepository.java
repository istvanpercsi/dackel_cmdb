package de.percsi.products.dackelcmdb.persistence;

import de.percsi.products.dackelcmdb.model.Entity;
import de.percsi.products.dackelcmdb.model.TypeOfEntity;
import io.vavr.collection.Set;
import io.vavr.control.Option;


public interface EntityRepository {

  Option<Entity> createEntity(Entity entity);

  Option<Entity> readEntityById(Long id);

  Option<Entity> readEntityByEntity(Entity entity);

  Set<Entity> readEntitiesByType(TypeOfEntity typeOfEntity);

  Option<Entity> updateEntity(Entity entity);

  Option<Entity> updateNameOfEntity(Long id, String name);

  Option<Entity> updateTypeOfEntity(Long id, TypeOfEntity typeOfEntity);

  void deleteEntity(Entity entity);




}
