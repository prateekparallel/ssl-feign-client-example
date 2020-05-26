package com.bhaiti.uk.global.repo.db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "globalrepo")
public class GlobalRepo {

	@Id
	//error I faced - if I use GenerationType.AUTO missing sequence id site_id
	// to temporary fix it make it to IDENTITY
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "site_id_generator")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@SequenceGenerator(name = "site_id_generator", sequenceName = "site_id_seq", allocationSize=50)
	//@Column(name = "site_id", updatable = false, nullable = false)
	private Integer site_id;
	
	@Column(name = "site_name")
	private String siteName;

	
	//@OneToMany(mappedBy= "globalRepo", cascade = CascadeType.ALL)//, orphanRemoval = true)
	@OneToMany(mappedBy = "globalRepo",fetch=FetchType.LAZY,cascade=CascadeType.ALL, targetEntity = RepoDetail.class)
	private List<RepoDetail> repoDetail = new ArrayList<RepoDetail>();


	public GlobalRepo() {}


	public Integer getSite_id() {
		return site_id;
	}


	public void setSite_id(Integer site_id) {
		this.site_id = site_id;
	}


	public String getSiteName() {
		return siteName;
	}


	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}


	public List<RepoDetail> getRepoDetail() {
		return repoDetail;
	}


	public void setRepoDetail(List<RepoDetail> repoDetail) {
		this.repoDetail = repoDetail;
	}
	

	
}
