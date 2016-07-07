package DAOs;

import java.util.List;

import POJOs.Betaalwijze;
import helpers.HibernateUtil;

public class BetaalwijzeDao {
	
	HibernateUtil util = new HibernateUtil();
	
	public void save(Betaalwijze betaalwijze) {
		util.openCurrentSession();
		util.getCurrentSession().save(betaalwijze);
		util.closeCurrentSession();
		
	}

	public void update(Betaalwijze betaalwijze) {
		util.openCurrentSession();
		util.getCurrentSession().update(betaalwijze);
		util.closeCurrentSession();
		
	}

	public List<Betaalwijze> findAll() {
		util.openCurrentSession();
		List<Betaalwijze> betaalwijzen = (List<Betaalwijze>)util.getCurrentSession().createQuery("FROM " + Betaalwijze.class.getSimpleName()).list();
		util.closeCurrentSession();
		return betaalwijzen;
	}

	public Betaalwijze findByID(long id) {
		util.openCurrentSession();
		Betaalwijze betaalwijze = util.getCurrentSession().get(Betaalwijze.class, id);
		util.closeCurrentSession();
		return betaalwijze;
	}

	public void delete(Betaalwijze betaalwijze) {
		util.openCurrentSession();
		util.getCurrentSession().delete(betaalwijze);
		util.closeCurrentSession();
		
	}

}
