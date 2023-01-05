package main;

import java.time.Instant;

import entities.Comment;
import entities.Post;

public class Main {

	public static void main(String[] args) {		
		Post p1 = new Post(Instant.parse("2018-06-21T13:05:44Z"), "Traveling to New Zealand", "I'm going to visit this wonderful country!");
		Post p2 = new Post(Instant.parse("2018-07-28T23:14:19Z"), "Good night guys", "See you tomorrow");
		
		for(int i=0; i<12; i++) p1.addLike();
		for(int i=0; i<5; i++) p2.addLike();
		
		p1.addComment(new Comment("Have a nice trip"));
		p1.addComment(new Comment("Wow, that's awesome!"));
		
		p2.addComment(new Comment("Good night"));
		p2.addComment(new Comment("May the Force be with you"));
		
		System.out.println(p1);
		System.out.println(p2);
	}
}