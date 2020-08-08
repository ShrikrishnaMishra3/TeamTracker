
package com.teamTracker.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity

@Table(name = "Team_Details")
public class teamDetails {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String TeamName;
	private String Manager;
	private String Domain;
	@Override
	public String toString() {
		return "teamDetails [id=" + id + ", TeamName=" + TeamName + ", Manager=" + Manager + ", Domain=" + Domain + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTeamName() {
		return TeamName;
	}
	public void setTeamName(String teamName) {
		TeamName = teamName;
	}
	public String getManager() {
		return Manager;
	}
	public void setManager(String manager) {
		Manager = manager;
	}
	public String getDomain() {
		return Domain;
	}
	public void setDomain(String domain) {
		Domain = domain;
	}

	}