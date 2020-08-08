package com.teamTracker.dao;

import java.util.List;

import com.teamTracker.entitys.UserDetails;



public interface UserDao {
	
public List<UserDetails> getAllUserInfo();
	
	public void insertUser(UserDetails users);
	public void deleteUser(UserDetails user);
	public UserDetails getUserById(Long id);
	public List<UserDetails> getAllUseres();
	public void updateUser(UserDetails user);
	
		
}
