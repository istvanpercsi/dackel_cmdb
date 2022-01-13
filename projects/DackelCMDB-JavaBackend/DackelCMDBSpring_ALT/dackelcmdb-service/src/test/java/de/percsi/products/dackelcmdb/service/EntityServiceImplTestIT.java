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

import java.util.Objects;

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
    Entity basisEntity = Entity.builder()
        .id(Option.none())
        .name("Test name")
        .systemName("test_name")
        .typeOfEntity(TypeOfEntity.builder()
            .id(Option.of(1L))
            .build())
        .build();
    //act
    Entity createdEntity = this.entityService.createEntity(basisEntity);

    //assert
    assertNotNull(createdEntity);
    assertNotEquals(basisEntity.getId(),createdEntity.getId());
    assertEquals(basisEntity.getName(),createdEntity.getName());
    assertEquals(basisEntity.getSystemName(),createdEntity.getSystemName());
    assertEquals(basisEntity.getTypeOfEntity().getId(), createdEntity.getTypeOfEntity().getId());
    assertNotNull(createdEntity.getCreateUser());
    assertNotNull(createdEntity.getCreateDateTime());
    assertNotNull(createdEntity.getModifyDateTime());
    assertNotNull(createdEntity.getModifyUser());

  }

  @Test
  public void updateEntity() {
    //arrange
    //default data from resources/data.sql
    Option<Entity> originalEntityOption = this.entityService.readEntity(2L);
    assertTrue(originalEntityOption.isDefined());
    Entity originalEntity = originalEntityOption.get();

    Entity modifiedEntity = Entity.builder()
        .id(Option.of(2L))
        .name("test_name")
        .systemName("test_name")
        .build();

    //act
    Entity resultEntity = this.entityService.updateEntity(modifiedEntity);

    //assert
    assertNotNull(resultEntity);
    assertEquals(originalEntity.getId(), resultEntity.getId());
    assertNotEquals(originalEntity.getName(), resultEntity.getName());
    assertNotEquals(originalEntity.getSystemName(), resultEntity.getSystemName());
    assertEquals(originalEntity.getCreateDateTime(), resultEntity.getCreateDateTime());
    assertEquals(originalEntity.getCreateUser(), resultEntity.getCreateUser());
    assertNotEquals(originalEntity.getModifyUser(), resultEntity.getModifyUser());
    assertNotEquals(originalEntity.getModifyDateTime(), resultEntity.getModifyDateTime());
    assertEquals(originalEntity.getTypeOfEntity(), resultEntity.getTypeOfEntity());

  }
}