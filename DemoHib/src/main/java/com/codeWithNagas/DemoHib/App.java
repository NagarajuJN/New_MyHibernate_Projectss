package com.codeWithNagas.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import org.hibernate.service.spi.SessionFactoryServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		Test table = new Test();
    		table.setSid(105);
    		table.setSname("PP");
    		table.setColor("white");
    		
    		Configuration con  = new Configuration().configure().addAnnotatedClass(Test.class);
    		
    		ServiceRegistry   reg =new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    		SessionFactory sf = con.buildSessionFactory(reg);
    		
    		
    		Session session = sf.openSession();
    		
    		Transaction tx = session.beginTransaction();
    		session.save(table);
    		tx.commit();
    }
}
