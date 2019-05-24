package de.percsi.products.dackelcmdb.javaee.jboss.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class DAEntity extends DABase implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//sytem name of entity
	@Column(unique=true, nullable=false, name="system_name")
	private String systemName;
	
	//display name of entity
	@Column(nullable=false, name="display_name")
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
