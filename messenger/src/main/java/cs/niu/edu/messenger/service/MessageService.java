package cs.niu.edu.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cs.niu.edu.messenger.database.DatabaseClass;
import cs.niu.edu.messenger.exception.DataNotFoundException;
import cs.niu.edu.messenger.model.Message;

public class MessageService {
	private Map<Long, Message> messages=DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1l, new Message(1L,"Hello world!","Anwar"));
		messages.put(2l, new Message(2L,"Hello jersey!","Zaffar"));
	}
	
	public List<Message> getAllMessageforYear(int year){
		List<Message> messagesforYear=new ArrayList<>();
		for(Message message: messages.values()){
			if(message.getCreated().getYear()==year)
				messagesforYear.add(message);
		}
		return messagesforYear;
	}
	
	public List<Message> getAllMessagesPaginated(int  start, int size){
		ArrayList<Message> list=new ArrayList<>(messages.values());
		if(start  + size> list.size())
			return new ArrayList<Message>();
		return list.subList(start, start+size);
	}
	
	public List<Message> getAllMessges(){
		return new ArrayList<>(messages.values());
	}
	public Message getMessage(long id){
		Message message=messages.get(id);
		if(message==null)
			throw new DataNotFoundException("Message with id "+id+" not found!");
		return message;
	}
	public Message updateMessage(Message message){
		if(message.getId()<=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	public Message removeMessage(long id){
		return messages.remove(id);
	}
}