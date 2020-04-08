package de.percsi.products.dackelcmdb.persistence;

import de.percsi.products.dackelcmdb.model.Entity;
import de.percsi.products.dackelcmdb.model.TypeOfEntity;
import de.percsi.products.dackelcmdb.persistence_alt.model.EntityModelDB;
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

    EntityDataModelDB entityDataModelDB = EntityMapper.MAPPER.mapInternalToDb(entity);
    entityDataModelDB.setMetaData(metaDataModelDB);

    try {
      entityDataModelDB = this.entityDataRepository.save(entityDataModelDB);

      return Option.of(EntityMapper.MAPPER.mapDBtoInternal(entityDataModelDB));
    } catch (Exception e) {
      return Option.none();
    }
  }

  @Override
  public Option<Entity> readEntityById(Long id) {
    try {
      Option<EntityDataModelDB> entityDataModelDBOption = Option.ofOptional(this.entityDataRepository.findById(id));
      return (entityDataModelDBOption.isDefined()) ? Option.of(EntityMapper.MAPPER.mapDBtoInternal(entityDataModelDBOption.get())) : Option.none();
    } catch (Exception e) {
      return Option.none();
    }
  }

  @Override
  public Option<Entity> readEntityByEntity(Entity entity) {
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
