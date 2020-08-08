package com.teamTracker.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teamTracker.dtos.TeamDetailsDTO;
import com.teamTracker.model.teamDetails;
import com.teamTracker.service.TeamService;


@Controller
public class TeamController {

	@Autowired
	private TeamService Service;

	@RequestMapping(value = "/")
	public ModelAndView showHomePage(HttpServletResponse response) throws IOException {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/addTeam")
	public ModelAndView addTeam(HttpServletResponse response) throws IOException {
		return new ModelAndView("addTeam");
	}

	@RequestMapping(value = "/deleteteam")
	public ModelAndView deleteTeam(HttpServletRequest request) throws IOException {
		Long teamid = Long.parseLong(request.getParameter("id"));
		List<TeamDetailsDTO> teamInfo = Service.getAllTeamInfo();
		return new ModelAndView("tracker", "TeamInfo", teamInfo);

	}

	@RequestMapping(value = "/editteam")
	public ModelAndView editBill(HttpServletRequest request) throws IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		System.out.println((request.getParameter("id")));
		TeamDetailsDTO team = Service.getTeamById(id);
		return new ModelAndView("update", "team", team);
	}

	@RequestMapping(value = "/trackerTeam")
	public ModelAndView Tracker(HttpServletResponse response) throws IOException {
		List<TeamDetailsDTO> teamInfo = Service.getAllTeamInfo();
		return new ModelAndView("trackerTeam", "TeamInfo", teamInfo);
	}

	@RequestMapping(value = "/viewlAll")
	public ModelAndView viewlAll(HttpServletResponse response) throws IOException {
		List<TeamDetailsDTO> teams = Service.getAllTeamInfo();
		return new ModelAndView("viewall", "TeamInfo", teams);

	}

	@RequestMapping(value = "/updateteam", method = RequestMethod.POST)
	public ModelAndView updateTeam(@ModelAttribute("team") TeamDetailsDTO team) {
		Service.updateteam(team);
		return new ModelAndView("redirect:/tracker");
	}

	@RequestMapping(value = "/addteam")
	public ModelAndView addNewTeam(HttpServletRequest request) throws Exception {
	    
		String TeamName= request.getParameter("TeamName");
		String Manager = request.getParameter("Manager");
		String Domain= request.getParameter("Domain");
	
		
		TeamDetailsDTO teamDetails = new TeamDetailsDTO();
		teamDetails.setTeamName(TeamName);
		teamDetails.setManager(Manager);
		teamDetails.setDomain(Domain);
		Service.insertteam(teamDetails);
		
		return new ModelAndView("redirect:/tracker");
	}

}
