package com.teamTracker.entitys;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;



@Entity
@Table(name = "User")
@Data
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="User_ID")
	private Long id;
	@Column(name="User_Name")
	private String UserName;
	@Column(name="Email_ID")
	private String EmailId;
	@Column(name="User_Type")
	private String UserType;
	private String Status;
	private String InterviewStatus;
	private String MobileNo;
	

}
