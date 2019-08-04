package de.percsi.products.dackelcmdb.services;

import de.percsi.products.dackelcmdb.api.json.messages.MessagesEnum;
import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJsonCU;
import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJsonR;
import de.percsi.products.dackelcmdb.exceptions.RecordAlreadyExistsDBException;
import de.percsi.products.dackelcmdb.exceptions.RecordNotFoundDBException;
import de.percsi.products.dackelcmdb.mapper.TypeOfEntityModelMapper;
import de.percsi.products.dackelcmdb.persistence.model.TypeOfEntityModelDB;
import de.percsi.products.dackelcmdb.persistence.repositories.TypeOfEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.naming.OperationNotSupportedException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TypeOfEntityServiceImpl implements TypeOfEntityService {

    private static final String TABLE_TYPE_OF_ENTITY = "types_of_entity";

    @Autowired
    private TypeOfEntityRepository typeOfEntityRepository;

    @Override
    public void createTypeOfEntity(TypeOfEntityModelJsonCU typeOfEntityModelJsonCU) {
        if (typeOfEntityRepository.findById(typeOfEntityModelJsonCU.getId()).orElse(null) != null) {
            throw new RecordAlreadyExistsDBException(String.format(MessagesEnum.RECORD_ALREADY_EXISTS_TABLE_ID.getMessage(),
                    TABLE_TYPE_OF_ENTITY,typeOfEntityModelJsonCU.getId()));
        } else if (typeOfEntityRepository.findFirstBySystemName(typeOfEntityModelJsonCU.getSystemName()).orElse(null) != null) {
            throw new RecordAlreadyExistsDBException(String.format(MessagesEnum.RECORD_ALREADY_EXISTS_TABLE_SYSTEM_NAME.getMessage(),
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
        TypeOfEntityModelDB typeOfEntityModelDBOrig = typeOfEntityRepository.findById(typeOfEntityModelJsonCU.getId()).get();
        if (typeOfEntityModelDBOrig == null) {
            throw  new RecordNotFoundDBException(String.format(MessagesEnum.RECORD_NOT_FOUND_TABLE_ID.getMessage(),
                    TABLE_TYPE_OF_ENTITY,typeOfEntityModelJsonCU.getId()));
        }
        TypeOfEntityModelDB typeOfEntityModelDBSave = TypeOfEntityModelMapper.MAPPER.mapJsonCUToDB(typeOfEntityModelJsonCU);
        typeOfEntityModelDBSave.setModificationUser("Modification user");
        typeOfEntityModelDBSave.setModificationDate(new Date());
        typeOfEntityRepository.save(typeOfEntityModelDBSave);
    }

    @Override
    public TypeOfEntityModelJsonR readTypeOfEntity(Long id) {
        TypeOfEntityModelJsonR typeOfEntityModelJsonR =  typeOfEntityRepository.findById(id)
                .map(r ->TypeOfEntityModelMapper.MAPPER.mapDBToJsonR( r))
                .orElse(null);
        if (typeOfEntityModelJsonR == null)
            throw new RecordNotFoundDBException(String.format(MessagesEnum.RECORD_NOT_FOUND_TABLE_ID.getMessage(),TABLE_TYPE_OF_ENTITY,id));
        return typeOfEntityModelJsonR;
    }

    @Override
    public void deleteTypeOfEntity(Long id) {
        typeOfEntityRepository.findById(id).ifPresent(e -> {
            e.setDeleted(true);
            e.setModificationDate(new Date());
            typeOfEntityRepository.save(e);
            return;
        });
        throw new RecordNotFoundDBException(String.format(MessagesEnum.RECORD_NOT_FOUND_TABLE_ID.getMessage(),TABLE_TYPE_OF_ENTITY,id));
    }

    @Override
    public List<TypeOfEntityModelJsonR> getAllTypeOfEntity() {
        return StreamSupport.stream(typeOfEntityRepository.findAllNotDeleted().spliterator(),false)
                .map(e -> TypeOfEntityModelMapper.MAPPER.mapDBToJsonR(e))
                .collect(Collectors.toList());
    }
}
