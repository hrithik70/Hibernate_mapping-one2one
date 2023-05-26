package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.AadharDTO;
import DTO.PersonDTO;

public class PersonAadharDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection()
	{
		factory = Persistence.createEntityManagerFactory("map1");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection()
	{
		if(factory!=null)
		{
			factory.close();
		}
		
		if(manager!=null)
		{
			manager.close();
		}
		
		if(transaction!=null && transaction.isActive())
		{
			transaction.rollback();
		}
	}

	public static void main(String[] args) 
	{
		try {
			openConnection();
			transaction.begin();
			
			PersonDTO person1 = new PersonDTO();
			person1.setId(1);
			person1.setName("Hrithik");
			person1.setAddress("Pune");
			person1.setMobile(7301333267L);
			
			
			AadharDTO aadhar1 = new AadharDTO();
			aadhar1.setId(1);
			aadhar1.setAadharNumber(123456789012L);
			aadhar1.setDateOfIssue("12-05-2023");
			
			person1.setAadhar(aadhar1);
	        manager.persist(person1);
			
			aadhar1.setPerson(person1);
	        manager.persist(aadhar1);
	        
	        
			transaction.commit();
			
		} finally 
		{
			closeConnection();
			
		}

	}

}
