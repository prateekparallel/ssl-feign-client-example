package com.bhaiti.uk.global.repo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhaiti.uk.global.repo.beans.GlobalRepository;
import com.bhaiti.uk.global.repo.beans.GlobalRepositoryUrl;
import com.bhaiti.uk.global.repo.db.GlobalRepo;
import com.bhaiti.uk.global.repo.db.GlobalRepositoryDBService;
import com.bhaiti.uk.global.repo.db.RepoDetail;
import com.bhaiti.uk.global.repo.exception.GlobalRepositoryException;
import com.bhaiti.uk.global.repo.service.GlobalRepositoryUpdateService;


@Service
public class GlobalRepositoryUpdate implements GlobalRepositoryUpdateService {
	
	@Autowired
	GlobalRepositoryDBService globalRepositoryServ;

	@Override
	public int register(GlobalRepository repo) throws GlobalRepositoryException {
		// TODO Auto-generated method stub
		GlobalRepo repoEntiry = new GlobalRepo();
		RepoDetail repodetail = new RepoDetail();
		if(repo.getUrls().get(0).isActive()) {
			repodetail.setActive('Y');
		}
		else {
			repodetail.setActive('N');
		}
		if(repo.getUrls().get(0).isApproved()) {
			repodetail.setApprove('Y');
		}
		else {
			repodetail.setApprove('N');
		}
		repodetail.setURL(repo.getUrls().get(0).getUrl());
		//repodetail.setId(1);
		int siteId = globalRepositoryServ.getSiteId(repo.getSiteName());
		
		if(siteId > 0) {
			repoEntiry.setSite_id(siteId);
		}
		
		repoEntiry.setSiteName(repo.getSiteName());
		repodetail.setGlobalRepo(repoEntiry);
		List<RepoDetail> repoList = new ArrayList<RepoDetail>();
		repoList.add(repodetail);
		repoEntiry.setRepoDetail(repoList);
		int id = -1;
		try {
			GlobalRepo gr = globalRepositoryServ.save(repoEntiry);
			id = gr.getSite_id();
		}
		catch(Exception e) {
			throw new GlobalRepositoryException(e.getMessage());
		}
		return id;
	}

	@Override
	public boolean updateRepository(GlobalRepositoryUrl repoUrl) throws GlobalRepositoryException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRepository(GlobalRepositoryUrl repoUrl) throws GlobalRepositoryException {
		// TODO Auto-generated method stub
		return false;
	}

}
