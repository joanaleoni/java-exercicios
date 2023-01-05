package entities;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
	private static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.of("Zulu"));
	private Instant moment;
	private String title;
	private String content;
	private Integer likes;
	private List<Comment> comments;
	
	public Post() {
		this.likes = 0;
	}

	public Post(Instant moment, String title, String content) {
		super();
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = 0;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void addLike() {
		this.likes++;
	}
	
	public void removeLike() {
		this.likes--;
	}
	
	public void addComment(Comment comment) {
		if(this.comments == null) 
			this.comments = new ArrayList<>();
		
		this.comments.add(comment);
	}
	
	public void removeComment(Comment comment) {
		this.comments.remove(comment);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();		
		sb.append(this.title).append("\n");
		sb.append(this.likes).append(" Likes - ").append(df.format(this.moment)).append("\n");
		sb.append(this.content).append("\n");
		sb.append("Comments: \n");
		
		if(this.comments != null) {
			for(Comment c : this.comments) 
				sb.append(c.getText()).append("\n");
		}
		return sb.toString();
	}
}