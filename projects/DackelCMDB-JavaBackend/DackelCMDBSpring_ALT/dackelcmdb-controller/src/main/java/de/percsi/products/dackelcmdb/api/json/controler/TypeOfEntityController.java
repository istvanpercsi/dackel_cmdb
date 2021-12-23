package de.percsi.products.dackelcmdb.api.json.controler;

//import de.percsi.products.dackelcmdb.api.json.messages.OperationalMessage;
//import de.percsi.products.dackelcmdb.api.json.messages.OperationalMessagesEnum;
//import de.percsi.products.dackelcmdb.api.json.model.TypeOfEntityModelJson;
//import de.percsi.products.dackelcmdb.service.TypeOfEntityService;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/typeOfEntities")
public class TypeOfEntityController {

//    private TypeOfEntityService typeOfEntityService;
//
//    @Autowired
//    public TypeOfEntityController(TypeOfEntityService typeOfEntityService) {
//        this.typeOfEntityService = typeOfEntityService;
//    }
//
//    @ApiOperation(
//            value = "Get all entities which had not been deleted.",
//            notes = "Returns a list of Type of Entity"
//    )
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "Returns with a List of Type of Entity which had not been deleted.")
//    })
//    @RequestMapping(
//            method = RequestMethod.GET,
//            produces = "application/json"
//    )
//    public ResponseEntity<List<TypeOfEntityModelJson>> getAllTypeOfEntity() {
//        return new ResponseEntity<>(typeOfEntityService.readAllTypeOfEntity(), HttpStatus.OK);
//    }
//
//    @ApiOperation(
//            value = "Get entity where the 'id' is passed.",
//            notes = "Returns a Type of Entity"
//    )
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "Returns with a Type of Entity where the 'id' is passed"),
//            @ApiResponse(code = 404, message = "Record with 'id' not found.")
//    })
//    @RequestMapping(
//            method = RequestMethod.GET,
//            path = "/{id}",
//            produces = "application/json"
//    )
//    public ResponseEntity<TypeOfEntityModelJson> getTypeOfEntityById(@PathVariable(name = "id") Long id) {
//        return new ResponseEntity<>(typeOfEntityService.readTypeOfEntity(id),HttpStatus.OK);
//    }
//
//
//
//    @ApiOperation(
//            value = "Create a new type of entity",
//            notes = "Save a new type of entity into database"
//    )
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "New record has been created"),
//            @ApiResponse(code = 409, message = "Record with 'id' exists already.")
//    })
//    @RequestMapping(
//            method = RequestMethod.POST,
//            consumes = "application/json",
//            produces = "application/json"
//    )
//    public ResponseEntity createTypeOfEntity(@RequestBody TypeOfEntityModelJson typeOfEntityModelJson) {
//        typeOfEntityService.createTypeOfEntity(typeOfEntityModelJson);
//        return new ResponseEntity<>(OperationalMessagesEnum.RECORD_SAVED.getMessage(),HttpStatus.CREATED);
//    }
//
//    @ApiOperation(
//            value = "Update a  type of entity",
//            notes = "Update type of entity into database"
//    )
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "A record has been updated"),
//            @ApiResponse(code = 404, message = "Record with 'id' does not exist.")
//    })
//    @RequestMapping (
//            method = RequestMethod.PATCH,
//            consumes = "application/json",
//            produces = "application/json"
//    )
//    public ResponseEntity updateTypeOfEntity(@RequestBody TypeOfEntityModelJson typeOfEntityModelJson) {
//        typeOfEntityService.updateTypeOfEntity(typeOfEntityModelJson);
//        return new ResponseEntity<>(OperationalMessagesEnum.RECORD_SAVED.getMessage(),HttpStatus.OK);
//    }
//
//    @ApiOperation(
//            value = "Delete type of entity.",
//            notes = "Delete a type of entity with 'id'."
//    )
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "Record successfully deleted."),
//            @ApiResponse(code = 404, message = "Record not found.")
//    })
//    @RequestMapping(
//            method = RequestMethod.DELETE,
//            produces = "application/json"
//    )
//    public ResponseEntity<OperationalMessage> deleteTypeOfEntity(Long id) {
//        typeOfEntityService.deleteTypeOfEntity(id);
//        return new ResponseEntity<>(
//                OperationalMessagesEnum.RECORD_DELETED.getMessage(),
//                HttpStatus.OK);
//    }

}
