package de.percsi.products.dackelcmdb.persistence;

import javax.persistence.*;

@Entity
@Table(name = Tables.PROPERTYTYPE)
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
