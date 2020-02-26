package de.percsi.products.dackelcmdb.persistence;

import lombok.Data;

import javax.persistence.*;

@Entity(name = Tables.ENTITY_PROPERTY_VALUE_CONNECTOR)
@Table(name = Tables.ENTITY_PROPERTY_VALUE_CONNECTOR)
@Data
public class EntityPropertyValueConnectorModelDB {

  @Id
  Long id;

  @ManyToOne
  @JoinColumn(name = "entity_id")
  EntityDataModelDB entity;

  @ManyToOne
  @JoinColumn(name = "property_id")
  EntityDataModelDB property;

}
