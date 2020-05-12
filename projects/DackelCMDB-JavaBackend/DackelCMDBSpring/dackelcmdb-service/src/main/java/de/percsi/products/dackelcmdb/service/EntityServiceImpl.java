package de.percsi.products.dackelcmdb.service;

import de.percsi.products.dackelcmdb.persistence.ConnectorEntityTypeOfEntityModelDB;
import de.percsi.products.dackelcmdb.persistence.ConnectorEntityTypeOfEntityRepositroy;
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

  private ConnectorEntityTypeOfEntityRepositroy connectorEntityTypeOfEntityRepositroy;

  @Autowired
  public EntityServiceImpl(
      ConnectorEntityTypeOfEntityRepositroy connectorEntityTypeOfEntityRepositroy,
      EntityDataMapper entityDataMapper,
      EntityDataRepository entityRepository) {
    this.entityDataRepository = entityRepository;
    this.connectorEntityTypeOfEntityRepositroy = connectorEntityTypeOfEntityRepositroy;
    this.entityDataMapper = entityDataMapper;
  }

  @Override
  public Entity createEntity(Entity entity) {
    return null;
  }

  @Override
  public Option<Entity> readEntity(Long id) {
    Option<ConnectorEntityTypeOfEntityModelDB> connectorEntityTypeOfEntityModelDB = Option.of(this.connectorEntityTypeOfEntityRepositroy.findByEntityId(id));
    if (connectorEntityTypeOfEntityModelDB.isDefined()) {
      return Option.of(entityDataMapper.mapDbToService(connectorEntityTypeOfEntityModelDB.get().getEntity(), connectorEntityTypeOfEntityModelDB.get().getTypeOfEntity()));
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
