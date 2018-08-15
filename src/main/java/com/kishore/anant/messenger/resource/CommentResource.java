/**
 * 
 */
package com.kishore.anant.messenger.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author i351596
 *
 */
@Path("/")
public class CommentResource {

	/**
	 * 
	 */
	public CommentResource() {
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String test()
	{
			return "test";
	}
	
	

}
