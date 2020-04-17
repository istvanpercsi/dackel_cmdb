package de.percsi.products.dackelcmdb.persistence;

import lombok.Data;

import javax.persistence.*;

@Entity(name = Tables.CONNECTOR_ENTITY_TYPE_OF_ENTITY)
@Table(name = Tables.CONNECTOR_ENTITY_TYPE_OF_ENTITY)
@Data
class ConnectorEntityTypeOfEntityModelDB {

  @Id
  @Column(name = "id")
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "id", nullable = false)
  EntityDataModelDB entity;

  @ManyToOne
  @JoinColumn(name = "type_of_entity_id")
  EntityDataModelDB typeOfEntity;

}
