package de.percsi.products.dackelcmdb.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

//import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJson;
//import de.percsi.products.dackelcmdb.exceptions.RecordAlreadyExistsDBException;
//import de.percsi.products.dackelcmdb.exceptions.RecordNotFoundDBException;
//import de.percsi.products.dackelcmdb.persistence_alt.model.TypeOfEntityModelDB;
//import de.percsi.products.dackelcmdb.persistence_alt.repositories.TypeOfEntityRepository;
//import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class TypeOfEntityServiceImplTest {
//
//  @Mock
//  private TypeOfEntityRepository typeOfEntityRepository;
//
//  @InjectMocks
//  private TypeOfEntityServiceImpl typeOfEntityService = new TypeOfEntityServiceImpl(typeOfEntityRepository);
//
//  ArgumentCaptor<TypeOfEntityModelDB> typeOfEntityModelDBArgumentCaptor = ArgumentCaptor.forClass(TypeOfEntityModelDB.class);
//
//  private TypeOfEntityModelJson typeOfEntityModelJson;

//  @Before
//  public void prepareTest() {
//    typeOfEntityModelJson = TypeOfEntityModelJson.builder()
//          .id(1L)
//          .systemName("system_name_test")
//          .name("name_test")
//          .build();
//  }

  @Test//(expected = RecordAlreadyExistsDBException.class)
  public void testCreateTypeOfEntityIfIdExists() {
//    //arrange
//    TypeOfEntityModelDB typeOfEntityModelDB = mock(TypeOfEntityModelDB.class);
//    when(typeOfEntityRepository.findFirstByIdAndSystemName(anyLong(),anyString()))
//          .thenAnswer((Answer<Optional<TypeOfEntityModelDB>>) invocationOnMock -> Optional.of(typeOfEntityModelDB));
//    //act
//    typeOfEntityService.createTypeOfEntity(typeOfEntityModelJson);
//    //assert
//  }
//
//  @Test(expected = RecordAlreadyExistsDBException.class)
//  public void testCreateTypeOfEntityIfSystemNameExists() {
//    //arrange
//    TypeOfEntityModelDB typeOfEntityModelDB = mock(TypeOfEntityModelDB.class);
//    when(typeOfEntityRepository.findFirstByIdAndSystemName(anyLong(),anyString()))
//          .thenAnswer(invocationOnMock -> Optional.of(typeOfEntityModelDB));
//    //act
//    typeOfEntityService.createTypeOfEntity(typeOfEntityModelJson);
//
//    //assert
//  }
//
//  @Test
//  public void testCreateTypeOfEntityNoException() {
//    //arrange
//    TypeOfEntityModelJson typeOfEntityModelJson = TypeOfEntityModelJson.builder()
//          .id(null)
//          .name("test-name")
//          .systemName("test-system-name")
//          .build();
//    doAnswer(invocationOnMock -> null).when(typeOfEntityRepository).save(typeOfEntityModelDBArgumentCaptor.capture());
//
//    //act
//    typeOfEntityService.createTypeOfEntity(typeOfEntityModelJson);
//
//    //assert
//    assertEquals(typeOfEntityModelDBArgumentCaptor.getValue().getName(),typeOfEntityModelJson.getName());
//    assertEquals(typeOfEntityModelDBArgumentCaptor.getValue().getSystemName(), typeOfEntityModelJson.getSystemName());
//
//  }
//
//  @Test(expected = RecordNotFoundDBException.class)
//  public void testUpdateTypeOfEntityIfEntityNotExists() {
//    //arrange
//    TypeOfEntityModelJson typeOfEntityModelJson = mock(TypeOfEntityModelJson.class);
//    TypeOfEntityModelDB typeOfEntityModelDB = mock(TypeOfEntityModelDB.class);
//
//    when(typeOfEntityRepository.findById(any())).thenAnswer(invocationOnMock -> Optional.empty());
//
//    //act
//    typeOfEntityService.updateTypeOfEntity(typeOfEntityModelJson);
//
//    //assert
//
//  }
//
//  @Test
//  public void testUpdateTypeOfEntityNoException() {
//    //arrange
//    TypeOfEntityModelJson typeOfEntityModelJson = TypeOfEntityModelJson.builder()
//          .id(1L)
//          .name("test-name")
//          .systemName("test-system-name")
//          .build();
//    TypeOfEntityModelDB typeOfEntityModelDB = mock(TypeOfEntityModelDB.class);
//    when(typeOfEntityRepository.findById(any())).thenReturn(Optional.of(typeOfEntityModelDB));
//    when(typeOfEntityRepository.save(typeOfEntityModelDBArgumentCaptor.capture())).thenReturn(typeOfEntityModelDB);
//    //act
//    typeOfEntityService.updateTypeOfEntity(typeOfEntityModelJson);
//
//    //assert
//    assertEquals(typeOfEntityModelJson.getName(),typeOfEntityModelDBArgumentCaptor.getValue().getName());
//    assertEquals(typeOfEntityModelJson.getSystemName(),typeOfEntityModelDBArgumentCaptor.getValue().getSystemName());
//    assertEquals(typeOfEntityModelJson.getId(), typeOfEntityModelDBArgumentCaptor.getValue().getId());
//  }
//
//  @Test
//  public void testReadTypeOfEntityRecordFound() {
//    //arrange
//    TypeOfEntityModelDB typeOfEntityModelDB = new TypeOfEntityModelDB();
//    typeOfEntityModelDB.setId(1L);
//    typeOfEntityModelDB.setName("test");
//    typeOfEntityModelDB.setSystemName("system-test");
//    when(typeOfEntityRepository.findById(any())).thenReturn(Optional.of(typeOfEntityModelDB));
//    //act
//    TypeOfEntityModelJson typeOfEntityModelJson = typeOfEntityService.readTypeOfEntity(1L);
//
//    //assert
//    assertEquals(typeOfEntityModelJson.getId(), typeOfEntityModelDB.getId());
//    assertEquals(typeOfEntityModelJson.getName(), typeOfEntityModelDB.getName());
//    assertEquals(typeOfEntityModelJson.getSystemName(), typeOfEntityModelDB.getSystemName());
//  }
//
//  @Test(expected = RecordNotFoundDBException.class)
//  public void testReadTypeOfEntityNotFound() {
//    //arrange
//    when(typeOfEntityRepository.findById(any())).thenReturn(Optional.empty());
//
//    //act
//    typeOfEntityService.readTypeOfEntity(1L);
//
//    //assert
//
//  }
//
//  @Test
//  public void testDeleteTypeOfEntityRecordDeleted() {
//    //arrange
//    TypeOfEntityModelDB typeOfEntityModelDB = new TypeOfEntityModelDB();
//    typeOfEntityModelDB.setId(1L);
//    typeOfEntityModelDB.setName("test");
//    typeOfEntityModelDB.setSystemName("system-test");
//    typeOfEntityModelDB.setDeleted(false);
//    when(typeOfEntityRepository.findById(any())).thenReturn(Optional.of(typeOfEntityModelDB));
//    when(typeOfEntityRepository.save(typeOfEntityModelDBArgumentCaptor.capture())).thenReturn(typeOfEntityModelDB);
//
//    //act
//    typeOfEntityService.deleteTypeOfEntity(1L);
//
//    //assert
//    assertEquals(typeOfEntityModelDBArgumentCaptor.getValue().getId(), typeOfEntityModelDB.getId());
//    assertEquals(typeOfEntityModelDBArgumentCaptor.getValue().getName(), typeOfEntityModelDB.getName());
//    assertEquals(typeOfEntityModelDBArgumentCaptor.getValue().getSystemName(), typeOfEntityModelDB.getSystemName());
//    assertEquals(typeOfEntityModelDBArgumentCaptor.getValue().getDeleted(),true);
//
//  }
//
//  @Test(expected = RecordNotFoundDBException.class)
//  public void testDeleteTypeOfEntityRecordNotFound() {
//    //arrange
//    TypeOfEntityModelDB typeOfEntityModelDB = new TypeOfEntityModelDB();
//    typeOfEntityModelDB.setId(1L);
//    typeOfEntityModelDB.setName("test");
//    typeOfEntityModelDB.setSystemName("system-test");
//    typeOfEntityModelDB.setDeleted(false);
//    when(typeOfEntityRepository.findById(any())).thenReturn(Optional.empty());
//    when(typeOfEntityRepository.save(typeOfEntityModelDBArgumentCaptor.capture())).thenReturn(typeOfEntityModelDB);
//
//    //act
//    typeOfEntityService.deleteTypeOfEntity(1L);
//
//  }
//
//  @Test
//  public void testReadAllTypeOfEntity() {
//    //arrange
//    TypeOfEntityModelDB typeOfEntityModelDB = new TypeOfEntityModelDB();
//    typeOfEntityModelDB.setId(1L);
//    typeOfEntityModelDB.setName("test");
//    typeOfEntityModelDB.setSystemName("system-test");
//    typeOfEntityModelDB.setDeleted(false);
//    when(typeOfEntityRepository.findAllNotDeleted()).thenReturn(Arrays.asList(typeOfEntityModelDB));
//
//    //act
//    List<TypeOfEntityModelJson> typeOfEntityModelJsonList = typeOfEntityService.readAllTypeOfEntity();
//
//    assertEquals(1, typeOfEntityModelJsonList.size());
//    TypeOfEntityModelJson typeOfEntityModelJson = typeOfEntityModelJsonList.get(0);
//    assertEquals(typeOfEntityModelDB.getId(),typeOfEntityModelJson.getId());
//    assertEquals(typeOfEntityModelDB.getName(), typeOfEntityModelJson.getName());
//    assertEquals(typeOfEntityModelDB.getSystemName(), typeOfEntityModelJson.getSystemName());
  }
}
