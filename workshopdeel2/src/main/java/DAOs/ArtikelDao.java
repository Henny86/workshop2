package DAOs;

import java.util.List;

import POJOs.Artikel;
import helpers.HibernateUtil;

public class ArtikelDao {
	
	HibernateUtil util = new HibernateUtil();

	public void save(Artikel artikelen) {
		util.openCurrentSession();
		util.getCurrentSession().save(artikelen);
		util.closeCurrentSession();
		
	}

	public void update(Artikel artikelen) {
		util.openCurrentSession();
		util.getCurrentSession().update(artikelen);
		util.closeCurrentSession();
		
	}

	public List<Artikel> findAll() {
		util.openCurrentSession();
		List<Artikel> artikelen = (List<Artikel>)util.getCurrentSession().createQuery("FROM " + Artikel.class.getSimpleName()).list();
		util.closeCurrentSession();
		return artikelen;
	}

	public Artikel findByID(long id) {
		util.openCurrentSession();
		Artikel artikel = util.getCurrentSession().get(Artikel.class, id);
		util.closeCurrentSession();
		return artikel;
	}

	public void delete(Artikel artikelen) {
		util.openCurrentSession();
		util.getCurrentSession().delete(artikelen);
		util.closeCurrentSession();
		
	}
}
