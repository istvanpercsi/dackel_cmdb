package de.percsi.products.dackelcmdb.javaee.jboss.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: DTypeOfEntity
 *
 */
@Entity
@Table(name="typesOfEntity")
public class DTypeOfEntity extends DAETPBase implements Serializable {
	
	private static final long serialVersionUID = 1L;
	   
	//Entities of type
	@OneToMany(mappedBy="typeOfEntity", fetch=FetchType.LAZY)
	private Set<DAEntity> entity;
}
