package com.chatapp.dao;



import java.util.List;

import com.chatapp.model.Friend;

public interface FriendDao {

	void addFriend(Friend friend);
	void updateFriend(Friend friend);
	void deleteFriend(Friend friend);
	List<Friend> viewFriends(String name);
	
}

