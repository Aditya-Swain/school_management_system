package com.org.utilities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Helper {
		private static EntityManagerFactory emf;
		
		static {
			emf = Persistence.createEntityManagerFactory("aditya");
		}
		
		public static EntityManagerFactory getEMFactory() {
			return emf;
		}
}
