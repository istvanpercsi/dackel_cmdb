package de.percsi.products.dackelcmdb.services;

import de.percsi.products.dackelcmdb.api.json.messages.OperationalMessagesEnum;
import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJson;
import de.percsi.products.dackelcmdb.exceptions.RecordAlreadyExistsDBException;
import de.percsi.products.dackelcmdb.exceptions.RecordNotFoundDBException;
import de.percsi.products.dackelcmdb.mapper.TypeOfEntityModelMapper;
import de.percsi.products.dackelcmdb.persistence.model.Tables;
import de.percsi.products.dackelcmdb.persistence.model.TypeOfEntityModelDB;
import de.percsi.products.dackelcmdb.persistence.repositories.TypeOfEntityRepository;
import io.vavr.collection.Stream;
import io.vavr.control.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TypeOfEntityServiceImpl implements TypeOfEntityService {

  private TypeOfEntityRepository typeOfEntityRepository;


  @Autowired
  public TypeOfEntityServiceImpl(TypeOfEntityRepository typeOfEntityRepository) {
    this.typeOfEntityRepository = typeOfEntityRepository;
  }

  @Override
  public void createTypeOfEntity(TypeOfEntityModelJson typeOfEntityModelJson) {
    Option.ofOptional(typeOfEntityRepository.findFirstByIdAndSystemName(typeOfEntityModelJson.getId(),typeOfEntityModelJson.getSystemName()))
          .peek(typeOfEntityModelDB -> {
            throw new RecordAlreadyExistsDBException(OperationalMessagesEnum.RECORD_ALREADY_EXISTS_TABLE_SYSTEMNAME.getMessage(
            Tables.TYPES_OF_ENTITIES, typeOfEntityModelDB.getSystemName()));
          });
    TypeOfEntityModelDB typeOfEntityModelDB = TypeOfEntityModelMapper.MAPPER.mapJsonCUToDB(typeOfEntityModelJson);
    typeOfEntityModelDB.setCreateDate(new Date());
    typeOfEntityModelDB.setCreateUser("Test Create user");
    typeOfEntityModelDB.setModificationDate(new Date());
    typeOfEntityModelDB.setModificationUser("Test create user");
    typeOfEntityRepository.save(typeOfEntityModelDB);
  }

  @Override
  public void updateTypeOfEntity(TypeOfEntityModelJson typeOfEntityModelJson) {
    Option.ofOptional(typeOfEntityRepository.findById(typeOfEntityModelJson.getId()))
          .getOrElseThrow(() -> new RecordNotFoundDBException(OperationalMessagesEnum.RECORD_NOT_FOUND_TABLE_ID.getMessage(
                Tables.TYPES_OF_ENTITIES, typeOfEntityModelJson.getId().toString())));
    TypeOfEntityModelDB typeOfEntityModelDBSave =
          TypeOfEntityModelMapper.MAPPER.mapJsonCUToDB(typeOfEntityModelJson);
    typeOfEntityModelDBSave.setModificationUser("Modification user");
    typeOfEntityModelDBSave.setModificationDate(new Date());
    typeOfEntityRepository.save(typeOfEntityModelDBSave);
  }

  @Override
  public TypeOfEntityModelJson readTypeOfEntity(Long id) {
    return TypeOfEntityModelMapper.MAPPER.mapDBToJson(Option.ofOptional(typeOfEntityRepository.findById(id))
                .getOrElseThrow(() -> new RecordNotFoundDBException(
                      OperationalMessagesEnum.RECORD_NOT_FOUND_TABLE_ID.getMessage(Tables.TYPES_OF_ENTITIES,id.toString()))));
  }

  @Override
  public void deleteTypeOfEntity(Long id) {
    TypeOfEntityModelDB typeOfEntityModelDB = Option.ofOptional(typeOfEntityRepository.findById(id))
          .getOrElseThrow(()-> new RecordNotFoundDBException(OperationalMessagesEnum.RECORD_NOT_FOUND_TABLE_ID.getMessage(Tables.TYPES_OF_ENTITIES,id.toString())));
    typeOfEntityModelDB.setDeleted(true);
    typeOfEntityModelDB.setModificationDate(new Date());
    typeOfEntityModelDB.setModificationUser("Delete user");
    typeOfEntityRepository.save(typeOfEntityModelDB);
  }

  @Override
  public List<TypeOfEntityModelJson> readAllTypeOfEntity() {
    return Stream.ofAll(typeOfEntityRepository.findAllNotDeleted()).map(TypeOfEntityModelMapper.MAPPER::mapDBToJson)
          .toJavaList();
  }
}
