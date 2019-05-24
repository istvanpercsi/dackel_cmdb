package de.percsi.products.dackelcmdb.javaee.jboss.model;

import de.percsi.products.dackelcmdb.javaee.jboss.model.DAETPBase;
import de.percsi.products.dackelcmdb.javaee.jboss.model.DTypeOfEntity;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: DAEntity
 *
 */
@Entity
@Table(name="active_entity")
public class DAEntity extends DAETPBase implements Serializable {

	@ManyToOne()
	@JoinColumn(name="type_of_entity_id")
	private DTypeOfEntity typeOfEntity;
	
	private static final long serialVersionUID = 1L;

	public DAEntity() {
		super();
	}   
	
	public DTypeOfEntity getTypeOfEntity() {
		return this.typeOfEntity;
	}

	public void setTypeOfEntity(DTypeOfEntity typeOfEntity) {
		this.typeOfEntity = typeOfEntity;
	}
   
}
