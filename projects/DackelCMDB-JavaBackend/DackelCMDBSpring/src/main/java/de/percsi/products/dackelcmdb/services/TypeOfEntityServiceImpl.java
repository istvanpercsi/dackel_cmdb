package de.percsi.products.dackelcmdb.services;

import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfEntityServiceImpl implements TypeOfEntityService {

    @Override
    public void createTypeOfEntity(TypeOfEntityModelJson typeOfEntityModelJson) {

    }

    @Override
    public TypeOfEntityModelJson readTypeOfEntity(Long id) {
        return null;
    }

    @Override
    public void deleteTypeOfEntity(Long id) {

    }

    @Override
    public List<TypeOfEntityModelJson> getAllTypeOfEntity() {
        return null;
    }
}
