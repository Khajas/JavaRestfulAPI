package cs.niu.edu.messenger.model;

import java.time.LocalDate;

public class Comment {
	private long id;
	private String message;
	private LocalDate created;
	private String author;
	
	public Comment(){
		created=LocalDate.now();
	}
	
	public Comment(long id, String message, String author) {
		super();
		this.id = id;
		this.message = message;
		this.created = LocalDate.now();
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	

}
