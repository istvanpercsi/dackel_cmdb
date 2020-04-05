package de.percsi.products.dackelcmdb.persistence;

import de.percsi.products.dackelcmdb.model.Entity;
import de.percsi.products.dackelcmdb.model.TypeOfEntity;
import io.vavr.collection.Set;
import io.vavr.control.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class EntityRepositoryImpl implements EntityRepository {

  private EntityDataRepository entityDataRepository;

  @Autowired
  public EntityRepositoryImpl(EntityDataRepository entityDataRepository) {
    this.entityDataRepository = entityDataRepository;
  }


  @Override
  public Option<Entity> createEntity(Entity entity) {
    return Option.none();
  }

  @Override
  public Option<Entity> readEntityById(Long id) {
    return null;
  }

  @Override
  public Set<Entity> readEntitiesByType(TypeOfEntity typeOfEntity) {
    return null;
  }

  @Override
  public Option<Entity> updateNameOfEntity(String nameOfEntity) {
    return null;
  }

  @Override
  public Option<Entity> updateTypeOfEntity(TypeOfEntity typeOfEntity) {
    return null;
  }

  @Override
  public void deleteEntity() {

  }
}
