/**
 * 
 */
package com.kishore.anant.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author i351596
 *
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	/**
	 * 
	 */
	public GenericExceptionMapper() {
		
	}

	@Override
	public Response toResponse(Throwable arg0) {
		
		return Response.status(Status.BAD_REQUEST).entity("404").build();
	}

}
