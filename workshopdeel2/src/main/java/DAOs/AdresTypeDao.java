package DAOs;

import java.util.List;

import POJOs.AdresType;
import helpers.HibernateUtil;

public class AdresTypeDao {
	HibernateUtil util = new HibernateUtil();
	
	public void save(AdresType adresType) {
		util.openCurrentSession();
		util.getCurrentSession().save(adresType);
		util.closeCurrentSession();
		
	}

	public void update(AdresType adresType) {
		util.openCurrentSession();
		util.getCurrentSession().update(adresType);
		util.closeCurrentSession();
		
	}

	public List<AdresType> findAll() {
		util.openCurrentSession();
		List<AdresType> adresTypes = (List<AdresType>)util.getCurrentSession().createQuery("FROM " + AdresType.class.getSimpleName()).list();
		util.closeCurrentSession();
		return adresTypes;
	}

	public AdresType findByID(long id) {
		util.openCurrentSession();
		AdresType adresType = util.getCurrentSession().get(AdresType.class, id);
		util.closeCurrentSession();
		return adresType;
	}

	public void delete(AdresType adresType) {
		util.openCurrentSession();
		util.getCurrentSession().delete(adresType);
		util.closeCurrentSession();
		
	}

}
