package de.percsi.products.dackelcmdb.services;

import de.percsi.products.dackelcmdb.api.json.model.EntityModelJson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityServiceImpl implements EntityService {
  @Override
  public void createEntity(EntityModelJson entityModelJson) {

  }

  @Override
  public EntityModelJson readEntity(Long id) {
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
