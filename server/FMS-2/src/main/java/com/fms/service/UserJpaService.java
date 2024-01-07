package com.fms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fms.model.User;

import com.fms.repository.UserJpaRepository;
import com.fms.repository.UserRepository;

@Service
public class UserJpaService implements UserRepository {

	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Override
	public ArrayList<User> getUser() {
		List<User> userList=userJpaRepository.findAll();
		ArrayList<User> user=new ArrayList<>(userList);
		return user;
	}

	@Override
	public User getUserById(int userId) {
		try
		{
		User user= userJpaRepository.findById((long) userId).get();
		return user;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public User addUser(User user) {
		userJpaRepository.save(user);
		 return user;

	}

	@Override
	public User updateUser(int userId, User user) {
		try
		{
		User existingUser= userJpaRepository.findById((long) userId).get();
		if(user.getUserEmail()!=null)
		{
			existingUser.setUserEmail(user.getUserEmail());
		}
		 userJpaRepository.save(existingUser);
		return existingUser;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public void deleteUser(int userId) {
		try
		{
		User user= userJpaRepository.findById((long) userId).get();
		if(user!=null)
		{
			userJpaRepository.deleteById((long) userId);
		}
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		
	}
}
