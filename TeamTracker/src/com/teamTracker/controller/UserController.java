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

import com.teamTracker.dtos.UsersDetailsDTO;
import com.teamTracker.model.userDetails;
import com.teamTracker.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService uService;

	@RequestMapping(value = "/")
	public ModelAndView showHomePage(HttpServletResponse response) throws IOException {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/addUser")
	public ModelAndView addUser(HttpServletResponse response) throws IOException {
		return new ModelAndView("addUser");
	}

	@RequestMapping(value = "/deleteUser")
	public ModelAndView deleteUser(HttpServletRequest request) throws IOException {
		long userid = Long.parseLong(request.getParameter("id"));
		uService.deleteUser(userid);
		List<UsersDetailsDTO> userd = uService.getAllUserInfo();
		return new ModelAndView("tracker", "useres", userd);

	}

	@RequestMapping(value = "/editUser")
	public ModelAndView editUser(HttpServletRequest request) throws IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		UsersDetailsDTO userd = uService.getUserById(id);
		return new ModelAndView("update", "user", userd);
	}

	@RequestMapping(value = "/trackerUser")
	public ModelAndView Tracker(HttpServletResponse response) throws IOException {
		List<UsersDetailsDTO> userd = uService.getAllUserInfo();
		return new ModelAndView("trackerUser", "useres", userd);
	}

	@RequestMapping(value = "/viewlAll")
	public ModelAndView viewlAll(HttpServletResponse response) throws IOException {
		List<UsersDetailsDTO> userd = uService.getAllUserInfo();
		return new ModelAndView("viewall", "Useres", userd);

	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("userd") UsersDetailsDTO userd) {
		uService.updateUser(userd);
		return new ModelAndView("redirect:/tracker");
	}

	@RequestMapping(value = "/addUsers")
	public ModelAndView addNewUser(HttpServletRequest request) throws Exception {
		System.out.println("sidj");
		String UserName= request.getParameter("userName");
		String EmailId = request.getParameter("emailId");
		String UserType= request.getParameter("userType");
		String Status = request.getParameter("status");
		String InterviewStatus= request.getParameter("InterviewStatus");
		String MobileNo = request.getParameter("MobileNo");
		
		UsersDetailsDTO userd = new UsersDetailsDTO();
		userd.setUserName(UserName);
		userd.setEmailId(EmailId);
		userd.setUserType(UserType);
		userd.setStatus(Status);
		userd.setInterviewStatus(InterviewStatus);
		userd.setMobileNo(MobileNo);
		uService.insertUser(userd);

		return new ModelAndView("redirect:/tracker");
	}

}
