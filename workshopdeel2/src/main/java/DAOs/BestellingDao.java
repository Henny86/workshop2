package DAOs;

import java.util.List;

import POJOs.Bestelling;
import helpers.HibernateUtil;

public class BestellingDao {
	
	HibernateUtil util = new HibernateUtil();
	
	public void save(Bestelling bestelling) {
		util.openCurrentSession();
		util.getCurrentSession().save(bestelling);
		util.closeCurrentSession();
		
	}

	public void update(Bestelling bestelling) {
		util.openCurrentSession();
		util.getCurrentSession().update(bestelling);
		util.closeCurrentSession();
		
	}

	public List<Bestelling> findAll() {
		util.openCurrentSession();
		List<Bestelling> bestellingen = (List<Bestelling>)util.getCurrentSession().createQuery("FROM " + Bestelling.class.getSimpleName()).list();
		util.closeCurrentSession();
		return bestellingen;
	}

	public Bestelling findByID(long id) {
		util.openCurrentSession();
		Bestelling bestelling = util.getCurrentSession().get(Bestelling.class, id);
		util.closeCurrentSession();
		return bestelling;
	}

	public void delete(Bestelling bestelling) {
		util.openCurrentSession();
		util.getCurrentSession().delete(bestelling);
		util.closeCurrentSession();
		
	}

}
