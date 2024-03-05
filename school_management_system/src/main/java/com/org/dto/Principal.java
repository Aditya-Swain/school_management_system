package com.org.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
@Data
@Entity

public class Principal {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	
		private int id;
		private String name;
		private int age;
		private long mobile;
		private String qualification;
		private String email;
		private String password;
		
		@OneToOne(mappedBy = "principal")
		private School school;
		
		@OneToMany(mappedBy = "principal",  cascade = CascadeType.ALL)
		private List<Teacher> teachers;
		
		@OneToMany(mappedBy = "principal" , cascade = CascadeType.ALL)
		private List<Student> students;
}
