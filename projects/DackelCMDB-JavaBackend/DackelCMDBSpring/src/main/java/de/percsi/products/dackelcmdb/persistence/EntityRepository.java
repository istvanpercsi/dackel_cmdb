package de.percsi.products.dackelcmdb.persistence;

import de.percsi.products.dackelcmdb.model.Entity;
import de.percsi.products.dackelcmdb.model.TypeOfEntity;
import io.vavr.collection.Set;
import io.vavr.control.Option;


public interface EntityRepository {

  Option<Entity> createEntity(Entity entity);

  Option<Entity> readEntityById(Long id);

  Set<Entity> readEntitiesByType(TypeOfEntity typeOfEntity);

  Option<Entity> updateNameOfEntity(String nameOfEntity);

  Option<Entity> updateTypeOfEntity(TypeOfEntity typeOfEntity);

  void deleteEntity();




}
