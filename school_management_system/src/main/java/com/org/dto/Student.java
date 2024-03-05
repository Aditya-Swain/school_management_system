package com.org.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Student {
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private int id;
				private String name;
				private int age;
				private long mobile;
				private String email;
				private String password;
				private String course;
				private String address;
				private String status;
				private String marks;
				
				@ManyToOne
				@JoinColumn
				private Principal principal;
				@ManyToOne
				@JoinColumn
				private Teacher teacher;
	
}
