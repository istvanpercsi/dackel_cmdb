package de.percsi.products.dackelcmdb.javaee.jboss.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: DEntity
 * This class represents an Entity in CMDB, an Entity has more properties, and it has one Type. 
 * 
 */
@Entity
@Table(name="entities")
public class DEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	//primary key of Entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//sytem name of entity
	@Column(unique=true, nullable=false)
	private String systemName;
	
	//display name of entity
	@Column(nullable=false)
	private String displayName;
	
	@ManyToOne
	@JoinColumn(name = "typeOfEntityId")
	private DTypeOfEntity typeOfEntity;
	
	/**
	 * This method set system name. System name must contain only alphanumeric characters
	 * @param systemName system name of entity
	 */
	public void setSystemName(String systemName)
	{
		this.systemName = systemName;
	}
	
	/**
	 * This method get system name and return with
	 * @return String system name of entity
	 */
	public String getSystemName() 
	{
		return this.systemName;
	}
	
	/**
	 * This method set display name of entity. This can be displayed on WebGui. It can be contain all character set.
	 * @param displayName String display name of entity
	 */
	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}
	
	/**
	 * This method returns with display name of an entity
	 * @return String display name of entity
	 */
	public String getDisplayName()
	{
		return this.displayName;
	}
	
	
}
