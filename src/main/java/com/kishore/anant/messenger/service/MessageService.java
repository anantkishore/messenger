/**
 * 
 */
package com.kishore.anant.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kishore.anant.messenger.entity.Message;

/**
 * @author i351596
 *
 */
public class MessageService {
	
	/**
	 * 
	 */
	public MessageService() {
	}
	
	public List<Message> getAllMessages() {
		
		
		Message m1 = new Message(1, "One", new Date(), "Anant");
		Message m2 = new Message(2, "Two", new Date(), "Kishore");
		
		List<Message> messages = new ArrayList<>();
		
		messages.add(m1);
		messages.add(m2);
		
		return messages;
		
	}

}
