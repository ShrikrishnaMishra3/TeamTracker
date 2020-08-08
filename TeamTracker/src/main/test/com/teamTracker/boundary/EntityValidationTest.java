package com.teamTracker.boundary;

import static com.teamTracker.utilityclasses.TestUtils.boundaryTestFile;
import static com.teamTracker.utilityclasses.TestUtils.currentTest;
import static com.teamTracker.utilityclasses.TestUtils.yakshaAssert;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.teamTracker.controller.TeamController;
import com.teamTracker.dtos.UsersDetailsDTO;
import com.teamTracker.service.TeamServiceImpl;
import com.teamTracker.utilityclasses.MasterData;

@RunWith(SpringRunner.class)

@WebMvcTest(TeamController.class)
class EntityValidationTest {

	@MockBean
	private TeamServiceImpl teamServiceImpl;

	private Validator validator;

	@BeforeEach
	void setUp() throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	void testTitle() throws Exception {
		UsersDetailsDTO usersDetailsDTO = MasterData.getusersDetailsDTO();
		usersDetailsDTO.setUserName("krishna");
		Set<ConstraintViolation<UsersDetailsDTO>> violations = validator.validate(usersDetailsDTO);
		yakshaAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);

	}
}
