package de.percsi.products.dackelcmdb.persistence;

import lombok.Data;

import javax.persistence.*;

@Entity(name = Tables.VALUE_STR)
@Table(name = Tables.VALUE_STR)
@Data
class ValueSTR {

  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "id", nullable = false)
  EntityPropertyValueConnectorModelDB entityPropertyValueConnectorModelDB;

  @Column(name = "value")
  private String value;
}
