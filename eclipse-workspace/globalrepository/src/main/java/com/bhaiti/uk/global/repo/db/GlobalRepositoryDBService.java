package com.bhaiti.uk.global.repo.db;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bhaiti.uk.global.repo.beans.GlobalRepositoryUrl;

import org.springframework.data.jpa.repository.Query;

@RepositoryRestResource
public interface GlobalRepositoryDBService extends CrudRepository<GlobalRepo, Integer>{

	//native query example - this sql query will be executed directly on the database
	@Query(value = "SELECT p.site_id FROM globalrepo p WHERE p.site_name = :sitename", nativeQuery = true)
    Integer getSiteId(@Param("sitename") String sitename);
	
	
	//All retrieve service
	//@Query(value = "SELECT p FROM repodetail p WHERE p.site_id = "
	//		+ "(select g.site_id from globalrepo g where g.site_name = :sitename)", nativeQuery = true)
	@Query("SELECT new com.bhaiti.uk.global.repo.beans.GlobalRepositoryUrl(p.URL, p.active, p.approve) "
			+ "FROM RepoDetail p WHERE p.siteId = (select g.site_id from GlobalRepo g where g.siteName = :sitename)")
	List<GlobalRepositoryUrl> getAllRepsitoryForASite(@Param("sitename") String sitename);
	
	
	@Query("SELECT p FROM RepoDetail p WHERE p.active = 'Y' and p.siteId = "
			+ "(select g.site_id from GlobalRepo g where g.siteName = :sitename)")
	List<RepoDetail> getAllActiveRepsitoryForASite(@Param("sitename") String sitename);
}
