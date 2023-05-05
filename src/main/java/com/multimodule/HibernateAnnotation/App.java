package com.multimodule.HibernateAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
    	
    	SessionFactory factory = meta.getSessionFactoryBuilder().build();
    	Session session = factory.openSession();
    	Transaction t = session.getTransaction();
    	
    	Employee e = new Employee();
    	e.setId(101);    
        e.setFname("Pawan");    
        e.setLname("Sanap");    
            
        session.save(e);  
        t.commit();  
        System.out.println("successfully saved");    
        factory.close();  
        session.close(); 
        System.out.println( "Hello World!" );
    }
}
