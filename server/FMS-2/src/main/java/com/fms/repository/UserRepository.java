package com.fms.repository;

import java.util.ArrayList;

import com.fms.model.User;

public interface UserRepository {
	ArrayList<User> getUser();
	User getUserById(int userId);
	User addUser(User user);
	User updateUser(int UserId, User user);
	void deleteUser(int userId);

}
