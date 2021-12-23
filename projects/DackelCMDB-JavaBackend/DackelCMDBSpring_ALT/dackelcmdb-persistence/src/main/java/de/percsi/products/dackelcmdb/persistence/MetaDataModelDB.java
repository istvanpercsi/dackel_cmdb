package de.percsi.products.dackelcmdb.persistence;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Entity(name = Tables.METADATA)
@Table(name = Tables.METADATA)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MetaDataModelDB {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "create_user")
  private String createUser;

  @Column(name = "create_date")
  private Date createDate;

  @Column(name = "modify_user")
  private String modifyUser;

  @Column(name = "modify_date")
  private Date modifyDate;

  @Column(name = "deleted")
  private Boolean deleted;

}
