package de.percsi.products.dackelcmdb.services;

import de.percsi.products.dackelcmdb.api.json.messages.OperationalMessagesEnum;
import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJsonCU;
import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJsonR;
import de.percsi.products.dackelcmdb.exceptions.RecordAlreadyExistsDBException;
import de.percsi.products.dackelcmdb.exceptions.RecordNotFoundDBException;
import de.percsi.products.dackelcmdb.mapper.TypeOfEntityModelMapper;
import de.percsi.products.dackelcmdb.persistence.model.TypeOfEntityModelDB;
import de.percsi.products.dackelcmdb.persistence.repositories.TypeOfEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TypeOfEntityServiceImpl implements TypeOfEntityService {

    private static final String TABLE_TYPE_OF_ENTITY = "types_of_entity";

    private TypeOfEntityRepository typeOfEntityRepository;

    @Autowired
    public TypeOfEntityServiceImpl(TypeOfEntityRepository typeOfEntityRepository) {
        this.typeOfEntityRepository = typeOfEntityRepository;
    }

    @Override
    public void createTypeOfEntity(TypeOfEntityModelJsonCU typeOfEntityModelJsonCU) {
        if (typeOfEntityRepository.findById(typeOfEntityModelJsonCU.getId()).orElse(null) != null) {
            throw new RecordAlreadyExistsDBException(OperationalMessagesEnum.RECORD_ALREADY_EXISTS_TABLE_ID.getMessage(
                    TABLE_TYPE_OF_ENTITY,typeOfEntityModelJsonCU.getId().toString()));
        } else if (typeOfEntityRepository.findFirstBySystemName(typeOfEntityModelJsonCU.getSystemName()).orElse(null) != null) {
            throw new RecordAlreadyExistsDBException(OperationalMessagesEnum.RECORD_ALREADY_EXISTS_TABLE_SYSTEMNAME.getMessage(
                    TABLE_TYPE_OF_ENTITY,typeOfEntityModelJsonCU.getSystemName()));
        }
        TypeOfEntityModelDB typeOfEntityModelDB = TypeOfEntityModelMapper.MAPPER.mapJsonCUToDB(typeOfEntityModelJsonCU);
        typeOfEntityModelDB.setCreateDate(new Date());
        typeOfEntityModelDB.setCreateUser("Test Create user");
        typeOfEntityModelDB.setModificationDate(new Date());
        typeOfEntityModelDB.setModificationUser("Test create user");
        typeOfEntityRepository.save(typeOfEntityModelDB);
    }

    @Override
    public void updateTypeOfEntity(TypeOfEntityModelJsonCU typeOfEntityModelJsonCU) {
        TypeOfEntityModelDB typeOfEntityModelDBOrig = typeOfEntityRepository.findById(typeOfEntityModelJsonCU.getId()).orElse(null);
        if (typeOfEntityModelDBOrig == null) {
            throw  new RecordNotFoundDBException(OperationalMessagesEnum.RECORD_NOT_FOUND_TABLE_ID.getMessage(
                    TABLE_TYPE_OF_ENTITY,typeOfEntityModelJsonCU.getId().toString()));
        }
        TypeOfEntityModelDB typeOfEntityModelDBSave = TypeOfEntityModelMapper.MAPPER.mapJsonCUToDB(typeOfEntityModelJsonCU);
        typeOfEntityModelDBSave.setModificationUser("Modification user");
        typeOfEntityModelDBSave.setModificationDate(new Date());
        typeOfEntityRepository.save(typeOfEntityModelDBSave);
    }

    @Override
    public TypeOfEntityModelJsonR readTypeOfEntity(Long id) {
        TypeOfEntityModelJsonR typeOfEntityModelJsonR =  typeOfEntityRepository.findById(id)
                .map(TypeOfEntityModelMapper.MAPPER::mapDBToJsonR)
                .orElse(null);
        if (typeOfEntityModelJsonR == null)
            throw new RecordNotFoundDBException(OperationalMessagesEnum.RECORD_NOT_FOUND_TABLE_ID.getMessage(TABLE_TYPE_OF_ENTITY,id.toString()));
        return typeOfEntityModelJsonR;
    }

    @Override
    public void deleteTypeOfEntity(Long id) {
        AtomicBoolean found = new AtomicBoolean(false);
        typeOfEntityRepository.findById(id).ifPresent(e -> {
            e.setDeleted(true);
            e.setModificationDate(new Date());
            typeOfEntityRepository.save(e);
            found.set(true);
        });
        if (!found.get())
            throw new RecordNotFoundDBException(OperationalMessagesEnum.RECORD_NOT_FOUND_TABLE_ID.getMessage(TABLE_TYPE_OF_ENTITY,id.toString()));
    }

    @Override
    public List<TypeOfEntityModelJsonR> getAllTypeOfEntity() {
        return StreamSupport.stream(typeOfEntityRepository.findAllNotDeleted().spliterator(),false)
                .map(TypeOfEntityModelMapper.MAPPER::mapDBToJsonR)
                .collect(Collectors.toList());
    }
}
