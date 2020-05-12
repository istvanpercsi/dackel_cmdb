package de.percsi.products.dackelcmdb.service;

import de.percsi.products.dackelcmdb.persistence.ConnectorEntityTypeOfEntityRepositroy;
import de.percsi.products.dackelcmdb.service.configuration.ServiceConfiguration;
import de.percsi.products.dackelcmdb.service.model.Entity;
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
  public void readEntityTest() {

    //arrange

    //act
    Option<Entity> entity = entityService.readEntity(2L);

    //assert
    assertTrue(entity.isDefined());

  }

}