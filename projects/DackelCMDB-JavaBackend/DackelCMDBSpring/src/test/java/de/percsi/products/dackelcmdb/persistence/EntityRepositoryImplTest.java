package de.percsi.products.dackelcmdb.persistence;

import de.percsi.products.dackelcmdb.model.Entity;
import io.vavr.control.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityRepositoryImplTest {

  @Autowired
  EntityRepositoryImpl entityRepository;

  @Autowired
  MetaDataRepository metaDataRepository;

  @Autowired
  EntityDataRepository entityDataRepository;

  @Test
  public void createEntity() {
    //arrange
    Entity entity = Entity.builder().name("Test name").systemName("test_name").build();
    //act
    Option<Entity> result = entityRepository.createEntity(entity);
    //assert
    assertTrue(result.isDefined());
    assertTrue(result.get().getId().isDefined());
    assertEquals(entity.getName(), result.get().getName());
    assertEquals(entity.getSystemName(), result.get().getSystemName());
    assertNotNull(result.get().getCreateDateTime());
    assertNotNull(result.get().getModifyDateTime());
  }

  @Test
  public void deleteEntity() {
    //arrange
    Entity entity = Entity.builder().name("Test name").systemName("test_name").build();
    Option<Entity> createResult = entityRepository.createEntity(entity);
    assertTrue(createResult.isDefined());
    assertTrue(createResult.get().getId().isDefined());

    //act
    entityRepository.deleteEntity(createResult.get());

    //assert
    assertTrue(createResult.isDefined());
    assertTrue(createResult.get().getId().isDefined());
    long id = createResult.get().getId().get();
    Option<EntityDataModelDB> entityDataModelDBOption = Option.ofOptional(entityDataRepository.findById(id));
    assertFalse(entityDataModelDBOption.isDefined());
    Option<MetaDataModelDB> metaDataModelDBOption = Option.ofOptional(metaDataRepository.findById(id));
    assertFalse(metaDataModelDBOption.isDefined());
  }

  @Test
  public void readEntityById() {
    //arrange
    Entity entity = Entity.builder().name("Test name").systemName("test_name").build();
    Option<Entity> createResult = entityRepository.createEntity(entity);
    assertTrue(createResult.isDefined());
    assertTrue(createResult.get().getId().isDefined());
    long id = createResult.get().getId().get();

    //act
    Option<Entity> testResult = entityRepository.readEntityById(id);

    //assert
    assertTrue(testResult.isDefined());
    assertEquals(createResult,testResult);

  }
}