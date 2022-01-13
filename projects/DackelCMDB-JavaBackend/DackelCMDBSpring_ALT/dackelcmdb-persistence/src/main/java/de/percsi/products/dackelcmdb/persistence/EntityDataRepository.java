package de.percsi.products.dackelcmdb.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityDataRepository extends JpaRepository<EntityDataModelDB,Long> {

  EntityDataModelDB findFirstBySystemName(String systemName);

}
