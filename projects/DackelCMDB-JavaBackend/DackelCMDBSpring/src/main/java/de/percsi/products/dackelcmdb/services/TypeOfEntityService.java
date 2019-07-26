package de.percsi.products.dackelcmdb.services;

import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJson;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public interface TypeOfEntityService {

    public void createTypeOfEntity(TypeOfEntityModelJson typeOfEntityModelJson) throws OperationNotSupportedException;

    public TypeOfEntityModelJson readTypeOfEntity(Long id);

    public void deleteTypeOfEntity(Long id);

    public List<TypeOfEntityModelJson> getAllTypeOfEntity();
}
