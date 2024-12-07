package HibernateProject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ClientController
{
	public static void main(String[] args)
	{
		ClientController client = new ClientController();
		//client.addclient();
		client.completeobj();
		
		
	}
	
	public void addclient()
	{
		Configuration configuration = new Configuration();
        configuration.configure("applicationContext.xml");

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();

        Transaction t = session.beginTransaction();
        
        Client client = new Client();
        client.setName("shumayana");
        client.setAge(20);
        client.setGender("female");
        client.setLocation("vijayawada");
        client.setEmail("shu@gmail.com");
        client.setMobileno("9063228893");
        
        session.persist(client);
        t.commit();
        System.out.println("client Added Successfully");

        session.close();
        sf.close();
	}
	
	public void completeobj()
	{
		Configuration configuration = new Configuration();
        configuration.configure("applicationContext.xml");

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        
        String hql="from Client"; //select * from product_table
        
        Query<Client> qry=session.createQuery(hql,Client.class);
        List<Client> clientlist=qry.getResultList();
        System.out.println("Total clients="+clientlist.size());
        
        for(Client c:clientlist)
        {
          System.out.println("ID:"+c.getId());
          System.out.println("Name:"+c.getName());
          System.out.println("Gender:"+c.getGender());
          System.out.println("Age:"+c.getAge());
          System.out.println("Location:"+c.getLocation());
          System.out.println("Email:"+c.getEmail());
          System.out.println("Mobile:"+c.getMobileno());
          
        }
        session.close();
        sf.close();
   }
	
	
	
   
	}


