package com.bhaiti.uk.global.repo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bhaiti.uk.global.repo.beans.GlobalRepository;
import com.bhaiti.uk.global.repo.beans.GlobalRepositoryUrl;
import com.bhaiti.uk.global.repo.controller.services.GlobalRepositoryUpdateService;
import com.bhaiti.uk.global.repo.exception.GlobalRepositoryException;

@Controller
public class GlobalRepositoryUpdateController {

	GlobalRepositoryUpdateService updateService;

	public GlobalRepositoryUpdateController(@Autowired GlobalRepositoryUpdateService updateService1) {
		updateService = updateService1;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/globalrepository/register" /*, consumes = "application/json", produces = "application/json"*/)
	@ResponseBody
	public ResponseEntity<?> register(@RequestBody GlobalRepository repo) throws GlobalRepositoryException {

		return updateService.register(repo);
	}

	@PutMapping(path="/globalrepository/update",consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateRepository(GlobalRepositoryUrl repoUrl) throws GlobalRepositoryException {

		return updateService.updateRepository(repoUrl);
	}

	@DeleteMapping(path="/globalrepository/remove",consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> deleteRepository(GlobalRepositoryUrl repoUrl) throws GlobalRepositoryException {

		return updateService.deleteRepository(repoUrl);
	}

}
