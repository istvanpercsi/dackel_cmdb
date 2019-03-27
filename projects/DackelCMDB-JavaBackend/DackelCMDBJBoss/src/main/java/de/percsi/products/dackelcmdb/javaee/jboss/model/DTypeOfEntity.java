package de.percsi.products.dackelcmdb.javaee.jboss.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: DTypeOfEntity
 *
 */
@Entity
@Table(name="typesOfEntity")
public class DTypeOfEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//primary key
	@Id
	private long id;
	
	//System name of entity only alphanumeric characters and it must be unique
	private String systemName;
	
	//Display name of type of entity
	private String displayName;
   
	//Entities of type
	@OneToMany(mappedBy = "typeOfEntity")
	private Set<DEntity> entity;
	
}
