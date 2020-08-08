package com.teamTracker.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamTracker.dtos.TeamDetailsDTO;
import com.teamTracker.entitys.TeamDetails;


@Repository
public class TeamDaoImpl implements TeamDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TeamDetails> getAllTeamInfo() {
		return sessionFactory.getCurrentSession().createQuery("from Teaminfo").getResultList();
	}

	@Override
	public void insertteam(TeamDetails team) {
		Serializable serializable = sessionFactory.getCurrentSession().save(team);

	}

	@Override
	public void deleteteam(TeamDetails team) {
		TeamDetails team1 = (TeamDetails) sessionFactory.getCurrentSession().load(TeamDetails.class, sessionFactory);
		if (null != team) {
			this.sessionFactory.getCurrentSession().delete(team);
		}
		return;
	}

	@Override
	public TeamDetails getTeamById(Long id) {
		TeamDetails team = sessionFactory.getCurrentSession().load(TeamDetails.class, id);
		System.out.println(team);
		return team;

	}

	/*
	 * @Override public List<teamDetails> getAllTeamInfo() { return
	 * sessionFactory.getCurrentSession().createQuery("from TeamInfo").getResultList
	 * (); }
	 */

	@Override
	public void updateteam(TeamDetails team) {
		sessionFactory.getCurrentSession().update(team);

	}

}
