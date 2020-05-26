package com.jpa.connection.manager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnectionManager {
	/*
	private static EntityManagerFactory ENTITY_MGR_FACTORY = 
			Persistence.createEntityManagerFactory(String persistenceUnitName, Map properties) */
	
	private static EntityManagerFactory ENTITY_MGR_FACTORY_GR = 
			Persistence.createEntityManagerFactory("GLOBAL-REPO");
	
	public String getGlobalRepoDBConnection() {
		return null;
	}
	
	public static EntityManagerFactory getEntityManagerFactorForGlobalRepo() {
		return ENTITY_MGR_FACTORY_GR;
	}
}