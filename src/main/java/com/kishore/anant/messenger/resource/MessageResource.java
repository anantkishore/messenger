/**
 * 
 */
package com.kishore.anant.messenger.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kishore.anant.messenger.entity.Message;
import com.kishore.anant.messenger.service.MessageService;

/**
 * @author i351596
 *
 */
@Path("/messages")
public class MessageResource {

	/**
	 * 
	 */
	public MessageResource() {
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessage() {
		return new MessageService().getAllMessages();
	}

	@POST
	public String createMessage() {
		return "Have a good day.";
	}

}
