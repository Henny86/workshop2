package DAOs;

import java.util.List;

import POJOs.Adres;
import helpers.HibernateUtil;

public class AdresDao {
	
	HibernateUtil util = new HibernateUtil();

	public void save(Adres adres) {
		util.openCurrentSession();
		util.getCurrentSession().save(adres);
		util.closeCurrentSession();
		
	}

	public void update(Adres adres) {
		util.openCurrentSession();
		util.getCurrentSession().update(adres);
		util.closeCurrentSession();
		
	}

	public List<Adres> findAll() {
		util.openCurrentSession();
		List<Adres> adressen = (List<Adres>)util.getCurrentSession().createQuery("FROM " + Adres.class.getSimpleName()).list();
		util.closeCurrentSession();
		return adressen;
	}

	public Adres findByID(long id) {
		util.openCurrentSession();
		Adres adres = util.getCurrentSession().get(Adres.class, id);
		util.closeCurrentSession();
		return adres;
	}

	public void delete(Adres adres) {
		util.openCurrentSession();
		util.getCurrentSession().delete(adres);
		util.closeCurrentSession();
		
	}

}
