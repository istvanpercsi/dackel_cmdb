package de.percsi.products.dackelcmdb.services;

import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJson;

import java.util.List;

public interface TypeOfEntityService {

  void createTypeOfEntity(TypeOfEntityModelJson typeOfEntityModelJson);

  void updateTypeOfEntity(TypeOfEntityModelJson typeOfEntityModelJson);

  TypeOfEntityModelJson readTypeOfEntity(Long id);

  void deleteTypeOfEntity(Long id);

  List<TypeOfEntityModelJson> readAllTypeOfEntity();
}
