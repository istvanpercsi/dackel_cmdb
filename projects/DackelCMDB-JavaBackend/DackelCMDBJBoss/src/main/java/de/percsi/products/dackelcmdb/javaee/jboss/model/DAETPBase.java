package de.percsi.products.dackelcmdb.javaee.jboss.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Implementation class for Entity, TypeOfEntity, and Property 
 */
@MappedSuperclass
public class DAETPBase extends DABase implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//sytem name of entity
	@Column(unique=true, nullable=false, name="system_name")
	private String systemName;
	
	//display name of entity
	@Column(nullable=false, name="display_name")
	private String displayName;
	
	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
