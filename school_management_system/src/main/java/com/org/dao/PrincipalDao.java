package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.org.dto.Principal;
import com.org.dto.School;
import com.org.utilities.Helper;

public class PrincipalDao {
		//save principal 
		public void saveAndUpdatePrincipal(Principal principal) {
			EntityManagerFactory emf = Helper.getEMFactory();
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			School school = principal.getSchool();
			
			et.begin();
			em.merge(school);
			et.commit();
			
		}
		
		//fetch principal by email and password
		
		public List<Principal> fetchPrincipalByEmailPassword(String email, String password){
			EntityManagerFactory emf = Helper.getEMFactory();
			EntityManager em = emf.createEntityManager();
			
			String jpql = "select p from Principal p where p.email=?1 and p.password=?2";
			
			Query query = em.createQuery(jpql);
			query.setParameter(1, email);
			query.setParameter(2, password);
			
			List<Principal> principal = query.getResultList();
			
			return principal;
		}
		
		
		//fetch all principal
		public List<Principal> fetchAllPrincipal(){
			
			EntityManagerFactory emf = Helper.getEMFactory();
			
			EntityManager em = emf.createEntityManager();
			
			String jpql = "select p from Principal p";
			
			Query query = em.createQuery(jpql);
			
			List<Principal> principal = query.getResultList();
			
			return principal;
		}
		
		//fetch principal by id
		
		public Principal fetchPrincipalById(int id) {
			EntityManagerFactory emf = Helper.getEMFactory();
			
			EntityManager em = emf.createEntityManager();
			
			return em.find(Principal.class, id);
		}
		
		//verify email
		
		public List<Principal> verifyEmail(String email){
			EntityManagerFactory emf = Helper.getEMFactory();
			EntityManager em = emf.createEntityManager();
			
			String jpql = "select p from Principal p where p.email=?1";
			
			Query query = em.createQuery(jpql);
			query.setParameter(1, email);
			
			List<Principal> principal = query.getResultList();
			
			return principal;
		}
		
}
