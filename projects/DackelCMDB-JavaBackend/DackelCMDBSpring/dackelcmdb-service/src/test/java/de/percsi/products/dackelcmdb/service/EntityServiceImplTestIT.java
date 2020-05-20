package de.percsi.products.dackelcmdb.service;

import de.percsi.products.dackelcmdb.persistence.ConnectorEntityTypeOfEntityRepositroy;
import de.percsi.products.dackelcmdb.service.configuration.ServiceConfiguration;
import de.percsi.products.dackelcmdb.service.model.Entity;
import de.percsi.products.dackelcmdb.service.model.TypeOfEntity;
import io.vavr.control.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceConfiguration.class)
@ActiveProfiles({"testIT"})
public class EntityServiceImplTestIT {

  @Autowired
  EntityService entityService;

  @Test
  public void readEntityTest_OK() {

    //arrange
    //database default data via data.sql

    //act
    Option<Entity> entity = entityService.readEntity(2L);

    //assert
    assertTrue(entity.isDefined());

  }

  @Test
  public void readEntityTest_NOK() {
    //arrange
    //h2 database default data via data.sql

    //act
    Option<Entity> entity = entityService.readEntity(9999999L);

    //assert
    assertFalse(entity.isDefined());

  }

  @Test
  public void createEntity_OK() {
    //arrange
    Entity entity = Entity.builder()
        .id(Option.none())
        .name("Test name")
        .systemName("test_name")
        .typeOfEntity(TypeOfEntity.builder()
            .id(Option.of(1L))
            .build())
        .build();
    //act
    Entity created = this.entityService.createEntity(entity);

    //assert
    assertNotNull(created);
    assertEquals(entity.getId(),created.getId());
    assertEquals(entity.getName(),created.getName());
    assertEquals(entity.getSystemName(),created.getSystemName());
    assertEquals(entity.getTypeOfEntity().getId(), created.getTypeOfEntity().getId());
    assertNotNull(entity.getCreateUser());
    assertNotNull(entity.getCreateDateTime());
    assertNotNull(entity.getModifyDateTime());
    assertNotNull(entity.getModifyUser());

  }
}