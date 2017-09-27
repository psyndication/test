package facebroke.model;

import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Comments")
public class Comment {

	private String content;

	private ZonedDateTime created, updated;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "creator_id")
	private User creator;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Post parent;

	// Constructor for Hibernate
	private Comment() {
	}

	/**
	 * Build a Comment
	 * 
	 * @param creator
	 *            - user creating the comment
	 * @param parent
	 *            - parent the comment is on
	 * @param content
	 */
	public Comment(User creator, Post parent, String content) {
		this.creator = creator;
		this.parent = parent;
		this.content = content;
		this.created = this.updated = ZonedDateTime.now();
	}

	public String getContent() {
		return content;
	}

	public ZonedDateTime getCreated() {
		return created;
	}

	public User getCreator() {
		return creator;
	}

	public ZonedDateTime getUpdated() {
		return updated;
	}

	public void setContent(String content) {
		this.content = content;
		this.updated = ZonedDateTime.now();
	}

	public void setCreated(ZonedDateTime created) {
		this.created = created;
		this.updated = ZonedDateTime.now();
	}

	public void setCreator(User creator) {
		this.creator = creator;
		this.updated = ZonedDateTime.now();
	}

}
