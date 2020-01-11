package de.percsi.products.dackelcmdb.persistence.repositories;

import de.percsi.products.dackelcmdb.persistence.model.EntityModelDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EntityRepository extends JpaRepository<EntityModelDB, Long> {

  Optional<EntityModelDB> findFirstById(Long id);

  @Query("SELECT e FROM EntityModelDB e " +
      "JOIN FETCH e.connectorOfEntityPropertyValueModelDBS conn " +
      "JOIN FETCH conn.property")
  Optional<EntityModelDB> findFirstByIdWithProperties(Long id);

}
