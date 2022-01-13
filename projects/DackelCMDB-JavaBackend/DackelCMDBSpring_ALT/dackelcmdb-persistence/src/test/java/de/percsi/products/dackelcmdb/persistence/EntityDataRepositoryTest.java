package de.percsi.products.dackelcmdb.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EntityDataRepositoryTest {

  @Autowired
  MetaDataRepository metaDataRepository;

  @Autowired
  EntityDataRepository entityDataRepository;

  MetaDataModelDB metaDataModelDBMock = MetaDataModelDB.builder()
      .id(null)
      .createDate(new Date(System.currentTimeMillis()))
      .modifyDate(new Date(System.currentTimeMillis()))
      .createUser("test-user")
      .modifyUser("test-user-m")
      .deleted(false)
      .build();


  @Test
  public void testSaveAndRead() {
    MetaDataModelDB metaDataModelDBSaved = metaDataRepository.save(metaDataModelDBMock);
    EntityDataModelDB entityDataModelDBMock = EntityDataModelDB.builder()
        .displayName("TestEntity")
        .systemName("test-entity")
        .metaData(metaDataModelDBSaved)
        .build();

    EntityDataModelDB entityDataModelDBSaved = entityDataRepository.save(entityDataModelDBMock);

    EntityDataModelDB entityDataModelDBRead = entityDataRepository.findFirstBySystemName(entityDataModelDBMock.getSystemName());

    assertNotNull(entityDataModelDBSaved);
    assertEquals(entityDataModelDBSaved.getId(), metaDataModelDBSaved.getId());
    assertEquals(entityDataModelDBSaved.getMetaData(), metaDataModelDBSaved);
  }
}