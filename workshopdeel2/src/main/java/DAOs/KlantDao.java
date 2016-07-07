package DAOs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import POJOs.Klant;

public class KlantDao {
	/*private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void shutdown() {
		getSessionFactory().close();
	}
	
	public void create(Klant klant) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(klant);
		session.getTransaction().commit();
	}
	
	public List<Klant> findAll() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		List<Klant> klanten = (List<Klant>)session.createQuery("from " + Klant.class.getSimpleName()).list();
		return klanten;
	} */
	
	private Session currentSession;
	private Transaction currentTransaction;
	private static StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
	
	//haal een sessie op uit de sessionFactory
	public Session openCurrentSession() {
		return currentSession = getSessionFactory().openSession();		
	}
	
	//haal een sessie op en open een nieuwe transactie
	public Session openCurrentSessionWithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
		StandardServiceRegistryBuilder.destroy( registry );
	}
	
	public void closeCurrentSessionWithTransaction() {
		currentTransaction.commit();
		currentSession.close();
		StandardServiceRegistryBuilder.destroy( registry );
	}
	/*
	private static SessionFactory getSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	} */	
	
	private static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
	
	public void create(Klant klant) {		
		getCurrentSession().save(klant);
	}
	
	public void update(Klant klant) {
		getCurrentSession().update(klant);
	}
	
	public Klant findByID(int klantID) {
		Klant klant = (Klant)getCurrentSession().get(Klant.class, klantID);
		return klant;
	}
	
	public void delete(Klant klant) {
		getCurrentSession().delete(klant);
	}
	
	public List<Klant> findAll() {
		@SuppressWarnings("unchecked")
		List<Klant> klanten = (List<Klant>)getCurrentSession().createQuery("from " + Klant.class.getSimpleName()).list();
		return klanten;
	}
}
