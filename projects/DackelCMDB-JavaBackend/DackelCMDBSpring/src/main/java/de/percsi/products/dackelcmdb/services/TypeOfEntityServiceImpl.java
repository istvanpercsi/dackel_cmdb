package de.percsi.products.dackelcmdb.services;

import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJson;
import de.percsi.products.dackelcmdb.mapper.TypeOfEntityModelMapper;
import de.percsi.products.dackelcmdb.persistence.repositories.TypeOfEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TypeOfEntityServiceImpl implements TypeOfEntityService {

    @Autowired
    private TypeOfEntityRepository typeOfEntityRepository;

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
        return StreamSupport.stream(typeOfEntityRepository.findAll().spliterator(),false)
                .map(e -> TypeOfEntityModelMapper.MAPPER.mapDBToJson(e))
                .collect(Collectors.toList());
    }
}
