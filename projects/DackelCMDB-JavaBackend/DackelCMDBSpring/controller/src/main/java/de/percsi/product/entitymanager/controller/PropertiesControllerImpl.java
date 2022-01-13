package de.percsi.product.entitymanager.controller;

import de.percsi.product.entitymanager.domain.ListOfSimplePropertyResponse;
import de.percsi.product.entitymanager.service.PropertiesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class PropertiesControllerImpl implements PropertiesController {


  private final PropertiesService propertiesService;

  public PropertiesControllerImpl(@Autowired PropertiesService propertiesService) {
    this.propertiesService = propertiesService;
  }

  @Override
  public ResponseEntity<ListOfSimplePropertyResponse> getProperties(Long page, Long size, String filter) {
    log.info("getProperties is called");
    return new ResponseEntity<>(propertiesService.getProperties(page, size, filter), HttpStatus.OK);
  }
}
