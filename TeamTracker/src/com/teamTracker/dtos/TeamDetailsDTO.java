package com.teamTracker.dtos;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class TeamDetailsDTO {
	
	private Long Id;

	@Length(min = 5, max = 30)
	@NotNull
	private String TeamName;

	@Length(min = 3, max = 25)
	@NotNull
	private String Manager;
	
	@Length(min = 3, max = 25)
	@NotNull
	private String Domain;
	private List <String> teamMembers;
	
	
	
}

