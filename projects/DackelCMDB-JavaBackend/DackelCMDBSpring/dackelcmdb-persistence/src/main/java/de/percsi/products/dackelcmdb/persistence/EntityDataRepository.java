package de.percsi.products.dackelcmdb.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityDataRepository extends JpaRepository<EntityDataModelDB,Long> {

  EntityDataModelDB findFirstBySystemName(String systemName);

}
