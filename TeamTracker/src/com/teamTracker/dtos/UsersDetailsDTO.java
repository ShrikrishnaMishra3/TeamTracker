package com.teamTracker.dtos;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

	import lombok.Data;
	@Data
	public class UsersDetailsDTO {
		
		private Long Id;

		@Length(min = 5, max = 30)
		@NotNull
		private String UserName;
		
		@Length(min = 5, max = 30)
		@NotNull
		private String EmailId;
		
		@Length(min = 5, max = 30)
		@NotNull
		private String UserType;
		
		@Length(min = 5, max = 30)
		@NotNull
		private String Status;
		
		private String InterviewStatus;
		
		private String MobileNo;
		
		
		
	}
	


