
package com.teamTracker.exceptiontestcases;

import static com.teamTracker.utilityclasses.TestUtils.currentTest;
import static com.teamTracker.utilityclasses.TestUtils.exceptionTestFile;
import static com.teamTracker.utilityclasses.TestUtils.yakshaAssert;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
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
import com.teamTracker.dtos.TeamDetailsDTO;
import com.teamTracker.service.TeamServiceImpl;
import com.teamTracker.utilityclasses.MasterData;

@ExtendWith(MockitoExtension.class)

@RunWith(SpringRunner.class)

@MockitoSettings(strictness = Strictness.LENIENT)

@WebMvcTest(TeamController.class)
class ExceptionTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TeamServiceImpl teamServiceImpl;

	@Test
	void testupdateTeamException() throws Exception {
		TeamDetailsDTO teamDetailsDTO = MasterData.getTeamDetailsDTO();
	     teamDetailsDTO.setTeamName("java");
		teamDetailsDTO.setManager("Ram");
		when(teamServiceImpl.updateTeam(MasterData.getTeamDetailsDTO()))
				.thenReturn(MasterData.getTeamDetailsDTO().getId());

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addteam")
				.content(MasterData.asJsonString(MasterData.getTeamDetailsDTO()))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);



}
