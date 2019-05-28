/**
 * 
 */
package de.percsi.products.dackelcmdb.javaee.jboss.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import de.percsi.products.dackelcmdb.javaee.jboss.model.DTypeOfEntity;

/**
 * @author istva
 *
 */
@RequestScoped
@Path("/dtypeofentities")
@Produces("application/json")
@Consumes("application/json")
public class DTypeOfEntityEndpoint {

	/**
	* @param dtypeofentity
	* @return
	*/
	@POST
	public Response create(final DTypeOfEntity dtypeofentity) {
		//TODO: process the given dtypeofentity 
		//you may want to use the following return statement, assuming that DTypeOfEntity#getId() or a similar method 
		//would provide the identifier to retrieve the created DTypeOfEntity resource:
		//return Response.created(UriBuilder.fromResource(DTypeOfEntityEndpoint.class).path(String.valueOf(dtypeofentity.getId())).build()).build();
		return Response.created(null).build();
	}

	/**
	* @param id
	* @return
	*/
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		//TODO: retrieve the dtypeofentity 
		DTypeOfEntity dtypeofentity = null;
		if (dtypeofentity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(dtypeofentity).build();
	}

	/**
	* @param startPosition
	* @param maxResult
	* @return
	*/
	@GET
	public List<DTypeOfEntity> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		//TODO: retrieve the dtypeofentities 
		final List<DTypeOfEntity> dtypeofentities = null;
		return dtypeofentities;
	}

	/**
	* @param id
	* @param dtypeofentity
	* @return
	*/
	@PUT
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Long id, final DTypeOfEntity dtypeofentity) {
		//TODO: process the given dtypeofentity 
		return Response.noContent().build();
	}

	/**
	* @param id
	* @return
	*/
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		//TODO: process the dtypeofentity matching by the given id 
		return Response.noContent().build();
	}

}
