package com.bhaiti.uk.global.repo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhaiti.uk.global.repo.beans.GlobalRepository;
import com.bhaiti.uk.global.repo.beans.GlobalRepositoryDetail;
import com.bhaiti.uk.global.repo.beans.GlobalRepositoryUrl;
import com.bhaiti.uk.global.repo.db.GlobalRepositoryDBService;
import com.bhaiti.uk.global.repo.db.RepoDetail;
import com.bhaiti.uk.global.repo.exception.GlobalRepositoryException;
import com.bhaiti.uk.global.repo.service.GlobalRepositoryService;

@Service
public class GlobalRepositoryRetrieve implements GlobalRepositoryService {
	
	@Autowired
	GlobalRepositoryDBService globalRepositoryServ;

	@Override
	public Optional<GlobalRepository> getAllRepsitoryForASite(String siteName) throws GlobalRepositoryException {
		
		 List<GlobalRepositoryUrl> repoDetailList = globalRepositoryServ.getAllRepsitoryForASite(siteName);
		 GlobalRepository gr = new GlobalRepository();
		 gr.setSiteName(siteName);
		 gr.setUrls(repoDetailList);
		 return Optional.ofNullable(gr);
	}

	@Override
	public Optional<GlobalRepository> getAllActiveRepsitoryForASite(String siteName)
			throws GlobalRepositoryException {
		
		List<RepoDetail> repoList = globalRepositoryServ.getAllActiveRepsitoryForASite(siteName);
		
		GlobalRepository gr = new GlobalRepository();
		gr.setSiteName(siteName);
		
		List<GlobalRepositoryUrl> repoDetailList = new ArrayList<GlobalRepositoryUrl>();
		
		for(RepoDetail rd : repoList) {
			
			GlobalRepositoryUrl grUrl = new GlobalRepositoryUrl(rd.getURL(), rd.getActive(),rd.getApprove());
			repoDetailList.add(grUrl);
		}
		
		//repoDetailList.forEach(rd -> );
		
		gr.setUrls(repoDetailList);
		
		return Optional.ofNullable(gr);
	}

	@Override
	public Optional<List<GlobalRepository>> getAllActiveRepsitory(String siteName) throws GlobalRepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<GlobalRepositoryDetail>> getGlobalRepositoryDetail(String url)
			throws GlobalRepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

}
