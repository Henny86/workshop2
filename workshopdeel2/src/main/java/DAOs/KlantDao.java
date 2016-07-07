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
import helpers.HibernateUtil;

public class KlantDao {
	HibernateUtil util = new HibernateUtil();
	
	public void create(Klant klant) {	
		util.openCurrentSessionWithTransaction();
		util.getCurrentSession().save(klant);
		util.closeCurrentSessionWithTransaction();
	}
	
	public void update(Klant klant) {
		util.openCurrentSessionWithTransaction();
		util.getCurrentSession().update(klant);
		util.closeCurrentSessionWithTransaction();
	}
	
	public Klant findByID(int klantID) {
		util.openCurrentSession();
		Klant klant = (Klant)util.getCurrentSession().get(Klant.class, klantID);
		util.closeCurrentSession();
		return klant;
	}
	
	public void delete(Klant klant) {
		util.openCurrentSessionWithTransaction();
		util.getCurrentSession().delete(klant);
		util.closeCurrentSessionWithTransaction();
	}
	
	public List<Klant> findAll() {
		util.openCurrentSession();
		@SuppressWarnings("unchecked")
		List<Klant> klanten = (List<Klant>)util.getCurrentSession().createQuery("from " + Klant.class.getSimpleName()).list();
		util.closeCurrentSession();
		return klanten;
	}
}
