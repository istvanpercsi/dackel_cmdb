package de.percsi.products.dackelcmdb.javaee.jboss.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: DBase
 *
 */

@MappedSuperclass
public class DABase implements Serializable {

	private static final long serialVersionUID = 1L;

	public DABase() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="modification_date")
	private Date modificationDate;
	
	@Column(name="creation_user")
	private String creationUser;
	
	@Column(name="modification_user")
	private String modificationUser;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public String getModificationUser() {
		return modificationUser;
	}

	public void setModificationUser(String modificationUser) {
		this.modificationUser = modificationUser;
	}
	
	
	
}
