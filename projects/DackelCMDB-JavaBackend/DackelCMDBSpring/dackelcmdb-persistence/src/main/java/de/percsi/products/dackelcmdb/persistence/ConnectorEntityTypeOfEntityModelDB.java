package de.percsi.products.dackelcmdb.persistence;

import lombok.*;

import javax.persistence.*;

@Entity(name = Tables.CONNECTOR_ENTITY_TYPE_OF_ENTITY)
@Table(name = Tables.CONNECTOR_ENTITY_TYPE_OF_ENTITY)
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class ConnectorEntityTypeOfEntityModelDB {

  @Id
  @Column(name = "entity_id")
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "entity_id", nullable = false)
  EntityDataModelDB entity;

  @ManyToOne
  @JoinColumn(name = "type_of_entity_id")
  EntityDataModelDB typeOfEntity;

}
