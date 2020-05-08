package de.percsi.products.dackelcmdb.service;

import de.percsi.products.dackelcmdb.service.model.TypeOfEntity;

import java.util.List;

public interface TypeOfEntityService {

  TypeOfEntity createTypeOfEntity(TypeOfEntity typeOfEntityModelJson);

  TypeOfEntity updateTypeOfEntity(TypeOfEntity typeOfEntityModelJson);

  TypeOfEntity readTypeOfEntity(Long id);

  void deleteTypeOfEntity(Long id);

  List<TypeOfEntity> readAllTypeOfEntity();
}
