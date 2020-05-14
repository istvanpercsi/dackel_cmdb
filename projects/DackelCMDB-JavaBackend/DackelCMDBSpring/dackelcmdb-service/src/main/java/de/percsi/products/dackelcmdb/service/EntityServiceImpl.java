package de.percsi.products.dackelcmdb.service;

import de.percsi.products.dackelcmdb.api.json.messages.OperationalMessagesEnum;
import de.percsi.products.dackelcmdb.persistence.*;
import de.percsi.products.dackelcmdb.service.model.Entity;
import de.percsi.products.dackelcmdb.service.modelmapper.EntityDataMapper;
import io.vavr.control.Option;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
    log.warn(OperationalMessagesEnum.RECORD_NOT_FOUND_WITH_ID.getMessage(Tables.ENTITY_DATA,id.toString()).getMessageText());
    return Option.none();
  }

  @Override
  public Option<Entity> readEntityWithProperties(Long id) {
    Option<Entity> entity = readEntity(id);
    if (entity.isDefined()) {
      log.info("found");
      //get properties and map
      return entity;
    }
    return Option.none();
  }

  @Override
  public Entity updateEntity(Entity entity) {


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
