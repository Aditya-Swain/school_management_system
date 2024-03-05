package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.org.dto.Principal;
import com.org.dto.Student;
import com.org.dto.Teacher;
import com.org.utilities.Helper;

public class StudentDao {
			
	//save and update student 
	public void saveAndUpdateStudent(Student student) {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(student);
		et.commit();
		
	}
	
	//fetch student by email and password
	
	public List<Student> fetchStudentByEmailPassword(String email, String password){
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select s from Student s where s.email=?1 and s.password=?2";
		
		Query query = em.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<Student>  student= query.getResultList();
		
		return student;
	}
	
	
	//fetch all student
	public List<Student> fetchAllStudent(){
		
		EntityManagerFactory emf = Helper.getEMFactory();
		
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select s from Student s";
		
		Query query = em.createQuery(jpql);
		
		List<Student> student = query.getResultList();
		
		return student;
	}
	
	//fetch principal by id
	
	public Student fetchStudentById(int id) {
		EntityManagerFactory emf = Helper.getEMFactory();
		
		EntityManager em = emf.createEntityManager();
		
		return em.find(Student.class, id);
	}
	
	//delete student
	
	public void deleteStudent(Student s ,Teacher t ,Principal p) {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.remove(s);
		em.remove(t);
		em.refresh(p);
		et.commit();
	}
	
	//verify email
	
	public List<Student> verifyEmail(String email){
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select s from Student s where s.email=?1";
		
		Query query = em.createQuery(jpql);
		query.setParameter(1, email);
		
		List<Student>  student= query.getResultList();
		
		return student;
	}
}
