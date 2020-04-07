package de.percsi.products.dackelcmdb.persistence;

import de.percsi.products.dackelcmdb.model.Entity;
import de.percsi.products.dackelcmdb.model.TypeOfEntity;
import io.vavr.collection.Set;
import io.vavr.control.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.ZoneId;
import java.util.Date;

@Repository
public class EntityRepositoryImpl implements EntityRepository {

  private MetaDataRepository metaDataRepository;

  private EntityDataRepository entityDataRepository;

  @Autowired
  public EntityRepositoryImpl(MetaDataRepository metaDataRepository,
                              EntityDataRepository entityDataRepository) {
    this.metaDataRepository = metaDataRepository;
    this.entityDataRepository = entityDataRepository;
  }


  @Override
  public Option<Entity> createEntity(Entity entity) {

      MetaDataModelDB metaDataModelDB = MetaDataModelDB.builder()
          .createUser("test")
          .createDate(new Date())
          .modifyUser("test")
          .modifyDate(new Date())
          .deleted(false)
          .build();

      EntityDataModelDB entityDataModelDB = EntityDataModelDB.builder()
          .displayName(entity.getName())
          .systemName(entity.getSystemName())
          .type(EntityDataType.ENTITY)
          .metaData(metaDataModelDB)
          .build();

    try {
      entityDataModelDB = this.entityDataRepository.save(entityDataModelDB);

      return Option.of(Entity.builder().id(Option.of(entityDataModelDB.getId()))
          .name(entityDataModelDB.getDisplayName())
          .systemName(entityDataModelDB.getSystemName())
          .createUser(entityDataModelDB.getMetaData().getCreateUser())
          .createDateTime(entityDataModelDB.getMetaData().getCreateDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
          .modifyUser(entityDataModelDB.getMetaData().getModifyUser())
          .modifyDateTime(entityDataModelDB.getMetaData().getModifyDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
          .build());
    } catch (Exception e) {
      return Option.none();
    }
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
  public void deleteEntity(Entity entity) {
    if (entity.getId().isDefined()) {
      entityDataRepository.deleteById(entity.getId().get());
    }
  }
}
