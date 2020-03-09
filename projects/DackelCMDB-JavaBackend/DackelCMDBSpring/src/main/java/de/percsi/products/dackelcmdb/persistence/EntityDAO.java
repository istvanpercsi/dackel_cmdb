package de.percsi.products.dackelcmdb.persistence;

public interface EntityDAO {

  void createEntity();

  void readEntityById();

  void readEntitiesByType();

  void updateNameOfEntity(String nameOfEntity);

  void updateTypeOfEntity();

  void deleteEntity();




}
