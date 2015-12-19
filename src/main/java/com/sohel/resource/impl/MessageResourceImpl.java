package com.sohel.resource.impl;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.springframework.stereotype.Service;

import com.sohel.model.Message;
import com.sohel.resource.beans.MessageFilterBean;
import com.sohel.service.MessageService;
import com.sohel.resource.MessageResource;;


@Service("messageService")
public class MessageResourceImpl implements MessageResource {

	MessageService messageService = new MessageService();
	
	@Override
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}

	@Override
	public void addMessage(Message message, @Context UriInfo uriInfo) {
		
		messageService.addMessage(message);
	}
	
	@Override
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@Override
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}
	
	
	@Override
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) {
		Message message = messageService.getMessage(id);
		return message;
		
	}
	
}