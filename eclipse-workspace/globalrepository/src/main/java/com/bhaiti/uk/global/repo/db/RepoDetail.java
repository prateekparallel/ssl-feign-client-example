package com.bhaiti.uk.global.repo.db;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "repodetail")
public class RepoDetail {

	public RepoDetail(Integer id, String uRL, Character active, Character approve) {
		super();
		this.id = id;
		URL = uRL;
		this.active = active;
		this.approve = approve;
	}

	@Id
	//@SequenceGenerator(name = "userID", sequenceName = "userID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)//, generator = "userID")
	@Column(name = "id")
	private Integer id;	

	//we dont need this field here but this field has been added
	//for PSQL query where we are comparing foreign key
	//PSQL refer to the Entity class but not the actual table
	// here table name is repodetail but in PSQL we will use
	// like - SELECT p from RepoDetail the java class name but not the actual database table
	@Column(name = "site_id", insertable = false, updatable =false)
	private Integer siteId;
	
	String URL;
	
	Character active;
	
	Character approve;
	//if we will not provide cascade=CascadeType.ALL we will get issue
	//
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="site_id")
	private GlobalRepo globalRepo = new GlobalRepo();
	
	public RepoDetail() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public Character getActive() {
		return active;
	}

	public void setActive(Character active) {
		this.active = active;
	}

	public Character getApprove() {
		return approve;
	}

	public void setApprove(Character approve) {
		this.approve = approve;
	}

	public GlobalRepo getGlobalRepo() {
		return globalRepo;
	}

	public void setGlobalRepo(GlobalRepo globalRepo) {
		this.globalRepo = globalRepo;
	}	

}
