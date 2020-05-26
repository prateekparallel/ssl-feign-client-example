package com.jpa.transaction.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jpa.connection.manager.DBConnectionManager;
import com.jpa.entity.beans.example.onetomany.GlobalRepo;
import com.jpa.entity.beans.example.onetomany.RepoDetail;
import com.jpa.entity.beans.example1.RepoDetails;

public class GRTranUtil {
	
	public static boolean addRepoDetail(String url, char active, char approve) {
		
		boolean status = true;
		
		EntityManager em = DBConnectionManager.getEntityManagerFactorForGlobalRepo()
								.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			RepoDetails rd = new RepoDetails();
			rd.setURL(url);
			rd.setActive(active);
			rd.setApprove(approve);
			rd.setSiteId(1);
			em.persist(rd);
			et.commit();
		}catch(Exception e) {
			
			if(et != null) {
				et.rollback();
			}
			
			e.printStackTrace();
			
			status = false;
			
		}finally {
			em.close();
			DBConnectionManager.getEntityManagerFactorForGlobalRepo().close();
		}
			
		return status;
	}
	
	public static boolean addGlobalRepo(String siteName, String url, char active, char approve) {
		
		boolean status = true;
		
		EntityManager em = DBConnectionManager.getEntityManagerFactorForGlobalRepo()
								.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			GlobalRepo gr = new GlobalRepo();
			gr.setSiteName(siteName);
			RepoDetail rd = new RepoDetail();
			rd.setURL(url);
			rd.setActive(active);
			rd.setApprove(approve);
			List<RepoDetail> rdList = new ArrayList<RepoDetail>();
			gr.setRepoDetail(rdList);
			rd.setGlobalRepo(gr);
			//gr.setSite_id(10);
			em.merge(rd); //to update(if primary key set) existing and save new in muster and insert a new to child
			//em.persist(rd); // insert a new records to muster table and to child
			et.commit();
		}catch(Exception e) {
			
			if(et != null) {
				et.rollback();
			}
			
			e.printStackTrace();
			
			status = false;
			
		}finally {
			em.close();
			DBConnectionManager.getEntityManagerFactorForGlobalRepo().close();
		}
			
		return status;
	}

}
