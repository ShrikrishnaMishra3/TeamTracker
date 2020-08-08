package com.teamTracker.dao;

import java.util.List;


import com.teamTracker.entitys.TeamDetails;


public interface TeamDao {
	

	
	public void insertteam(TeamDetails teames);
	public void deleteteam(TeamDetails teames);
	public TeamDetails getTeamById(Long id);
	public void updateteam(TeamDetails team);
	public List<TeamDetails> getAllTeamInfo();
	//public void insertteam(teamDetails teames);
	
	/*
	 * public boolean insertteam(teamDetails team); public boolean
	 * deleteteam(Long id); public teamDetails getTeamById(Long id); public Long
	 * updateteam(teamDetails team); public List<teamDetails>
	 * public List<teamDetails> getAllTeamInfo();
	 */
		
}
