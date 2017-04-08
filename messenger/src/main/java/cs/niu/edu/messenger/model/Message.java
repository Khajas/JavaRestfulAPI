package cs.niu.edu.messenger.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement

public class Message {
	private long id;
	private LocalDate created=LocalDate.now();
	private String message;
	private String author;
	private Map<Long, Comment> comments=new HashMap<>();
	public Message(){}
	
	public Message(long id, String message, String author) {
		super();
		this.id = id;
		this.created = LocalDate.now();
		this.message = message;
		this.author = author;
	}
	public long getId() {
		return id;
	}
	public LocalDate getCreated() {
		return created;
	}
	public String getMessage() {
		return message;
	}
	public String getAuthor() {
		return author;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setCreated(LocalDate created) {
		this.created = created;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@XmlTransient	// Since we don't want the comments data when only message is pulled out
					// Ignore for XML and JSON conversation
	public Map<Long, Comment> getComments(){
		return comments;
	}
	
	public void setComments(Map<Long, Comment> comments){
		this.comments=comments;
	}
	
}
