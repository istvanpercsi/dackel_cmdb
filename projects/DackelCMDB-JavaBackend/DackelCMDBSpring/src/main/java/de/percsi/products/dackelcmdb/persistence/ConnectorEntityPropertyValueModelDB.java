package de.percsi.products.dackelcmdb.persistence;

import lombok.Data;

import javax.persistence.*;

@Entity(name = Tables.CONNECTOR_ENTITY_PROPERTY_VALUE)
@Table(name = Tables.CONNECTOR_ENTITY_PROPERTY_VALUE)
@Data
public class ConnectorEntityPropertyValueModelDB {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  Long id;

  @ManyToOne
  @JoinColumn(name = "entity_id")
  EntityDataModelDB entity;

  @ManyToOne
  @JoinColumn(name = "property_id")
  EntityDataModelDB property;

}
