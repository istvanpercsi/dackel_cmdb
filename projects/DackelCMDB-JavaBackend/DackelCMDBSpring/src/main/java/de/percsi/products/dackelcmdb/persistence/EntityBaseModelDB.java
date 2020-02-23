package de.percsi.products.dackelcmdb.persistence;



import lombok.Data;

import javax.persistence.*;

@Entity(name = "EntityBase")
@Table(name = "entity_base")
@Data
class EntityBaseModelDB {
  
  @Id
  @Column(name = "id")
  Long id;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "id", nullable = false)
  private MetaDataModelDB metaData;

  @Column(name = "display_name")
  private String displayName;

  @Column(name = "system_name")
  private String systemName;



}
