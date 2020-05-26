package com.bhaiti.uk.global.repo.service;

import com.bhaiti.uk.global.repo.beans.GlobalRepository;
import com.bhaiti.uk.global.repo.beans.GlobalRepositoryUrl;
import com.bhaiti.uk.global.repo.exception.GlobalRepositoryException;
//import org.springframework.http.HttpStatus;

public interface GlobalRepositoryUpdateService {
	public int register(GlobalRepository repo) throws GlobalRepositoryException;
	public boolean updateRepository(GlobalRepositoryUrl repoUrl) throws GlobalRepositoryException;
	public boolean deleteRepository(GlobalRepositoryUrl repoUrl) throws GlobalRepositoryException;
}
