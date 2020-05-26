package com.bhaiti.uk.global.repo.service;

import java.util.List;
import java.util.Optional;

import com.bhaiti.uk.global.repo.beans.GlobalRepository;
import com.bhaiti.uk.global.repo.beans.GlobalRepositoryDetail;
import com.bhaiti.uk.global.repo.exception.GlobalRepositoryException;

public interface GlobalRepositoryService {
	
	public Optional<GlobalRepository> getAllRepsitoryForASite(String siteName) 
			throws GlobalRepositoryException;
	public Optional<GlobalRepository> getAllActiveRepsitoryForASite(String siteName) 
			throws GlobalRepositoryException;
	public Optional<List<GlobalRepository>> getAllActiveRepsitory(String siteName)
			throws GlobalRepositoryException;
	public Optional<List<GlobalRepositoryDetail>> getGlobalRepositoryDetail(String url)
			throws GlobalRepositoryException;

}
