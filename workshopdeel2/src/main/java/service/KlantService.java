package service;

import java.util.List;

import DAOs.KlantDao;
import POJOs.Klant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class KlantService {
        
	private KlantDao klantDao;
	
        
        public KlantService( ) {
		
	}
	
        @Autowired
        public KlantService( KlantDao klantDao) {
		this.klantDao =  klantDao;
	}
	
	public void create(Klant klant) {		
		klantDao.save(klant);		
	}
	
	public void update(Klant klant) {		
		klantDao.update(klant);		
	}
	
	public Klant findByID(long klantID) {		
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
