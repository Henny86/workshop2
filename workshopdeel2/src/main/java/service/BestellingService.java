package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DAOs.BestellingDao;
import POJOs.Bestelling;

@Component
public class BestellingService {

	private BestellingDao bestellingDao;

	public BestellingService() {
	}

	@Autowired
	public BestellingService(BestellingDao bestellingDao) {
		this.bestellingDao = bestellingDao;
	}

	public void create(Bestelling bestelling) {
		bestellingDao.save(bestelling);
	}

	public void update(Bestelling bestelling) {
		bestellingDao.update(bestelling);
	}

	public void delete(Bestelling bestelling) {
		bestellingDao.delete(bestelling);
	}

	public Bestelling findById(Integer id) {
		Bestelling bestelling = bestellingDao.findByID(id);
		return bestelling;
	}

	public List<Bestelling> findAll() {
		List<Bestelling> bestellingen = bestellingDao.findAll();
		return bestellingen;
	}

}
