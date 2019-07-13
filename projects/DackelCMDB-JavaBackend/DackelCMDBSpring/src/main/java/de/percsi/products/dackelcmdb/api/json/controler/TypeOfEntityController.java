package de.percsi.products.dackelcmdb.api.json.controler;

import de.percsi.products.dackelcmdb.api.json.messages.Message;
import de.percsi.products.dackelcmdb.api.json.messages.MessageClassesEnum;
import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityJsonModel;
import de.percsi.products.dackelcmdb.persistence.model.TypeOfEntityDBModel;
import de.percsi.products.dackelcmdb.persistence.repositories.TypeOfEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(path = "/api/typesOfEntity")
public class TypeOfEntityController {

    @Autowired
    private TypeOfEntityRepository typeOfEntityRepository;

    @RequestMapping("/getTypeOfEntityById/{id}")
    public TypeOfEntityJsonModel getTypeOfEntityById(@PathVariable(name = "id") int id) {
        return TypeOfEntityJsonModel.builder()
                .id(id)
                .name("DatabaseConnection")
                .build();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/getAllTypeOfEntity",
            produces = "application/json",
            consumes = "application/json"
    )
    public @ResponseBody Iterable<TypeOfEntityDBModel> getAllTypeOfEntity() {
        return typeOfEntityRepository.findAll();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/createTypeOfEntity",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity createTypeOfEntity(@RequestBody TypeOfEntityDBModel typeOfEntity) {
        if (!typeOfEntityRepository.existsById(typeOfEntity.getId())) {
            typeOfEntity.setCreateDate(new Date(System.currentTimeMillis()));
            typeOfEntity.setModificationDate(new Date(System.currentTimeMillis()));
            typeOfEntity.setCreateUser("Demo User");
            typeOfEntity.setModificationUser("Demo User");
            typeOfEntityRepository.save(typeOfEntity);
            return new ResponseEntity(
                    Message.builder()
                    .messageId(999)
                    .messageClass(MessageClassesEnum.INFO)
                    .messageText("Record saved").build(),
                    HttpStatus.OK
            );
        }
        return new ResponseEntity(
                Message.builder()
                        .messageId(999)
                        .messageClass(MessageClassesEnum.ERROR)
                        .messageText("Record is already exists! To update please use HTTP PATCH method.").build(),
                HttpStatus.CONFLICT);
    }

}
