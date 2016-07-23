package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DAOs.ArtikelDao;
import POJOs.Artikel;

@Component
public class ArtikelService {
	
	private ArtikelDao artikelDao;

	public ArtikelService() {
	}

	@Autowired
	public ArtikelService(ArtikelDao artikelDao) {
		this.artikelDao = artikelDao;
	}

	public void create(Artikel artikel) {
		artikelDao.save(artikel);
	}

	public void update(Artikel artikel) {
		artikelDao.update(artikel);
	}

	public void delete(Artikel artikel) {
		artikelDao.delete(artikel);
	}
        public void delete(Long artikelID) {
		artikelDao.delete(artikelID);
	}

	public Artikel findById(long id) {
		Artikel artikelen = artikelDao.findByID(id);
		return artikelen;
	}

	public List<Artikel> findAll() {
		List<Artikel> artikelen = artikelDao.findAll();
		return artikelen;
	}

}
