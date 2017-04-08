package cs.niu.edu.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import cs.niu.edu.messenger.service.MessageService;
import cs.niu.edu.messenger.model.Message;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	MessageService ms=new MessageService();
	
	@GET
	public List<Message> getAllMessagesforYear(@BeanParam MessageFilterBean filterBean){
		if(filterBean.getYear() > 0)
			return ms.getAllMessageforYear(filterBean.getYear());
		if((filterBean.getStart() >= 0) && (filterBean.getSize() >0))
			return ms.getAllMessagesPaginated(filterBean.getStart() , filterBean.getSize());
		return ms.getAllMessges();
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") Long messageId){
		return ms.getMessage(messageId);
	}
	
	@POST
	public Message addMessage(Message message){
		return ms.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message){
		message.setId(id);
		return ms.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id){
		ms.removeMessage(id);
	}

// No matter what HTTP request is Jax Rs will return commentResource
// and looks into that resource for specific requests
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}

}