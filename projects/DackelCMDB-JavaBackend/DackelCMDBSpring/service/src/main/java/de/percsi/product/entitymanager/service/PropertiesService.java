package de.percsi.product.entitymanager.service;

import de.percsi.product.entitymanager.domain.ListOfSimplePropertyResponse;
import org.apache.commons.lang3.NotImplementedException;

public interface PropertiesService {

  default ListOfSimplePropertyResponse getProperties(Long page, Long size, String filter) {
    throw new NotImplementedException("PropertiesService.getProperties");
  }



}
