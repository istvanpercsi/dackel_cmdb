package de.percsi.products.dackelcmdb.persistence.repositories;

import de.percsi.products.dackelcmdb.persistence.model.EntityModelDB;
import org.springframework.data.repository.CrudRepository;

public interface EntityRepository extends CrudRepository<EntityModelDB, Long> {
}
