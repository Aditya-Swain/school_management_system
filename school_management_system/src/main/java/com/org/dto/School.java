package com.org.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
@Data
@Entity
public class School {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		private String name;
		
		private String address;
		
		private String email;
		
		private String password;
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn
		private Principal principal;
}
