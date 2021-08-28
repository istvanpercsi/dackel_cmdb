package de.percsi.products.dackelcmdb.persistence;

import io.vavr.control.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MetaDataRepositoryTest {

  @Autowired
  MetaDataRepository metaDataRepository;

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

    assertNotNull(metaDataModelDBSaved);
    assertNotNull(metaDataModelDBSaved.getId());

    Option<MetaDataModelDB> metaDataModelDBRead = Option.ofOptional(metaDataRepository.findById(metaDataModelDBSaved.getId()));

    assertTrue(metaDataModelDBRead.isDefined());
    assertEquals(metaDataModelDBRead.get().getCreateDate(), metaDataModelDBMock.getCreateDate());
    assertEquals(metaDataModelDBRead.get().getModifyDate(), metaDataModelDBMock.getModifyDate());
    assertEquals(metaDataModelDBRead.get().getCreateUser(), metaDataModelDBMock.getCreateUser());
    assertEquals(metaDataModelDBRead.get().getModifyUser(), metaDataModelDBMock.getModifyUser());
    assertEquals(metaDataModelDBRead.get().getDeleted(), metaDataModelDBMock.getDeleted());

  }

}