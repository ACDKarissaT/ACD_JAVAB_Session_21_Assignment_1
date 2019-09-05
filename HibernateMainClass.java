package example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/*
 * 1. create new project
 * 2. Add required hibernate lib to build path
 * 3. in default package (src) : hibernate.cfg.xml
 * 4. add a mapping resource file: <mapping resource="message.hbm.xml" />
 * 5. Create mapping resource file: message.hbm.xml
 * 
 * 
 */
public class HibernateMainClass {
	private static SessionFactory factory;
	
	public static void main(String[] args) {
		factory = new Configuration().configure().buildSessionFactory();
		
		Message message = new Message();
		message.setMessageText("Hello World!");
		MessageNew msgNew = new MessageNew();
		msgNew.setMessageText("Message New");
		Session session = factory.getCurrentSession();
		
		Transaction tnx = session.beginTransaction();
		Integer idInserted = (Integer) session.save(msgNew);
		System.out.println("ID inserted is " + idInserted);
		idInserted = (Integer) session.save(msgNew);
		System.out.println(idInserted);
		tnx.commit();
		
		
		session.close();
	}
}
