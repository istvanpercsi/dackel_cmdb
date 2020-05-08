package de.percsi.products.dackelcmdb.persistence_alt.model;

import de.percsi.products.dackelcmdb.persistence_alt.model.base.BaseWithUserDateAndDeletedFlagModelDB;
import de.percsi.products.dackelcmdb.persistence_alt.model.base.ColumnNameOfTypeOfPropertyOfEntityConst;
import de.percsi.products.dackelcmdb.persistence_alt.model.base.TablesConst;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = TablesConst.VALUE_OF_PROPERTY_OF_ENTITY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
public class ValueOfPropertyOfEntityModelDB extends BaseWithUserDateAndDeletedFlagModelDB implements Serializable {

  @ManyToOne
  @JoinColumn(name = "entity_id")
  private EntityModelDB entity;

  @ManyToOne
  @JoinColumn(name = "property_id")
  private PropertyOfEntityModelDB property;

  @Column(name = ColumnNameOfTypeOfPropertyOfEntityConst.NUMBER)
  private Double valueNUM;

  @Column(name = ColumnNameOfTypeOfPropertyOfEntityConst.STRING)
  private String valueSTR;

  @Column(name = ColumnNameOfTypeOfPropertyOfEntityConst.SECURE)
  private String valueSEC;

  @Column(name = ColumnNameOfTypeOfPropertyOfEntityConst.DATE)
  private Date valueDAT;

  @Column(name = ColumnNameOfTypeOfPropertyOfEntityConst.ENTITY)
  private Long valueENT;

}
