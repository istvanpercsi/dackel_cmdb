package de.percsi.products.dackelcmdb.services;

import de.percsi.products.dackelcmdb.api.json.messages.OperationalMessagesEnum;
import de.percsi.products.dackelcmdb.api.json.model.EntityModelJson;
import de.percsi.products.dackelcmdb.exceptions.RecordNotFoundDBException;

import de.percsi.products.dackelcmdb.persistence_alt.model.base.TablesConst;
import de.percsi.products.dackelcmdb.persistence_alt.repositories.ConnectorOfEntityPropertyValueRepository;
import de.percsi.products.dackelcmdb.persistence_alt.repositories.EntityRepository;
import io.vavr.control.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityServiceImpl implements EntityService {

  private EntityRepository entityRepository;

  private ConnectorOfEntityPropertyValueRepository connectorOfEntityPropertyValueRepository;

  @Autowired
  public EntityServiceImpl(EntityRepository entityRepository) {
    this.entityRepository = entityRepository;
  }

  @Override
  public void createEntity(EntityModelJson entityModelJson) {

  }

  @Override
  public EntityModelJson readEntity(Long id) {
//    return Option.ofOptional(entityRepository.findFirstById(id))
//        .map(EntityModelMapper.MAPPER::mapDbToJson)
//        .getOrElseThrow(() -> new RecordNotFoundDBException(
//            OperationalMessagesEnum.RECORD_NOT_FOUND_TABLE_ID.getMessage(Tables.ENTITIES,id.toString())
//    ));
    return null;
  }

  @Override
  public EntityModelJson readEntityWithProperties(Long id) {
//    return Option.ofOptional(entityRepository.findFirstByIdWithProperties(id))
//        .map(EntityMapper.MAPPER::mapDbToJsonWithProperties)
//        .getOrElseThrow(() -> new RecordNotFoundDBException(
//            OperationalMessagesEnum.RECORD_NOT_FOUND_TABLE_ID.getMessage(TablesConst.ENTITIES,id.toString())
//        ));
    return null;
  }

  @Override
  public void updateEntity(EntityModelJson entityModelJson) {

  }

  @Override
  public void deleteEntity(Long id) {

  }

  @Override
  public List<EntityModelJson> readAllEntity() {
    return null;
  }
}
