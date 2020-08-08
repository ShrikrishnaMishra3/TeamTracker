package com.teamTracker.entitys;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Table(name = "Team")
@Data
public class TeamDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Team_ID")
	private Long id;
	@Column(name="Team_Name")
	private String TeamName;
	@Column(name="Manager")
	private String Manager;
	private String Domain;
	
	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="User_Name")
	 * 
	 * @OrderColumn(name="Team_ID")
	 */ 
// private List <String> teamMembers;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable( name="User_Name",
                joinColumns=@JoinColumn(name="Team_ID"),
                inverseJoinColumns=@JoinColumn(name="User_Id")) 
	private List <String> teamMembers;
//private Collection<String> teamMembers = new ArrayList<String>();



}
