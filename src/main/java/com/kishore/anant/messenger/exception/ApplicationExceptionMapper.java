package com.kishore.anant.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<ApplicationException> {

	public ApplicationExceptionMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Response toResponse(ApplicationException appEx) {
		
		return Response.status(Status.NOT_FOUND)
				.entity(appEx.getErrorMessage())
				.build();
	}

}
