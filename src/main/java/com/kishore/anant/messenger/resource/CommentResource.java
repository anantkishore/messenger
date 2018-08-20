/**
 * 
 */
package com.kishore.anant.messenger.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.kishore.anant.messenger.entity.Comment;
import com.kishore.anant.messenger.entity.Wine;
import com.kishore.anant.messenger.exception.ApplicationException;
import com.kishore.anant.messenger.exception.DaoException;
import com.kishore.anant.messenger.exception.model.ErrorMessage;
import com.kishore.anant.messenger.service.CommentService;

/**
 * @author i351596
 *
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

	private CommentService commentService = new CommentService();
	
	public CommentResource()
	{
	}
	
	@GET
	@Path("comments")
	public List<Comment> getAllComments(@PathParam("wineId") String wineId)
	{
		try {
			return commentService.getAllComments(wineId);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("comments/{commentId}")
	public Comment getComment(@PathParam("wineId") String wineId, @PathParam("commentId") String commentId) throws ApplicationException
	{
		try {
			Comment comment =  commentService.getComment(wineId, commentId);
			if(comment == null)
			{
				throw new ApplicationException(new ErrorMessage("Data Not Found.", 404, "http://anantkishore.com"));
			}
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@POST
	@Path("comments")
	public Response getTest2(@PathParam("wineId") String wineId, Comment comment, @Context UriInfo uriInfo)
	{
		try {
			Wine wine =  commentService.createComment(wineId, comment);
			URI uri = uriInfo.getAbsolutePathBuilder().path(comment.getId()).build();
			return Response.created(uri)
					.entity(wine).build();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
