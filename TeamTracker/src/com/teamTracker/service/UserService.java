package com.teamTracker.service;

import java.util.List;

import com.teamTracker.dtos.UsersDetailsDTO;
import com.teamTracker.model.userDetails;

public interface UserService {
	
	public List<UsersDetailsDTO> getAllUserInfo();
	
	public UsersDetailsDTO insertUser(UsersDetailsDTO user);
		
	public UsersDetailsDTO deleteUser(UsersDetailsDTO user);

	//public usersDetailsDTO getUserById(usersDetailsDTO user);
	
	public UsersDetailsDTO updateUser(UsersDetailsDTO user);
	
	

}
