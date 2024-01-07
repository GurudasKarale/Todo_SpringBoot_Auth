package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;


@Entity
public class Todo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String task;
	
	@ManyToOne
	private User author;
	
	@Transient
	private String todoAssociatedUser;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

//	public User getAuthor() {
//		return author;
//	}

	public void setAuthor(User author) {
		this.author = author;
	}

	
}
