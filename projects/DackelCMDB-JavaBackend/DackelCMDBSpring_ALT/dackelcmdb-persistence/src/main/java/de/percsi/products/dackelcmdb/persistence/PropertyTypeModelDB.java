package de.percsi.products.dackelcmdb.persistence;

import lombok.Data;

import javax.persistence.*;

@Entity(name = Tables.PROPERTY_TYPE)
@Table(name = Tables.PROPERTY_TYPE)
@Data
public class PropertyTypeModelDB {

  @Id
  @Column(name = "id")
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "id", nullable = false)
  private EntityDataModelDB entityDataModelDB;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private PropertyType propertyType;
}
