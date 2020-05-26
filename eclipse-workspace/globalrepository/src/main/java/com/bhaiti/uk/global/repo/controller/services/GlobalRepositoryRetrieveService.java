package com.bhaiti.uk.global.repo.controller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bhaiti.uk.global.repo.beans.GlobalRepository;
import com.bhaiti.uk.global.repo.exception.GlobalRepositoryException;
import com.bhaiti.uk.global.repo.service.impl.GlobalRepositoryRetrieve;

@Service("GlobalRepositoryRetrieveService")
public class GlobalRepositoryRetrieveService {
	
	@Autowired
	private GlobalRepositoryRetrieve globalRepositoryRetrieve;
	//private static GlobalRepositoryRetrieveService grrs = null;

	/*
	public GlobalRepositoryRetrieveService() {
		globalRepositoryRetrieve = new GlobalRepositoryRetrieve();
	}*/
	
	/*
	public static GlobalRepositoryRetrieveService getInstance() {
		if(grrs == null) {
			grrs = new GlobalRepositoryRetrieveService();
		}
		return grrs;
	}*/
	
	
	public ResponseEntity<GlobalRepository> getAllRepsitoryForASite(String siteName) 
			throws GlobalRepositoryException {
		
		return globalRepositoryRetrieve.getAllRepsitoryForASite(siteName)
		.map(repos -> ResponseEntity.ok().body(repos))
		.orElseGet(() -> ResponseEntity.notFound().build());		
	}

	
	public ResponseEntity<?> getAllActiveRepsitoryForASite(String siteName)
			throws GlobalRepositoryException {
		
		return globalRepositoryRetrieve.getAllActiveRepsitoryForASite(siteName)
				.map(repos -> ResponseEntity.ok().body(repos))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	
	public ResponseEntity<?> getAllActiveRepsitory(String siteName) throws GlobalRepositoryException {

		return globalRepositoryRetrieve.getAllActiveRepsitory(siteName)
				.map(repos -> ResponseEntity.ok().body(repos))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	
	public ResponseEntity<?> getGlobalRepositoryDetail(String url)
			throws GlobalRepositoryException {

		return globalRepositoryRetrieve.getGlobalRepositoryDetail(url)
				.map(urls -> ResponseEntity.ok().body(urls))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

}
