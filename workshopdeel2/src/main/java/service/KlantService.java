package service;

import java.util.List;

import DAOs.KlantDao;
import POJOs.Klant;

public class KlantService {
	private static KlantDao klantDao;
	
	public KlantService() {
		klantDao = new KlantDao();
	}
	
	public void create(Klant klant) {
		klantDao.openCurrentSessionWithTransaction();
		klantDao.create(klant);
		klantDao.closeCurrentSessionWithTransaction();
	}
	
	public void update(Klant klant) {
		klantDao.openCurrentSessionWithTransaction();
		klantDao.update(klant);
		klantDao.closeCurrentSessionWithTransaction();
	}
	
	public Klant findByID(int klantID) {
		klantDao.openCurrentSession();
		Klant klant = klantDao.findByID(klantID);
		klantDao.closeCurrentSession();
		return klant;
	}
	
	public void delete(Klant klant) {
		klantDao.openCurrentSessionWithTransaction();
		klantDao.delete(klant);
		klantDao.closeCurrentSessionWithTransaction();
	}
	
	public List<Klant> findAll() {
		System.out.println("methode in service findAll");
		klantDao.openCurrentSession();
		List<Klant> klanten = klantDao.findAll();
		klantDao.closeCurrentSession();
		return klanten;
	}
}
