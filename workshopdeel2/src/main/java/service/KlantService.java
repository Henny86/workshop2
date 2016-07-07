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
		klantDao.create(klant);		
	}
	
	public void update(Klant klant) {		
		klantDao.update(klant);		
	}
	
	public Klant findByID(int klantID) {		
		Klant klant = klantDao.findByID(klantID);		
		return klant;
	}
	
	public void delete(Klant klant) {		
		klantDao.delete(klant);		
	}
	
	public List<Klant> findAll() {		
		List<Klant> klanten = klantDao.findAll();		
		return klanten;
	}
}
