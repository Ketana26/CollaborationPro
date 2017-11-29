package com.chatapp.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class AnswerForum {
@Id@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String forumid;
	private String answer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getForumid() {
		return forumid;
	}
	public void setForumid(String forumid) {
		this.forumid = forumid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}

