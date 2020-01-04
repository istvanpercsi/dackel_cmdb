package de.percsi.products.dackelcmdb.persistence.repositories;

import de.percsi.products.dackelcmdb.persistence.model.ConnectorOfEntityPropertyValueModelDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ConnectorOfEntityPropertyValueRepository extends JpaRepository<ConnectorOfEntityPropertyValueModelDB, Long> {

  @Query("SELECT c FROM ConnectorOfEntityPropertyValueModelDB c " +
      "JOIN FETCH c.entity e " +
      "JOIN FETCH c.property p " +
      "JOIN FETCH c.valueNumber vn " +
      "JOIN FETCH c.valueString vs " +
      "WHERE e.id = :id")
  Optional<ConnectorOfEntityPropertyValueModelDB> findFirstByEntityId(@Param("id") Long id);
}
