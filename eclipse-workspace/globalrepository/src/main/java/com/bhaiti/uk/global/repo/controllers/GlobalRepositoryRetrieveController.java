package com.bhaiti.uk.global.repo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bhaiti.uk.global.repo.beans.GlobalRepository;
import com.bhaiti.uk.global.repo.controller.services.GlobalRepositoryRetrieveService;
import com.bhaiti.uk.global.repo.exception.GlobalRepositoryException;

@Controller
public class GlobalRepositoryRetrieveController {

	@Autowired
	//@Qualifier("GlobalRepositoryRetrieveService")
	GlobalRepositoryRetrieveService globalRepositoryRetrieveService;
	
	/*
	public GlobalRepositoryRetrieveController(@Autowired GlobalRepositoryRetrieveService grRetrieveService) {
		//globalRepositoryRetrieveService = GlobalRepositoryRetrieveService.getInstance();
		globalRepositoryRetrieveService = grRetrieveService;
	}*/
	
	@GetMapping(path="/globalrepository", produces = "application/json")
	public ResponseEntity<String> getGreeting() {
		return ResponseEntity.ok().body("Welcome of Global Repository");
	}
	
	@GetMapping("/globalrepository/allforasite")
	public ResponseEntity<GlobalRepository> getAllRepsitoryForASite(@RequestParam(value="siteName",required = false) String siteName) 
			throws GlobalRepositoryException {
		System.out.println("From Server - 2");
		return globalRepositoryRetrieveService.getAllRepsitoryForASite(siteName);	
	}

	
	@GetMapping("/globalrepository/allactiveforasite")
	public ResponseEntity<?> getAllActiveRepsitoryForASite(@RequestParam(value="siteName",required = false) String siteName)
			throws GlobalRepositoryException {
		System.out.println("From Server - 2");
		return globalRepositoryRetrieveService.getAllActiveRepsitoryForASite(siteName);
	}

	@GetMapping("/globalrepository/allactive")
	public ResponseEntity<?> getAllActiveRepsitory(@RequestParam(value="siteName",required = false) String siteName) throws GlobalRepositoryException {

		return globalRepositoryRetrieveService.getAllActiveRepsitory(siteName);
	}

	@GetMapping("/globalrepository/repositorydetail")
	public ResponseEntity<?> getGlobalRepositoryDetail(@RequestParam(value="url",required = false) String url)
			throws GlobalRepositoryException {

		return globalRepositoryRetrieveService.getGlobalRepositoryDetail(url);
	}
	
} 