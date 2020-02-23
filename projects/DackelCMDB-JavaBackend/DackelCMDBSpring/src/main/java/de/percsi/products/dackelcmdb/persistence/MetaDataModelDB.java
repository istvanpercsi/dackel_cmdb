package de.percsi.products.dackelcmdb.persistence;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;


@Entity(name = "MetaData")
@Table(name = "meta_data")
@Data
class MetaDataModelDB {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "create_user")
  private String createUser;

  @Column(name = "create_date")
  private Date createDate;

  @Column(name = "modify_user")
  private String modifyUser;

  @Column(name = "modify_date")
  private Date modifyDate;

}
