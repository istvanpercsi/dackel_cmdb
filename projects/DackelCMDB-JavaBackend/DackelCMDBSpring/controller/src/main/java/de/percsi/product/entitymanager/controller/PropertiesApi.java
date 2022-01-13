package de.percsi.product.entitymanager.controller;

import de.percsi.product.entitymanager.configuration.ConfigForSpringDoc;
import de.percsi.product.entitymanager.domain.Error;
import de.percsi.product.entitymanager.domain.ExtendedPropertyResponse;
import de.percsi.product.entitymanager.domain.ListOfSimplePropertyResponse;
import de.percsi.product.entitymanager.domain.SimplePropertyRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

public interface PropertiesApi {

  @Operation(summary = "List of valid properties",
      description = "Lists all of the properties, which are saved in system, and it can be attach to the entity.",
      tags={ConfigForSpringDoc.Tags.PROPERTIES})
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200",
          description = "Returns the list of saved property types",
          content = @Content(mediaType = "application/json", schema = @Schema(implementation = ListOfSimplePropertyResponse.class))),
      @ApiResponse(responseCode = "400",
          description = "Bad request error, it can happen if some of the parameters are wrong, or out of range.",
          content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
      @ApiResponse(responseCode = "500",
          description = "Internal server error happened. Details in error message.",
          content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
  @RequestMapping(value = "/properties",
      produces = { "application/json" },
      method = RequestMethod.GET)
  default ResponseEntity<ListOfSimplePropertyResponse> getProperties(
      @Parameter(in = ParameterIn.QUERY, description = "Page of the result list", schema=@Schema())
      @Valid
      @RequestParam(value = "page", required = false)
          Long page,
      @Parameter(in = ParameterIn.QUERY, description = "Size of the page of the result list" ,schema=@Schema())
      @Valid
      @RequestParam(value = "size", required = false)
          Long size,
      @Parameter(in = ParameterIn.QUERY, description = "Filtered value of the entity. Magic character * can be used" ,schema=@Schema())
      @Valid
      @RequestParam(value = "filter", required = false)
          String filter) {

    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  @Operation(summary = "Get property and its metadata",
      description = "It returns detailed informations about selected property.",
      tags={ ConfigForSpringDoc.Tags.PROPERTIES })
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200",
              description = "Returns with the selected property",
              content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExtendedPropertyResponse.class))),
          @ApiResponse(responseCode = "404",
              description = "Not found, if the given uuid is not exists.",
              content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
          @ApiResponse(responseCode = "500",
              description = "Internal server error happened. Details in error message.",
              content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
  @RequestMapping(value = "/property/{uuidOfProperty}",
          produces = { "application/json" },
          method = RequestMethod.GET)
  default ResponseEntity<ExtendedPropertyResponse> getProperty(
      @Parameter(in = ParameterIn.PATH, description = "UUID Of Property. It is an uniq identifier of property", required=true, schema=@Schema())
      @Valid
      @PathVariable("uuidOfProperty") UUID uuidOfProperty) {

    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  @Operation(summary = "Saves a new property",
      description = "Saves a new property with their settings.",
      tags={ ConfigForSpringDoc.Tags.PROPERTIES })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200",
          description = "Returns the saved new property",
          content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExtendedPropertyResponse.class))),
      @ApiResponse(responseCode = "409",
          description = "Conflict, it can happen if the property with this name is already saved in system.",
          content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
      @ApiResponse(responseCode = "500",
          description = "Internal server error",
          content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
  @RequestMapping(value = "/property",
      produces = { "application/json" },
      consumes = { "application/json" },
      method = RequestMethod.POST)
  default ResponseEntity<ExtendedPropertyResponse> saveProperty(
      @Parameter(in = ParameterIn.DEFAULT, description = "Simple request, it contains all information which is necessary to create a property", schema=@Schema())
      @Valid
      @RequestBody SimplePropertyRequest body) {

    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  @Operation(summary = "Updates property",
      description = "Updates the data of property, it is only possible if the property does not attached to the entity.",
      tags={ ConfigForSpringDoc.Tags.PROPERTIES })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200",
          description = "Returns the updated property",
          content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExtendedPropertyResponse.class))),
      @ApiResponse(responseCode = "405",
          description = "Not allowed, it can happen if the property is already in use, also attached to the entity.",
          content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
      @ApiResponse(responseCode = "409",
          description = "Conflict, it can happen if the property with this name is already saved in system.",
          content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
      @ApiResponse(responseCode = "500",
          description = "Internal server error",
          content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
  @RequestMapping(value = "/property/{uuidOfProperty}",
      produces = { "application/json" },
      consumes = { "application/json" },
      method = RequestMethod.PUT)
  default ResponseEntity<ExtendedPropertyResponse> updateProperty(
      @Parameter(in = ParameterIn.PATH, description = "UUID of property, it is a uniq identifier of Property", required=true, schema=@Schema())
      @Valid
      @PathVariable("uuidOfProperty") UUID uuidOfProperty,
      @Parameter(in = ParameterIn.DEFAULT, description = "Simple request, it contains all information to modify the property", schema=@Schema())
      @Valid
      @RequestBody SimplePropertyRequest body) {

    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

}
