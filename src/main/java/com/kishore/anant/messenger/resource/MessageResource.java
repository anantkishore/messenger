/**
 * 
 */
package com.kishore.anant.messenger.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kishore.anant.messenger.entity.Comment;

/**
 * @author i351596
 *
 */
@Path("/comments")
public class MessageResource {

	/**
	 * 
	 */
	public MessageResource() {
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getMessage() {
		
		List<Comment> comments = new ArrayList<Comment>();
		Comment comment = new Comment();
		comment.setId("2");
		comment.setText("text");
		comment.setCreatedDate(new Date());
		comment.setAuthor("Anant Kishore");
		comments.add(comment);
		return comments;
	}

	@POST
	public String createMessage() {
		return "Have a good day.";
	}

}
