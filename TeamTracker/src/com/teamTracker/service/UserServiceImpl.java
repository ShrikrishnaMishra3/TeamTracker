package com.teamTracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamTracker.dao.UserDao;
import com.teamTracker.dtos.TeamDetailsDTO;
import com.teamTracker.dtos.UsersDetailsDTO;
import com.teamTracker.entitys.UserDetails;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao usrDao;
		
	@Override
	public List<UsersDetailsDTO> getAllUserInfo() {
   
		List<UsersDetailsDTO> users = new ArrayList<UsersDetailsDTO>();
		
		usrDao.getAllUserInfo().forEach(user -> {
			UsersDetailsDTO userDTO = new UsersDetailsDTO();
			userDTO.setUserName(user.getUserName());
		
			users.add(userDTO);
		});
			return users; 
			
	}

	@Override
	public UsersDetailsDTO insertUser(UsersDetailsDTO user) {
		UserDetails users =new UserDetails();
		 
		users.setUserName(user.getUserName());

		usrDao.insertUser(users);
         return user;
		
	}

	@Override
	public UsersDetailsDTO deleteUser(UsersDetailsDTO user) {
		UserDetails users =new UserDetails();
		 
		users.setUserName(user.getUserName());

		usrDao.deleteUser(users);
         return user;
		 
	}

	@Override
	public UsersDetailsDTO updateUser(UsersDetailsDTO user) {
		UserDetails users =new UserDetails();
		 
		users.setUserName(user.getUserName());

		usrDao.updateUser(user);
         return user;
	}

	/*
	 * @Override public usersDetailsDTO getUserById(usersDetailsDTO user) { // TODO
	 * Auto-generated method stub return null; }
	 */
	

}