
package com.teamTracker.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity

@Table(name = "newbill")
public class userDetails {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String UserName;
	private String EmailId;
	private String UserType;
	@Override
	public String toString() {
		return "userDetails [id=" + id + ", UserName=" + UserName + ", EmailId=" + EmailId + ", UserType=" + UserType
				+ ", Status=" + Status + ", InterviewStatus=" + InterviewStatus + ", MobileNo=" + MobileNo + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getUserType() {
		return UserType;
	}
	public void setUserType(String userType) {
		UserType = userType;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getInterviewStatus() {
		return InterviewStatus;
	}
	public void setInterviewStatus(String interviewStatus) {
		InterviewStatus = interviewStatus;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	private String Status;
	private String InterviewStatus;
	private String MobileNo;
	}
