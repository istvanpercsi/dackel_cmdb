package de.percsi.products.dackelcmdb.services;

import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJson;
import de.percsi.products.dackelcmdb.mapper.TypeOfEntityModelMapper;
import de.percsi.products.dackelcmdb.persistence.model.TypeOfEntityModelDB;
import de.percsi.products.dackelcmdb.persistence.repositories.TypeOfEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.OperationNotSupportedException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TypeOfEntityServiceImpl implements TypeOfEntityService {

    @Autowired
    private TypeOfEntityRepository typeOfEntityRepository;

    @Override
    public void createTypeOfEntity(TypeOfEntityModelJson typeOfEntityModelJson) throws OperationNotSupportedException{
        if (typeOfEntityRepository.findById(typeOfEntityModelJson.getId()).orElse(null) != null) {
            throw new OperationNotSupportedException("Record is already exists! To update please use HTTP PATCH method.");
        };
        typeOfEntityRepository.save(TypeOfEntityModelMapper.MAPPER.mapJsonToDB(typeOfEntityModelJson));
    }

    @Override
    public TypeOfEntityModelJson readTypeOfEntity(Long id) {
        return TypeOfEntityModelMapper.MAPPER.mapDBToJson(typeOfEntityRepository.findById(id).orElse(new TypeOfEntityModelDB()));
    }

    @Override
    public void deleteTypeOfEntity(Long id) {
        typeOfEntityRepository.findById(id).ifPresent(e -> {
            e.setDeleted(true);
            typeOfEntityRepository.save(e);
        });
    }

    @Override
    public List<TypeOfEntityModelJson> getAllTypeOfEntity() {
        return StreamSupport.stream(typeOfEntityRepository.findAllNotDeleted().spliterator(),false)
                .map(e -> TypeOfEntityModelMapper.MAPPER.mapDBToJson(e))
                .collect(Collectors.toList());
    }
}
