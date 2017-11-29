package com.chatapp.dao;



import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.chatapp.model.AnswerForum;
import com.chatapp.model.BlogComment;

@Repository
@ComponentScan("com.nik")
public interface AnswerForumDao {
	void answerForum(AnswerForum answerForum);
	List<AnswerForum> viewAnswers(String forumid);
}
