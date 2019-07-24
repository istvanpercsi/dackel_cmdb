package de.percsi.products.dackelcmdb.persistence.repositories;

import de.percsi.products.dackelcmdb.persistence.model.TypeOfEntityModelDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TypeOfEntityRepository extends JpaRepository<TypeOfEntityModelDB, Long> {

    @Query("SELECT toe FROM TypeOfEntityModelDB toe WHERE toe.deleted=false ")
    public Iterable<TypeOfEntityModelDB> findAllNotDeleted();
}
