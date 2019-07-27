package de.percsi.products.dackelcmdb.api.json.controler;

import de.percsi.products.dackelcmdb.api.json.messages.Message;
import de.percsi.products.dackelcmdb.api.json.messages.MessageClassesEnum;
import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJson;
import de.percsi.products.dackelcmdb.persistence.model.TypeOfEntityModelDB;
import de.percsi.products.dackelcmdb.persistence.repositories.TypeOfEntityRepository;
import de.percsi.products.dackelcmdb.services.TypeOfEntityService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.OperationNotSupportedException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/typeOfEntity")
public class TypeOfEntityController {

    @Autowired
    private TypeOfEntityService typeOfEntityService;

    @ApiResponses(
            @ApiResponse(
                    code = 200,
                    message = "Retuns with a Type of Entity where the 'id' is passed"
            )
    )
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}",
            produces = "application/json"
    )
    public TypeOfEntityModelJson getTypeOfEntityById(@PathVariable(name = "id") Long id) {
        return typeOfEntityService.readTypeOfEntity(id);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/all",
            produces = "application/json"
    )
    public @ResponseBody List<TypeOfEntityModelJson> getAllTypeOfEntity() {
        return typeOfEntityService.getAllTypeOfEntity();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity createTypeOfEntity(@RequestBody TypeOfEntityModelJson typeOfEntityModelJson) {
        try {
            typeOfEntityService.createTypeOfEntity(typeOfEntityModelJson);
            Message msg = Message.builder()
                    .messageId(999)
                    .messageClass(MessageClassesEnum.INFO)
                    .messageText("Record saved").build();
            return new ResponseEntity(msg,HttpStatus.OK);
        }
        catch (OperationNotSupportedException e) {
            Message msg = Message.builder()
                    .messageId(999)
                    .messageClass(MessageClassesEnum.ERROR)
                    .messageText(e.getMessage()).build();
            return new ResponseEntity(msg,HttpStatus.CONFLICT);
        }
    }

    @RequestMapping (
            method = RequestMethod.PATCH,
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity updateTypeOfEntity(@RequestBody TypeOfEntityModelJson typeOfEntityModelJson){
        try {
            typeOfEntityService.updateTypeOfEntity(typeOfEntityModelJson);
            Message msg = Message.builder()
                    .messageId(999)
                    .messageClass(MessageClassesEnum.INFO)
                    .messageText("Record saved").build();
            return new ResponseEntity(msg,HttpStatus.OK);
        } catch (OperationNotSupportedException e) {
            Message msg = Message.builder()
                    .messageId(999)
                    .messageClass(MessageClassesEnum.ERROR)
                    .messageText(e.getMessage()).build();
            return new ResponseEntity(msg,HttpStatus.CONFLICT);

        }
    }

}
