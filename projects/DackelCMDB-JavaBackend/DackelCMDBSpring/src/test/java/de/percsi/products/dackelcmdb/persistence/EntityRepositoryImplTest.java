package de.percsi.products.dackelcmdb.persistence;

import de.percsi.products.dackelcmdb.model.Entity;
import io.vavr.control.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityRepositoryImplTest {

  @Autowired
  EntityRepositoryImpl entityRepository;

  @Test
  public void createEntity() {
    //arrange
    Entity entity = Entity.builder().name("Test name").systemName("test_name").build();
    //act
    Option<Entity> result = entityRepository.createEntity(entity);
    //assert
    assertTrue(result.isDefined());
    assertEquals(result.get().getName(),entity.getName());
  }
}