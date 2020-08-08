package com.teamTracker.service;

import java.util.List;

import com.teamTracker.dtos.TeamDetailsDTO;
import com.teamTracker.model.teamDetails;

public interface TeamService {
	
	/*
	 * public List<teamDetails> getAllTeamInfo();
	 * 
	 * public boolean insertteam(teamDetails team);
	 * 
	 * public boolean deleteteam(Long id);
	 * 
	 * public teamDetails getTeamById(Long id);
	 * 
	 * public Long updateteam(teamDetails team);
	 */

	public List<TeamDetailsDTO> getAllTeamInfo();
	 
	  public TeamDetailsDTO insertteam(TeamDetailsDTO team);
	 // public teamDetailsDTO getTeamById(Long id); 
	  public TeamDetailsDTO updateteam(TeamDetailsDTO team);
	  public TeamDetailsDTO deleteteam(TeamDetailsDTO teamDetails);
	

}
