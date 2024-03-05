package com.org.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
@Data
@Entity
public class Teacher {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
		private int age;
		private long mobile;
		private String email;
		private String password;
		private String subject;
		private String salary;
		private String status;
		
		@ManyToOne
		@JoinColumn
		private Principal principal;
		@OneToMany(mappedBy = "teacher" , cascade = CascadeType.ALL)
		private List<Student> students;
}
