package de.percsi.products.dackelcmdb.persistence.repositories;

import de.percsi.products.dackelcmdb.persistence.model.EntityModelDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EntityRepository extends JpaRepository<EntityModelDB, Long> {

  Optional<EntityModelDB> findFirstById(Long id);

  @Query("SELECT e FROM EntityModelDB e " +
      "JOIN FETCH e.valueOfPropertyOfEntityModelDBS v " +
      "JOIN FETCH v.property " +
      "WHERE e.id = :id")
  Optional<EntityModelDB> findFirstByIdWithProperties(@Param("id") Long id);

}
