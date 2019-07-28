package de.percsi.products.dackelcmdb.services;

import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJsonCU;
import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJsonR;
import de.percsi.products.dackelcmdb.mapper.TypeOfEntityModelMapper;
import de.percsi.products.dackelcmdb.persistence.model.TypeOfEntityModelDB;
import de.percsi.products.dackelcmdb.persistence.repositories.TypeOfEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TypeOfEntityServiceImpl implements TypeOfEntityService {

    @Autowired
    private TypeOfEntityRepository typeOfEntityRepository;

    @Override
    public void createTypeOfEntity(TypeOfEntityModelJsonCU typeOfEntityModelJsonCU) throws OperationNotSupportedException{
        if (typeOfEntityRepository.findById(typeOfEntityModelJsonCU.getId()).orElse(null) != null) {
            throw new OperationNotSupportedException("Record is already exists! To update please use HTTP PATCH method.");
        };
        TypeOfEntityModelDB typeOfEntityModelDB = TypeOfEntityModelMapper.MAPPER.mapJsonCUToDB(typeOfEntityModelJsonCU);
        typeOfEntityModelDB.setCreateDate(new Date());
        typeOfEntityModelDB.setCreateUser("Test Create user");
        typeOfEntityModelDB.setModificationDate(new Date());
        typeOfEntityModelDB.setModificationUser("Test create user");
        typeOfEntityRepository.save(typeOfEntityModelDB);
    }

    @Override
    public void updateTypeOfEntity(TypeOfEntityModelJsonCU typeOfEntityModelJsonCU) throws OperationNotSupportedException {
        TypeOfEntityModelDB typeOfEntityModelDBOrig = typeOfEntityRepository.findById(typeOfEntityModelJsonCU.getId()).orElse(null);
        if (typeOfEntityModelDBOrig == null) {
            throw  new OperationNotSupportedException("Record with id '" + typeOfEntityModelJsonCU.getId().toString()
                    + "' does not exists. To create please use HTTP POST method");
        }
        TypeOfEntityModelDB typeOfEntityModelDBSave = TypeOfEntityModelMapper.MAPPER.mapJsonCUToDB(typeOfEntityModelJsonCU);
        typeOfEntityModelDBSave.setModificationUser("Modification user");
        typeOfEntityModelDBSave.setModificationDate(new Date());
        typeOfEntityRepository.save(typeOfEntityModelDBSave);
    }

    @Override
    public TypeOfEntityModelJsonR readTypeOfEntity(Long id) {
        return TypeOfEntityModelMapper.MAPPER.mapDBToJsonR(typeOfEntityRepository.findById(id).orElse(new TypeOfEntityModelDB()));
    }

    @Override
    public void deleteTypeOfEntity(Long id) {
        typeOfEntityRepository.findById(id).ifPresent(e -> {
            e.setDeleted(true);
            e.setModificationDate(new Date());
            typeOfEntityRepository.save(e);
        });
    }

    @Override
    public List<TypeOfEntityModelJsonR> getAllTypeOfEntity() {
        return StreamSupport.stream(typeOfEntityRepository.findAllNotDeleted().spliterator(),false)
                .map(e -> TypeOfEntityModelMapper.MAPPER.mapDBToJsonR(e))
                .collect(Collectors.toList());
    }
}
