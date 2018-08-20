/**
 * 
 */
package com.kishore.anant.messenger.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.kishore.anant.messenger.entity.Wine;
import com.kishore.anant.messenger.exception.DaoException;
import com.kishore.anant.messenger.service.WineService;

/**
 * @author i351596
 *
 */
@Path("/wines")
public class WineResource {

	private WineService wineService = new WineService();

	/**
	 * 
	 */
	public WineResource() {

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Wine> getWines(
			@QueryParam("year") int years,
			@QueryParam("offset") int offset,
			@QueryParam("pageSize") int pageSize) {
		long time1 = System.currentTimeMillis();
		try {
			if(offset >= 0 && pageSize > 0)
				return wineService.fetchAllWine(offset, pageSize);
			return wineService.fetchAllWine();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		long time2 = System.currentTimeMillis();
		System.out.println("Time taken:: "+ (time2-time1));
		return new ArrayList<Wine>();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Wine getWine(@PathParam("id") String id) throws DaoException
	{
		return wineService.fetchWine(id);
	}
	
	@DELETE
	@Path("/{id}")
	public Wine deleteWine(@PathParam("id") String id) throws DaoException
	{
		return wineService.deleteWine(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Wine createWine(Wine wine)
	{
		try {
			return wineService.createWine(wine);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Wine updateWine(@PathParam("id") String id, Wine wine) throws DaoException
	{
		return wineService.updateWine(id, wine);
	}
	
	@Path("{wineId}")
	public CommentResource getComment()
	{
		return new CommentResource();
	}
}
