package de.percsi.products.dackelcmdb.api.json.controler;

import de.percsi.products.dackelcmdb.api.json.messages.Message;
import de.percsi.products.dackelcmdb.api.json.messages.MessageClassesEnum;
import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJsonCU;
import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJsonR;
import de.percsi.products.dackelcmdb.services.TypeOfEntityService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.OperationNotSupportedException;
import java.util.List;

@RestController
@RequestMapping(path = "/api/typeOfEntity")
public class TypeOfEntityController {

    @Autowired
    private TypeOfEntityService typeOfEntityService;

    @ApiOperation(
            value = "Get entity where the 'id' is passed.",
            notes = "Returns a Type of Entity"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Returns with a Type of Entity where the 'id' is passed"),
            @ApiResponse(code = 404, message = "Record with 'id' not found.")
    })
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}",
            produces = "application/json"
    )
    public ResponseEntity<TypeOfEntityModelJsonR> getTypeOfEntityById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<TypeOfEntityModelJsonR>(typeOfEntityService.readTypeOfEntity(id),HttpStatus.OK);
    }

    @ApiOperation(
            value = "Get all entities which had not been deleted.",
            notes = "Returns a list of Type of Entity"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Returns with a List of Type of Entity which had not been deleted.")
    })
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/all",
            produces = "application/json"
    )
    public ResponseEntity<List<TypeOfEntityModelJsonR>> getAllTypeOfEntity() {
        return new ResponseEntity<List<TypeOfEntityModelJsonR>>(typeOfEntityService.getAllTypeOfEntity(), HttpStatus.OK);
    }

    @ApiOperation(
            value = "Create a new type of entity",
            notes = "Save a new type of entity into database"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "New record has been created"),
            @ApiResponse(code = 409, message = "Record with 'id' exists already.")
    })
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity createTypeOfEntity(@RequestBody TypeOfEntityModelJsonCU typeOfEntityModelJsonCU) {
        try {
            typeOfEntityService.createTypeOfEntity(typeOfEntityModelJsonCU);
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

    @ApiOperation(
            value = "Update a  type of entity",
            notes = "Update type of entity into database"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "A record has been updated"),
            @ApiResponse(code = 404, message = "Record with 'id' does not exist.")
    })
    @RequestMapping (
            method = RequestMethod.PATCH,
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity updateTypeOfEntity(@RequestBody TypeOfEntityModelJsonCU typeOfEntityModelJsonCU){
        try {
            typeOfEntityService.updateTypeOfEntity(typeOfEntityModelJsonCU);
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

    @ApiOperation(
            value = "Delete type of entity.",
            notes = "Delete a type of entity with 'id'."
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Record successfully deleted."),
            @ApiResponse(code = 404, message = "Record not found.")
    })
    @RequestMapping(
            method = RequestMethod.DELETE,
            produces = "application/json"
    )
    public ResponseEntity<Message> deleteTypeOfEntity(Long id) {
        typeOfEntityService.deleteTypeOfEntity(id);
        Message msg = Message.builder()
                .messageId(999)
                .messageClass(MessageClassesEnum.INFO)
                .messageText("Record deleted.")
                .build();
        return new ResponseEntity<Message>(msg, HttpStatus.OK);
    }

}
