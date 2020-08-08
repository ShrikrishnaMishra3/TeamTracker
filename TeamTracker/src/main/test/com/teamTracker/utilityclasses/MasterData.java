package com.teamTracker.utilityclasses;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamTracker.dtos.TeamDetailsDTO;


public class MasterData {

	public static TeamDetailsDTO getusersDetailsDTO() {

		TeamDetailsDTO details = new TeamDetailsDTO();
		/* details.setId(1l); */
		details.setTeamName("java");
		details.setManager("Krishna");
		details.setDomain("Developer");
	
		return details;
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
