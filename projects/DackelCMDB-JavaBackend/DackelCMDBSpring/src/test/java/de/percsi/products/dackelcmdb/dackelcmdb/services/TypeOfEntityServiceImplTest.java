package de.percsi.products.dackelcmdb.dackelcmdb.services;

import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJson;
import de.percsi.products.dackelcmdb.persistence.repositories.TypeOfEntityRepository;
import de.percsi.products.dackelcmdb.services.TypeOfEntityServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import sun.misc.JavaAWTAccess;

@RunWith(MockitoJUnitRunner.class)
public class TypeOfEntityServiceImplTest {

    @Mock
    private TypeOfEntityRepository typeOfEntityRepository;

    @Mock
    private TypeOfEntityModelJson typeOfEntityModelJson;

    @InjectMocks
    private TypeOfEntityServiceImpl typeOfEntityService = new TypeOfEntityServiceImpl(typeOfEntityRepository);


    @Test
    public void creteTypeOfEntityTest() {
        //

        //act
        typeOfEntityService.createTypeOfEntity(typeOfEntityModelJson);
        //assert
    }
}
