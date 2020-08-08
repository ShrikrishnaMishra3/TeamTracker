package com.teamTracker.functionaltestcases;

import static com.teamTracker.utilityclasses.TestUtils.businessTestFile;
import static com.teamTracker.utilityclasses.TestUtils.currentTest;
import static com.teamTracker.utilityclasses.TestUtils.yakshaAssert;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.teamTracker.controller.TeamController;
import com.teamTracker.service.TeamServiceImpl;
import com.teamTracker.utilityclasses.MasterData;



@RunWith(SpringRunner.class)
@WebMvcTest(TeamController.class)
public class TestBillContrller {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TeamServiceImpl teamServiceImpl;
	@Test
	public void testaddTeam()throws Exception { 
		
		  when(teamServiceImpl.updateTeam(MasterData.getTeamDetailsDTO()))
		  .thenReturn(MasterData.getTeamDetailsDTO().getId());
		  
		  RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addteam")
		  .content(MasterData.asJsonString(MasterData.getTeamDetailsDTO()))
		  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON);
		  
		  MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		  
		  
		  yakshaAssert(currentTest(), (result.getResponse().getStatus() ==
		  HttpStatus.OK.value() ? "true" : "false"), businessTestFile);
		 
	
	}
		
	}