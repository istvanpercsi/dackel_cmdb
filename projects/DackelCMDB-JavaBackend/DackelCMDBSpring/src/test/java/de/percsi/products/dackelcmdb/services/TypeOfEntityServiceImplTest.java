package de.percsi.products.dackelcmdb.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJson;
import de.percsi.products.dackelcmdb.exceptions.RecordAlreadyExistsDBException;
import de.percsi.products.dackelcmdb.exceptions.RecordNotFoundDBException;
import de.percsi.products.dackelcmdb.persistence.model.TypeOfEntityModelDB;
import de.percsi.products.dackelcmdb.persistence.repositories.TypeOfEntityRepository;
import de.percsi.products.dackelcmdb.services.TypeOfEntityServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import sun.misc.JavaAWTAccess;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class TypeOfEntityServiceImplTest {

    @Mock
    private TypeOfEntityRepository typeOfEntityRepository;

    @Mock
    private TypeOfEntityModelJson typeOfEntityModelJson;

    @InjectMocks
    private TypeOfEntityServiceImpl typeOfEntityService = new TypeOfEntityServiceImpl(typeOfEntityRepository);

    ArgumentCaptor<TypeOfEntityModelDB> typeOfEntityModelDBArgumentCaptor = ArgumentCaptor.forClass(TypeOfEntityModelDB.class);

    @Test(expected = RecordAlreadyExistsDBException.class)
    public void testCreateTypeOfEntityIfIdExists() {
        //arrange
        TypeOfEntityModelDB typeOfEntityModelDB = mock(TypeOfEntityModelDB.class);
        when(typeOfEntityRepository.findById(any()))
                .thenAnswer((Answer<Optional<TypeOfEntityModelDB>>) invocationOnMock -> Optional.of(typeOfEntityModelDB));
        //act
        typeOfEntityService.createTypeOfEntity(typeOfEntityModelJson);
        //assert
    }

    @Test(expected = RecordAlreadyExistsDBException.class)
    public void testCreateTypeOfEntityIfSystemNameExists() {
        //arrange
        TypeOfEntityModelDB typeOfEntityModelDB = mock(TypeOfEntityModelDB.class);
        when(typeOfEntityRepository.findFirstBySystemName(any()))
                .thenAnswer(invocationOnMock -> Optional.of(typeOfEntityModelDB));
        //act
        typeOfEntityService.createTypeOfEntity(typeOfEntityModelJson);

        //assert
    }

    @Test
    public void testCreateTypeOfEntityNoException() {
        //arrange
        TypeOfEntityModelJson typeOfEntityModelJson = TypeOfEntityModelJson.builder()
                .id(null)
                .name("test-name")
                .systemName("test-system-name")
                .build();
        doAnswer(invocationOnMock -> null).when(typeOfEntityRepository).save(typeOfEntityModelDBArgumentCaptor.capture());

        //act
        typeOfEntityService.createTypeOfEntity(typeOfEntityModelJson);

        //assert
        assertEquals(typeOfEntityModelDBArgumentCaptor.getValue().getName(),typeOfEntityModelJson.getName());
        assertEquals(typeOfEntityModelDBArgumentCaptor.getValue().getSystemName(), typeOfEntityModelJson.getSystemName());

    }

    @Test(expected = RecordNotFoundDBException.class)
    public void testUpdateTypeOfEntityIfEntityNotExists() {
        //arrange
        TypeOfEntityModelJson typeOfEntityModelJson = mock(TypeOfEntityModelJson.class);
        TypeOfEntityModelDB typeOfEntityModelDB = mock(TypeOfEntityModelDB.class);

        when(typeOfEntityRepository.findById(any())).thenAnswer(invocationOnMock -> Optional.empty());

        //act
        typeOfEntityService.updateTypeOfEntity(typeOfEntityModelJson);

        //assert

    }

    @Test
    public void testUpdateTypeOfEntityNoException() {
        //arrange
        TypeOfEntityModelJson typeOfEntityModelJson = TypeOfEntityModelJson.builder()
                .id(1L)
                .name("test-name")
                .systemName("test-system-name")
                .build();
        TypeOfEntityModelDB typeOfEntityModelDB = mock(TypeOfEntityModelDB.class);
        when(typeOfEntityRepository.findById(any())).thenReturn(Optional.of(typeOfEntityModelDB));
        when(typeOfEntityRepository.save(typeOfEntityModelDBArgumentCaptor.capture())).thenReturn(typeOfEntityModelDB);
        //act
        typeOfEntityService.updateTypeOfEntity(typeOfEntityModelJson);

        //assert
        assertEquals(typeOfEntityModelJson.getName(),typeOfEntityModelDBArgumentCaptor.getValue().getName());
        assertEquals(typeOfEntityModelJson.getSystemName(),typeOfEntityModelDBArgumentCaptor.getValue().getSystemName());
        assertEquals(typeOfEntityModelJson.getId(), typeOfEntityModelDBArgumentCaptor.getValue().getId());
    }
}
