package de.percsi.products.dackelcmdb.service;

import de.percsi.products.dackelcmdb.persistence.EntityDataModelDB;
import de.percsi.products.dackelcmdb.persistence.EntityDataRepository;
import de.percsi.products.dackelcmdb.service.model.Entity;
import de.percsi.products.dackelcmdb.service.modelmapper.EntityDataMapper;
import io.vavr.control.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityServiceImpl implements EntityService {

  private EntityDataRepository entityDataRepository;

  private EntityDataMapper entityDataMapper;

  //private ConnectorOfEntityPropertyValueRepository connectorOfEntityPropertyValueRepository;

  @Autowired
  public EntityServiceImpl(EntityDataRepository entityRepository) {
    this.entityDataRepository = entityRepository;
  }

  @Override
  public Entity createEntity(Entity entity) {
    return null;
  }

  @Override
  public Option<Entity> readEntity(Long id) {
    Option<EntityDataModelDB> entityDataModelDB  = Option.ofOptional(entityDataRepository.findById(id));
    if (entityDataModelDB.isDefined()) {
      return Option.of(entityDataMapper.mapDbToService(entityDataModelDB.get()));
    }
    return Option.none();
  }

  @Override
  public Entity readEntityWithProperties(Long id) {
//    return Option.ofOptional(entityRepository.findFirstByIdWithProperties(id))
//        .map(EntityMapper.MAPPER::mapDbToJsonWithProperties)
//        .getOrElseThrow(() -> new RecordNotFoundDBException(
//            OperationalMessagesEnum.RECORD_NOT_FOUND_TABLE_ID.getMessage(TablesConst.ENTITIES,id.toString())
//        ));
    return null;
  }

  @Override
  public Entity updateEntity(Entity entityModelJson) {
    return null;
  }

  @Override
  public void deleteEntity(Long id) {

  }

  @Override
  public List<Entity> readAllEntity() {
    return null;
  }
}
