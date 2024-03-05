package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.org.dto.Principal;
import com.org.dto.Teacher;
import com.org.utilities.Helper;

public class TeacherDao {
		
	//save teacher 
			public void saveAndUpdateTeacher(Teacher teacher) {
				EntityManagerFactory emf = Helper.getEMFactory();
				EntityManager em = emf.createEntityManager();
				EntityTransaction et = em.getTransaction();
				
				et.begin();
				em.merge(teacher);
				et.commit();
				
			}
			
			//fetch teacher by email and password
			
			public List<Teacher> fetchTeacherByEmailPassword(String email, String password){
				EntityManagerFactory emf = Helper.getEMFactory();
				EntityManager em = emf.createEntityManager();
				
				String jpql = "select t from Teacher t where t.email=?1 and t.password=?2";
				
				Query query = em.createQuery(jpql);
				query.setParameter(1, email);
				query.setParameter(2, password);
				
				List<Teacher> teacher = query.getResultList();
				
				return teacher;
			}
			
			
			//fetch all teacher
			public List<Teacher> fetchAllTeacher(){
				
				EntityManagerFactory emf = Helper.getEMFactory();
				
				EntityManager em = emf.createEntityManager();
				
				String jpql = "select t from Teacher t";
				
				Query query = em.createQuery(jpql);
				
				List<Teacher> teacher = query.getResultList();
				
				return teacher;
			}
			
			//fetch principal by id
			
			public Teacher fetchTeacherById(int id) {
				EntityManagerFactory emf = Helper.getEMFactory();
				
				EntityManager em = emf.createEntityManager();
				
				return em.find(Teacher.class, id);
			}
			
			
			//delete teacher
			public void deleteTeacher(Teacher t , Principal p) {
				EntityManagerFactory emf = Helper.getEMFactory();
				EntityManager em = emf.createEntityManager();
				EntityTransaction et = em.getTransaction();
				
				et.begin();
				em.remove(t);
				em.remove(p);
				et.commit();
			}
			
			//verify email
			
			public List<Teacher> verifyEmail(String email){
				EntityManagerFactory emf = Helper.getEMFactory();
				EntityManager em = emf.createEntityManager();
				
				String jpql = "select t from Teacher t where t.email=?1";
				
				Query query = em.createQuery(jpql);
				query.setParameter(1, email);
				
				List<Teacher> teacher = query.getResultList();
				
				return teacher;
			}
}
