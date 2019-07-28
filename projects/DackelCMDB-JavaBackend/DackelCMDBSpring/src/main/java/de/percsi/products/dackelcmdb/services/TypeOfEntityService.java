package de.percsi.products.dackelcmdb.services;

import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJsonCU;
import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJsonR;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public interface TypeOfEntityService {

    public void createTypeOfEntity(TypeOfEntityModelJsonCU typeOfEntityModelJsonCU) throws OperationNotSupportedException;

    public void updateTypeOfEntity(TypeOfEntityModelJsonCU typeOfEntityModelJsonCU) throws OperationNotSupportedException;

    public TypeOfEntityModelJsonR readTypeOfEntity(Long id);

    public void deleteTypeOfEntity(Long id);

    public List<TypeOfEntityModelJsonR> getAllTypeOfEntity();
}
