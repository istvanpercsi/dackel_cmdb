package de.percsi.products.dackelcmdb.persistence.repositories;

import de.percsi.products.dackelcmdb.persistence.model.ValueOfPropertyOfEntityModelDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ConnectorOfEntityPropertyValueRepository extends JpaRepository<ValueOfPropertyOfEntityModelDB, Long> {

  @Query("SELECT c FROM ValueOfPropertyOfEntityModelDB c " +
      "JOIN FETCH c.entity e " +
      "JOIN FETCH c.property p " +
      "JOIN FETCH c.valueNumber vn " +
      "JOIN FETCH c.valueString vs " +
      "WHERE e.id = :id")
  Optional<ValueOfPropertyOfEntityModelDB> findFirstByEntityId(@Param("id") Long id);
}
