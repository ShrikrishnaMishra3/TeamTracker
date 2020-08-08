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

import com.teamTracker.dao.TeamDao;
import com.teamTracker.dtos.TeamDetailsDTO;
import com.teamTracker.entitys.TeamDetails;




@Service
@Transactional
public class TeamServiceImpl implements TeamService{
	
	@Autowired
	private TeamDao tDao;
		
	@Override
	public List<TeamDetailsDTO> getAllTeamInfo() {
		//return tDao.getAllTeamInfo();
		
		List<TeamDetailsDTO> teames = new ArrayList<TeamDetailsDTO>();
		
		tDao.getAllTeamInfo().forEach(team -> {
			TeamDetailsDTO teamDTO = new TeamDetailsDTO();
			teamDTO.setTeamName(team.getTeamName());
			teamDTO.setManager(team.getManager());
			teamDTO.setDomain(team.getDomain());
			teamDTO.setTeamMembers(team.getTeamMembers());
			teames.add(teamDTO);
		});
			return teames; 
			
	}

	@Override
	public TeamDetailsDTO insertteam(TeamDetailsDTO team) {
		TeamDetails teames =new TeamDetails();
		teames.setTeamName(team.getTeamName());
		//teames.setTeamName(team.getTeamName());
		teames.setManager(team.getManager());
		teames.setDomain(team.getDomain());
		tDao.insertteam(teames);
         return team;
		
	}

	@Override
	public TeamDetailsDTO deleteteam(TeamDetailsDTO team) {
		
		TeamDetails teames =new TeamDetails();
		 
		teames.setTeamName(team.getTeamName());
		teames.setManager(team.getManager());
		teames.setDomain(team.getDomain());
		tDao.deleteteam(teames);
         return team;
	
		
	}

	/*
	 * @Override public teamDetailsDTO getTeamById(Long id) { teamDetails teames
	 * =new teamDetails(); teames.setTeamName(id.get(teamDetails.class)
	 * teames.setManager(team.getManager()); teames.setDomain(team.getDomain());
	 * tDao.updateteam(teames); return team;
	 * 
	 * return tDao.getTeamById(id); }
	 */

	@Override
	public TeamDetailsDTO updateteam(TeamDetailsDTO team) {
		TeamDetails teames =new TeamDetails();
		 
		teames.setTeamName(team.getTeamName());
		teames.setManager(team.getManager());
		teames.setDomain(team.getDomain());
		tDao.updateteam(teames);
         return team;
	}
	
 
	
	

}
