package com.bhaiti.uk.global.repo.controller.services;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bhaiti.uk.global.repo.beans.GlobalRepository;
import com.bhaiti.uk.global.repo.beans.GlobalRepositoryUrl;
import com.bhaiti.uk.global.repo.exception.GlobalRepositoryException;
import com.bhaiti.uk.global.repo.service.impl.GlobalRepositoryUpdate;

/***
 * This singleton class provides all the update service through which
 * all update to the database can be done including deleting records from db
 * @author prate
 *
 */

@Service
public class GlobalRepositoryUpdateService {
	
	@Autowired
	GlobalRepositoryUpdate globalRepositoryUpdate;
	
	//private static GlobalRepositoryUpdateService GRUS = null;

	/*private GlobalRepositoryUpdateService() {
		this.globalRepositoryUpdate = new GlobalRepositoryUpdate();
	}*/
	
	/*
	public static GlobalRepositoryUpdateService getInstance() {
		if(GRUS == null) {
			GRUS = new GlobalRepositoryUpdateService();
		}
		return GRUS;
	}*/
	
	public ResponseEntity<?> register(GlobalRepository repo) throws GlobalRepositoryException {
		int id = globalRepositoryUpdate.register(repo);
		if(id != -1) {
			 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			 System.out.println(uri);
		        return ResponseEntity.created(uri).build();
			//return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}

	
	public  ResponseEntity<?> updateRepository(GlobalRepositoryUrl repoUrl) throws GlobalRepositoryException {
		boolean resp = globalRepositoryUpdate.updateRepository(repoUrl);
		if(resp) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.badRequest().build();
	}

	
	public ResponseEntity<?> deleteRepository(GlobalRepositoryUrl repoUrl) throws GlobalRepositoryException {
		boolean resp = globalRepositoryUpdate.deleteRepository(repoUrl);
		if(resp) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}

}
