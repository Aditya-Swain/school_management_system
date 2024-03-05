package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.org.dto.School;
import com.org.utilities.Helper;

public class SchoolDao {
	
	//save and update
	public void saveAndUpdate(School s) {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(s);
		et.commit();
	}
	
	
	//fetch school by email and password
	public List<School> fetchSchoolByEmailPassword(String email, String password){
		
		EntityManagerFactory emf = Helper.getEMFactory();
		
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select s from School s where s.email=?1 and s.password=?2";
		
		Query query = em.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<School> school = query.getResultList();
		return school;
	}
	
	
	//fetch all school
	public List<School> fetchAllSchool(){
		EntityManagerFactory emf = Helper.getEMFactory();
		
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select s from School s";
		
		Query query = em.createQuery(jpql);
		
		List<School> school = query.getResultList();
		
		return school;
	}
	
	//fetch school by id
	
	public School fetchSchoolById(int id) {
		EntityManagerFactory emf = Helper.getEMFactory();
		
		EntityManager em = emf.createEntityManager();
		
		return em.find(School.class, id);
	}
	
	//verify email
	
	public List<School> verifyByEmail(String email) {
		EntityManagerFactory emf = Helper.getEMFactory();
		
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select s from School s where s.email=?1 ";
		
		Query query = em.createQuery(jpql);
		query.setParameter(1, email);
		List school = query.getResultList();
		return school;
	}
	
}
