package de.percsi.products.dackelcmdb.persistence;

import de.percsi.products.dackelcmdb.model.Entity;
import de.percsi.products.dackelcmdb.persistence_alt.model.EntityModelDB;
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

  @Test
  public void readEntityByEntity() {
    //arrange
    Entity entity = Entity.builder().name("Test name").systemName("test_name").build();
    Option<Entity> createResult = entityRepository.createEntity(entity);
    assertTrue(createResult.isDefined());

    //act
    Option<Entity> testResult = entityRepository.readEntityByEntity(createResult.get());

    //assert
    assertTrue(testResult.isDefined());
    assertEquals(createResult, testResult);

  }

  @Test
  public void updateNameOfEntity() {
    //arrange
    String originalName = "Test name";
    String modifiedName = "Test2 name2";
    Entity entity = Entity.builder().name(originalName).systemName("test_name").build();
    Option<Entity> createResult = entityRepository.createEntity(entity);
    assertTrue(createResult.isDefined());
    assertTrue(createResult.get().getId().isDefined());
    Long id = createResult.get().getId().get();
    
    //act
    Option<Entity> testResult = entityRepository.updateNameOfEntity(id, modifiedName);

    //assert
    assertTrue(testResult.isDefined());
    Option<EntityDataModelDB> entityModelDBOption = Option.ofOptional(entityDataRepository.findById(id));
    assertTrue(entityModelDBOption.isDefined());
    assertEquals(modifiedName,entityModelDBOption.get().getDisplayName());
    Option<MetaDataModelDB> metaDataModelDBOption = Option.ofOptional(metaDataRepository.findById(id));
    assertTrue(metaDataModelDBOption.isDefined());
    assertTrue(metaDataModelDBOption.get().getCreateDate().compareTo(metaDataModelDBOption.get().getModifyDate()) < 0);

  }
}