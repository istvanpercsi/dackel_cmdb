package de.percsi.products.dackelcmdb.persistence_alt.repositories;

import de.percsi.products.dackelcmdb.persistence_alt.model.ValueOfPropertyOfEntityModelDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectorOfEntityPropertyValueRepository extends JpaRepository<ValueOfPropertyOfEntityModelDB, Long> {

//  @Query("SELECT c FROM ValueOfPropertyOfEntityModelDB c " +
//      "JOIN FETCH c.entity e " +
//      "JOIN FETCH c.property p " +
//      "JOIN FETCH c.valueNumber vn " +
//      "JOIN FETCH c.valueString vs " +
//      "WHERE e.id = :id")
//  Optional<ValueOfPropertyOfEntityModelDB> findFirstByEntityId(@Param("id") Long id);


//  public  enum  SmartReturn {
//
//    IntegerType, DoubleType;
//
//    @SuppressWarnings("unchecked")
//    public <T> T comeback(String value) {
//      switch (this) {
//        case IntegerType:
//          return (T) Integer.valueOf(value);
//        case DoubleType:
//          return (T) Double.valueOf(value);
//        default:
//          return null;
//      }
//    }
//  }
//
//  Unit Test:
//
//  public class MultipleReturnTypeTest {
//
//    @Test
//    public void returnIntegerOrString() {
//      Assert.assertTrue(SmartReturn.IntegerType.comeback("1") instanceof Integer);
//      Assert.assertTrue(SmartReturn.DoubleType.comeback("1") instanceof Double);
//    }
//
//  }
} 
