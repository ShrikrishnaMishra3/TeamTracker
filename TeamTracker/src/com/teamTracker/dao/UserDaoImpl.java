package com.teamTracker.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamTracker.entitys.UserDetails;



@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserDetails> getAllUseres() {
		return sessionFactory.getCurrentSession().createQuery("from Useres").getResultList();
	}

	@Override
	public void insertUser(UserDetails user) {
		Serializable serializable = sessionFactory.getCurrentSession().save(user);
		if(serializable!=null)
			return;
		else
			return;
		
	}

	@Override
	public void deleteUser(UserDetails user) {
		UserDetails user1 = (UserDetails) sessionFactory.getCurrentSession().load(UserDetails.class, sessionFactory);
		if (null != user1) {
			this.sessionFactory.getCurrentSession().delete(user1);
		   }
				return;
			}

	@Override
	public UserDetails getUserById(Long id) {
		UserDetails user=  sessionFactory.getCurrentSession().load(UserDetails.class, id);
		System.out.println(user);
		return user;

	}

	@Override
	public List<UserDetails> getAllUserInfo() {
		return sessionFactory.getCurrentSession().createQuery("from Useres").getResultList();
	}

	@Override
	public void updateUser(UserDetails user) {
			sessionFactory.getCurrentSession().update(user);
			
	}

}
