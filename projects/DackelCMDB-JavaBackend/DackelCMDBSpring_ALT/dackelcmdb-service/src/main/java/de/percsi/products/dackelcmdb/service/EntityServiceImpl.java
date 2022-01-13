package de.percsi.products.dackelcmdb.service;

import de.percsi.products.dackelcmdb.api.json.messages.OperationalMessagesEnum;
import de.percsi.products.dackelcmdb.exceptions.StructuredRuntimeException;
import de.percsi.products.dackelcmdb.persistence.*;
import de.percsi.products.dackelcmdb.service.model.Entity;
import de.percsi.products.dackelcmdb.service.modelmapper.EntityDataMapper;
import io.vavr.control.Option;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class EntityServiceImpl implements EntityService {

  private EntityDataRepository entityDataRepository;

  private EntityDataMapper entityDataMapper;

  private ConnectorEntityTypeOfEntityRepositroy connectorEntityTypeOfEntityRepositroy;

  @Autowired
  public EntityServiceImpl(
      MetaDataRepository metaDataRepository,
      ConnectorEntityTypeOfEntityRepositroy connectorEntityTypeOfEntityRepositroy,
      EntityDataMapper entityDataMapper,
      EntityDataRepository entityRepository) {
    this.entityDataRepository = entityRepository;
    this.connectorEntityTypeOfEntityRepositroy = connectorEntityTypeOfEntityRepositroy;
    this.entityDataMapper = entityDataMapper;
  }

  @Override
  public Entity createEntity(@NotNull("'entity' cannot be null, this field is required.") Entity entity) {

    //check if id is defined, at new record it may not defined
    if (entity.getId().isDefined())
      throw StructuredRuntimeException.of(OperationalMessagesEnum.VALUE_MUST_BE.getMessage("id of entity","null"), HttpStatus.UNPROCESSABLE_ENTITY);

    //check if system name defined
    Option.of(entity.getSystemName()).getOrElseThrow(() -> StructuredRuntimeException.of(OperationalMessagesEnum.VALUE_CANNOT_BE.getMessage("systemName of entity", "null")));

    //check if record with system name exist in db already
    if (Option.of(this.entityDataRepository.findFirstBySystemName(entity.getSystemName())).isDefined())
      throw StructuredRuntimeException.of(OperationalMessagesEnum.RECORD_ALREADY_EXISTS_WITH_SYSTEMNAME.getMessage(Tables.ENTITY_DATA,entity.getSystemName()));

    //get type of entity
    EntityDataModelDB typeOfEntity =
        Option.ofOptional(this.entityDataRepository.findById(entity.getTypeOfEntity().getId().get())).get();

    EntityDataModelDB entityDataModelDB = this.entityDataMapper.mapServiceToDb(entity, createNewMetaData());
    //entityDataModelDB = this.entityDataRepository.save(entityDataModelDB);


    ConnectorEntityTypeOfEntityModelDB connectorEntityTypeOfEntityModelDB = this.connectorEntityTypeOfEntityRepositroy
        .save(ConnectorEntityTypeOfEntityModelDB.builder()
          .entity(entityDataModelDB)
          .typeOfEntity(EntityDataModelDB.builder()
              .id(typeOfEntity.getId())
              .metaData(MetaDataModelDB.builder()
                  .id(typeOfEntity.getId())
                  .build())
              .build()).build());
    return this.entityDataMapper.mapDbToService(connectorEntityTypeOfEntityModelDB.getEntity(),typeOfEntity);
  }

  private MetaDataModelDB createNewMetaData() {
    return MetaDataModelDB.builder()
        .id(null)
        .createUser("Test User")
        .createDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
        .modifyUser("Test mod user")
        .modifyDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
        .deleted(false)
        .build();
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
  public Entity updateEntity(@NotNull("'entity' cannot be null, this field is required.") Entity entity) {
    //check if id is defined, at new record it must be not defined
    if (!entity.getId().isDefined())
      throw StructuredRuntimeException.of(OperationalMessagesEnum.VALUE_CANNOT_BE.getMessage("id of entity","null"), HttpStatus.UNPROCESSABLE_ENTITY);

    //check if system name defined
    Option.of(entity.getSystemName()).getOrElseThrow(() -> StructuredRuntimeException.of(OperationalMessagesEnum.VALUE_CANNOT_BE.getMessage("systemName of entity", "null")));

    //check if record with system name exist in db already
    if (!Option.of(this.entityDataRepository.findById(entity.getId().get())).isDefined())
      throw StructuredRuntimeException.of(OperationalMessagesEnum.RECORD_NOT_FOUND_WITH_ID.getMessage(Tables.ENTITY_DATA,entity.getId().get().toString()));

    ConnectorEntityTypeOfEntityModelDB connectorEntityTypeOfEntityModelDB = connectorEntityTypeOfEntityRepositroy.findByEntityId(entity.getId().get());
    connectorEntityTypeOfEntityModelDB.getEntity().setDisplayName(entity.getName());
    connectorEntityTypeOfEntityModelDB.getEntity().setSystemName(entity.getSystemName());
    ConnectorEntityTypeOfEntityModelDB connectorEntityTypeOfEntityModelDBSaved = connectorEntityTypeOfEntityRepositroy.saveAndFlush(connectorEntityTypeOfEntityModelDB);

    return this.entityDataMapper.mapDbToService(connectorEntityTypeOfEntityModelDBSaved.getEntity(), connectorEntityTypeOfEntityModelDBSaved.getTypeOfEntity());
  }

  @Override
  public void deleteEntity(Long id) {

  }

  @Override
  public List<Entity> readAllEntity() {
    return null;
  }
}
