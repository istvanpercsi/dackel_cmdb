package de.percsi.products.dackelcmdb.persistence.model;

import de.percsi.products.dackelcmdb.persistence.model.base.BaseModelDB;
import de.percsi.products.dackelcmdb.persistence.model.base.ColumnNameOfTypeOfPropertyOfEntityConst;
import de.percsi.products.dackelcmdb.persistence.model.base.TablesConst;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = TablesConst.CONNECTOR_OF_ENTITY_PROPERTY_VALUE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
public class ValueOfPropertyOfEntityModelDB extends BaseModelDB implements Serializable {

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
